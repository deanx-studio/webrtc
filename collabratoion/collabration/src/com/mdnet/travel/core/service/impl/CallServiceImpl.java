package com.mdnet.travel.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.CallHistory;
import net.zhinet.travel.pojo.basepojo.TerminateInfo;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdnet.asterisk.ami.event.EventMsg;
import com.mdnet.asterisk.ami.event.Hangup;
import com.mdnet.asterisk.ami.event.NewChannel;
import com.mdnet.asterisk.ami.event.NewExten;
import com.mdnet.asterisk.ami.event.NewState;
import com.mdnet.asterisk.ami.event.PeerStatusMsg;
import com.mdnet.travel.core.dao.ICallHistoryDAO;
import com.mdnet.travel.core.dao.ITerminateInfo;
import com.mdnet.travel.core.dao.IUserInfoDAO;
import com.mdnet.travel.core.service.ICallService;

@Service(ICallService.SERVICE_NAME)
@Scope("prototype")
@Transactional(readOnly = false)
public class CallServiceImpl implements ICallService {
	@Resource(name = ITerminateInfo.DAO_NAME)
	protected ITerminateInfo termDAO;

	@Resource(name = ICallHistoryDAO.DAO_NAME)
	protected ICallHistoryDAO callHistory;

	@Resource(name = IUserInfoDAO.DAO_NAME)
	protected IUserInfoDAO userDAO;

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected Date convertDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return sdf.parse(d);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateRegister(PeerStatusMsg msg) {
		String where = " where Peer = '" + msg.getPeer() + "'";
		int pageNo = 0;

		List<TerminateInfo> terms = termDAO.find(where, pageNo);
		if (terms != null && terms.size() > 0) {
			TerminateInfo ti = terms.get(0);
			ti.setAddress(msg.getAddress());
			ti.setCause(msg.getCause());
			ti.setChannelType(msg.getChannelType());
			ti.setPeerStatus(msg.getPeerStatus());

			ti.setChannelType("");
			ti.setChannel("");
			ti.setChannelStateDesc(msg.getPeerStatus());
			if (ti.getChannelState() < 0) {
				if (msg.getPeerStatus().contains("Registered")) {
					ti.setChannelState(-1);// 空闲
					ti.setLastRegisterTime(this.convertDate(msg.getTime()));
				} else {
					ti.setChannelState(-2);// 不可用
					ti.setChannelStateDesc("");
					ti.setUnRegisterTime(this.convertDate(msg.getTime()));
				}

				// 更新数据
				termDAO.update(ti);
			}
		} else {
			TerminateInfo ti = new TerminateInfo();
			ti.setAddress(msg.getAddress());
			ti.setCause(msg.getCause());
			ti.setChannelType(msg.getChannelType());
			ti.setPeerStatus(msg.getPeerStatus());

			// String peer = msg.getPeer().substring(
			// msg.getChannelType().length() + 1);
			ti.setPeer(msg.getPeer());
			ti.setChannelStateDesc(msg.getPeerStatus());
			ti.setChannelType("");
			ti.setChannel("");
			if (msg.getPeerStatus().contains("Registered")) {
				ti.setChannelState(-1);// 空闲
				ti.setLastRegisterTime(this.convertDate(msg.getTime()));
			} else {
				ti.setUnRegisterTime(this.convertDate(msg.getTime()));
				ti.setChannelState(-2);// 不可用
			}
			this.termDAO.save(ti);
		}

	}

	@Override
	public void newChannel(NewChannel msg) {
		String channel[] = msg.getChannel().split("-");
		String peer = channel[0];

		String where = " where Peer = '" + peer + "'";
		int pageNo = 0;
		List<TerminateInfo> terms = termDAO.find(where, pageNo);
		if (terms != null && terms.size() > 0) {
			TerminateInfo ti = terms.get(0);
			ti.setChannel(msg.getChannel());
			ti.setChannelState(msg.getChannelState());
			ti.setChannelStateDesc(msg.getChannelStateDesc());
			ti.setCallerIDNum(msg.getCallerIDNum());
			ti.setCallerIDName(msg.getCallerIDName());
			ti.setAccountCode(msg.getAccountCode());
			ti.setExten(msg.getExten());
			ti.setContext(msg.getContext());
			ti.setUniqueid(msg.getUniqueid());
			this.termDAO.update(ti);
		}
		// 保存呼叫记录
		// exten有值的认为是主叫
		if (msg.getExten() != null && msg.getExten().length() > 0) {
			List<CallHistory> ch = this.callHistory.findByHQL("where channel='"
					+ msg.getChannel() + "'", 0, 4);
			if (ch == null || ch.size() == 0) {
				CallHistory call = new CallHistory();
				call.setLocalPeer(peer);
				call.setRemotePeer(msg.getExten());
				call.setMakeTime(sdf.format(new Date()));
				call.setEndTime(sdf.format(new Date()));
				call.setChannel(msg.getChannel());
				call.setStatus(1);
				callHistory.save(call);
				logger.info("insert call history->caller:"
						+ call.getLocalPeer() + ",channel:" + call.getChannel());
			}
		}
	}

