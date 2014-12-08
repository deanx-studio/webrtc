package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.CallHistory;
import net.zhinet.travel.pojo.basepojo.TerminateInfo;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.asterisk.action.OriginateAction;
import com.mdnet.asterisk.ami.AMIBase;
import com.mdnet.asterisk.ami.ResponseMsg;
import com.mdnet.travel.core.model.TermConfig;
import com.mdnet.travel.core.service.IAdminService;
import com.mdnet.travel.core.service.ICallService;
import com.mdnet.travel.core.service.impl.ParamConfigInstance;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService callService;

	@Resource(name = IAdminService.SERVICE_NAME)
	private IAdminService adminService;

	@RequestMapping("/home")
	public ModelAndView homePage() {
		this.createMav(null);
		this.mav.setViewName("user/home");
		return this.mav;
	}

	@RequestMapping("/2calls")
	public ModelAndView ShowTerminate() {
		this.createMav(null);

		this.mav.setViewName("user/term2calls");

		// this.mav.addObject("displayName", id);
		// this.mav.addObject("privateIdentity", id);
		// this.mav.addObject("publicIdentity", "sip:" + id + "@deanx.cn");
		// this.mav.addObject("passwd", id);
		this.mav.addObject("realm", "asterisk");
		return this.mav;
	}

	@RequestMapping("/term/config")
	@ResponseBody
	public String getTermConfig(
			@RequestParam(value = "termId", required = true) int termId) {
		TermConfig tc = new TermConfig();
		tc.setDomain(ParamConfigInstance.inst().getDomain());
		tc.setWebsocket_proxy_url(ParamConfigInstance.inst().getWebsocket_proxy_url());
		tc.setOutbound_proxy_url(ParamConfigInstance.inst().getOutbound_proxy_url());
		tc.setIce_servers(ParamConfigInstance.inst().getIce_servers());
		tc.setRealm(ParamConfigInstance.inst().getRealm());
		TerminateInfo ti = this.callService.findTerm(String.valueOf(termId));
		if (ti != null) {
			tc.setTermId(termId);
			tc.setTermPwd(ti.getDevicePassword());
			tc.setTermSate(ti.getChannelState());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tc.setLastRegisterTime(sdf.format(ti.getLastRegisterTime()));
			tc.setLastEndCallTime(sdf.format(ti.getLastCallEndTime()));
		}
		Gson g = new Gson();
		return "[" + g.toJson(tc) + "]";
	}

	@RequestMapping("/term/add")
	@ResponseBody
	public String termAdd(
			@RequestParam(value = "uid", required = true) String uid,
			@RequestParam(value = "uname", required = true) String uname,
			@RequestParam(value = "termId", required = true) String termId) {
		TerminateInfo ti = this.callService.findTerm(termId);
		if (ti == null) {
			ti = new TerminateInfo();
			ti.setPeer("SIP/" + termId);
			ti.setPeerStatus("Unregistered");
			ti.setCause("Init");
			ti.setDevicePassword(termId);
			ti.setChannelState(-2);

			this.callService.save(ti);
		}

		String hz = "汉字编码";
		try {
			uname = new String(uname.getBytes("iso-8859-1"), "UTF-8");
			hz = java.net.URLEncoder.encode(hz, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo ui = this.adminService.getUserInfo(uname);
		if (ui == null) {
			this.adminService.insertUserInfo(uname, "tld123456", "",
					"ROLE_USER", termId);
		} else {
			ui.setTerminateNumber(termId);
			this.adminService.updateUserInfo(ui.getId(), ui.getUsername(),
					null, ui.getMobile(), ui.getAuthority(), termId);
		}

		return "success";
	}

	@RequestMapping("/term")
	public ModelAndView ShowTerminate(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "head", required = false) String head) {
		this.createMav(id);
		if (head == null || head.compareTo("true") == 0)
			this.mav.setViewName("user/term");
		else
			this.mav.setViewName("nohead/user/term");

		if (id == null) {
			// 从登录数据中获取id
			String name = SecurityContextHolder.getContext()
					.getAuthentication().getName();
			UserInfo ui = this.adminService.getUserInfo(name);
			if (ui != null) {
				id = ui.getTerminateNumber();

			}
		}

		if (id != null) {

			List<CallHistory> calls = this.callService.findHistory(
					"where localPeer='SIP/" + id + "' or remotePeer ='" + id
							+ "' order by makeTime desc", 0, 5);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (CallHistory call : calls) {
				// 计算呼叫时长
				if (call.getStatus() == 6) {

					try {
						long length;
						length = sdf.parse(call.getEndTime()).getTime() / 1000
								- sdf.parse(call.getMakeTime()).getTime()
								/ 1000;
						// if(length>=60)
						call.setCallLength(String.valueOf(length));
						// else
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					call.setCallLength("0");
				}
				
				call.setEndTime(call.getEndTime().substring(5));
				if (call.getRemotePeer().compareTo(id) == 0){
					call.setCallType(1);//被叫
					call.setRemotePeer(call.getLocalPeer().substring(4));
				}
				else
				{
					call.setCallType(0);//主叫
				}
			}
			this.mav.addObject("callList", calls);

			// sip相关数据
			TerminateInfo ti = this.callService.findTerm(id);
			if (ti != null) {
				this.mav.addObject("domain", "sip.deanx.cn");
				this.mav.addObject("wsServers", "ws://deanx.cn:10060");
				// String ws_server=
				// "{'scheme':'WSS','sip_uri':'<sip:deanx.cn;transport=udp;lr>','status':0,'weight':0,'ws_uri':'ws://deanx.cn:10060'}";
				// this.mav.addObject("wsServers", ws_server);
				this.mav.addObject("uri", "sip:" + id + "@sip.deanx.cn:5060");
				this.mav.addObject("authorizationUser", id);
				this.mav.addObject("password", ti.getDevicePassword());
			}
			this.mav.addObject("termId", id);
			this.mav.addObject("message", "您现在使用的终端号码是：" + id);
		} else {
			this.mav.addObject("message", "没有找到相关数据");
		}
		return this.mav;
	}

	@RequestMapping("/makeCall")
	@ResponseBody
	public String makeCall(
			@RequestParam(value = "callee", required = true) String callee) {
		OriginateAction msg = new OriginateAction();
		msg.setChannel("SIP/" + callee);
		msg.setExten(callee);
		msg.setAsync("true");
		msg.setContext("LocalExtensions");
		msg.setPriority(1);
		msg.setTimeout(30000);
		msg.setCallerID(" \"asterisk \" <" + callee + ">");

		ResponseMsg respMsg = AMIBase.instance().sendAction(msg);
		return String.valueOf(respMsg.getResponse() + ":"
				+ respMsg.getMessage());

	}

	@RequestMapping("/receiveCall")
	public ModelAndView receiveCall(
			@RequestParam(value = "id", required = true) String id) {
		this.createMav(id);
		this.mav.setViewName("sipjs/receiveCall");
		this.mav.addObject("id", id);
		return this.mav;
	}
}
