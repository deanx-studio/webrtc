package com.mdnet.travel.core.service;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.CallHistory;
import net.zhinet.travel.pojo.basepojo.TerminateInfo;

import com.mdnet.asterisk.ami.event.Bridge;
import com.mdnet.asterisk.ami.event.EventMsg;
import com.mdnet.asterisk.ami.event.Hangup;
import com.mdnet.asterisk.ami.event.HangupRequest;
import com.mdnet.asterisk.ami.event.NewChannel;
import com.mdnet.asterisk.ami.event.PeerStatusMsg;

public interface ICallService {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.CallServiceImpl";

	void updateRegister(PeerStatusMsg msg);

	void newChannel(NewChannel msg);

	void updateCall(EventMsg msg);

	void hangup(Hangup msg);

	List<TerminateInfo> findTerm(int pageNo);

	List<CallHistory> findHistory(String where, int page, int count);

	TerminateInfo findTerm(String id);

	void save(TerminateInfo ti);

	List<TerminateInfo> listTerm(String status, String peer, String peers,
			String name, int pageNo, int pageCount);

	void bridge(Bridge msg);

	void updateTerm(TerminateInfo ti);

	void hangupRequest(HangupRequest msg);

}
