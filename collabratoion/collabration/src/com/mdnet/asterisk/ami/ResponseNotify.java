package com.mdnet.asterisk.ami;

import java.util.HashMap;
import java.util.Map;

public class ResponseNotify {
	private String respText;
	Map<Integer, ActionQuene> actionQuene = new HashMap<Integer, ActionQuene>();
	protected ActionQuene _newActionQuene;

	public synchronized void add(int actionId, ActionMsg actionMsg) {
		return;
		// _newActionQuene = new ActionQuene(actionId, actionMsg);
		// actionQuene.put(actionId, _newActionQuene);
	}

	public void fireResponse(String RespText) {
		this.respText = RespText;
		System.out.println("-----Receive Response:-------\r\n" + this.respText);
		String[] respMsg = RespText.split("\r\n");

		if (respMsg.length > 2) {
			ResponseMsg msg = parseResp(respMsg);
			this.onResponse(msg);
			// ActionQuene aq = this.actionQuene.get(msg.getActionID());
			// this.onResponse(aq);
			// this.actionQuene.remove(msg.getActionID());
		}
	}

	private ResponseMsg parseResp(String[] respMsg) {
		ResponseMsg msg = new ResponseMsg();
		msg.parse(respMsg);
		return msg;

	}

	public void onResponse(ResponseMsg msg) {
		System.out.println(msg.getResponse() + ":" + msg.getMessage());
	}

	public void onResponse(ActionQuene msg) {
		if (msg.getActionName().contains("")) {

		} else {
			System.out.println(msg.respMsg.getResponse() + ":"
					+ msg.respMsg.getMessage());
		}
	}
}