	@Override
	public void updateCall(EventMsg msg) {

		String where = " where Channel = '";
		String className = msg.getClass().toString();
		if (className.contains("NewState")) {
			NewState newState = (NewState) msg;
			where += newState.getChannel();
			// 更新历史呼叫
			this.callHistory.updateHistory(newState.getChannel(),
					newState.getChannelState());
			logger.info("update call history->channel:" + newState.getChannel()
					+ ",state:" + newState.getChannelStateDesc() + "("
					+ newState.getChannelState() + ")");

		} else if (className.contains("NewExten")) {
			NewExten newExten = (NewExten) msg;
			where += newExten.getChannel();
		} else
			return;
		where += "'";
		int pageNo = 0;
		List<TerminateInfo> terms = termDAO.find(where, pageNo);
		if (terms != null && terms.size() > 0) {
			TerminateInfo ti = terms.get(0);
			if (className.contains("NewState")) {
				NewState newState = (NewState) msg;
				ti.setChannelState(newState.getChannelState());
				ti.setChannelStateDesc(newState.getChannelStateDesc());
				ti.setCallerIDNum(newState.getCallerIDNum());
				ti.setCallerIDName(newState.getCallerIDName());
				ti.setConnectedLineNum(newState.getConnectedLineNum());
				ti.setConnectedLineName(newState.getConnectedLineName());
				ti.setLastCallStartTime(this.convertDate(msg.getTime()));
			} else if (className.contains("NewExten")) {
				NewExten newExten = (NewExten) msg;
				ti.setContext(newExten.getContext());
				ti.setExten(newExten.getExtension());
				ti.setPriority(newExten.getPriority());
				ti.setApplication(newExten.getApplication());
				ti.setAppData(newExten.getAppData());
			}

			this.termDAO.update(ti);
		}

	}

	@Override
	public void hangup(Hangup msg) {
		String where = " where Channel = '" + msg.getChannel() + "'";
		int pageNo = 0;
		List<TerminateInfo> terms = termDAO.find(where, pageNo);
		if (terms != null && terms.size() > 0) {
			TerminateInfo ti = terms.get(0);
			Hangup hangup = (Hangup) msg;
			ti.setCallerIDNum(hangup.getCallerIDNum());
			ti.setCallerIDName(hangup.getCallerIDName());
			ti.setConnectedLineNum(hangup.getConnectedLineNum());
			ti.setConnectedLineName(hangup.getConnectedLineName());
			ti.setAccountCode(hangup.getAccountCode());
			ti.setCause(hangup.getCause());
			ti.setCauseText(hangup.getCauseTxt());
			ti.setChannelState(-1);// 空闲
			ti.setChannelStateDesc("hangup");
			ti.setLastCallEndTime(this.convertDate(msg.getTime()));
			this.termDAO.update(ti);
		}
	}

	@Override
	public List<TerminateInfo> findTerm(int pageNo) {
		return termDAO.find("", pageNo);
	}

	@Override
	public List<CallHistory> findHistory(String where, int page, int count) {
		return this.callHistory.findByHQL(where, page, count);
	}

	@Override
	public TerminateInfo findTerm(String id) {
		List<TerminateInfo> ti = termDAO.find(" where Peer='SIP/" + id + "' ",
				0);
		if (ti != null && ti.size() > 0)
			return ti.get(0);
		else
			return null;
	}

	@Override
	public void save(TerminateInfo ti) {
		this.termDAO.save(ti);
	}

	@Override
	public List<TerminateInfo> listTerm(String status, String peer,
			String name, int pageNo, int pageCount) {
		// 更具名字获取终端号
		if (name != null) {
			List<UserInfo> ui = this.userDAO.findByHQL(" where username='"
					+ name + "'", 0);
			if (ui != null && ui.size() > 0)
				peer = ui.get(0).getTerminateNumber();
		}
		String query = "";
		if (peer != null)
			query = " where Peer = 'SIP/" + peer + "'";
		if (status != null)
			query = " where ChannelState " + status + "";
		List<TerminateInfo> tis = this.termDAO.find(query, pageNo);
		return tis;
	}

}