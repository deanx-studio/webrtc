package com.mdnet.asterisk.ami;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseNotify {
	HashMap<Integer, ResponseMsg> mapResp = new HashMap<Integer, ResponseMsg>();
	private String respText;
	Map<Integer, ActionQuene> actionQuene = new HashMap<Integer, ActionQuene>();
	protected ActionQuene _newActionQuene;
	protected Logger logger = LoggerFactory.getLogger(getClass());

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
		mapResp.put(msg.getActionID(), msg);
		System.out.println(msg.getResponse() + ":" + msg.getMessage());
	}

	public void onResponse(ActionQuene msg) {
		if (msg.getActionName().contains("")) {

		} else {
			System.out.println(msg.respMsg.getResponse() + ":"
					+ msg.respMsg.getMessage());
		}
	}

	public ResponseMsg getResp(int actionId) {

		// 删除过期的消息
		long now = (new Date()).getTime();
		Iterator<Integer> iter = mapResp.keySet().iterator();
		while (iter.hasNext()) {
			int id = (Integer) iter.next();
			ResponseMsg r = this.mapResp.get(id);
			try {
				Date d = ResponseMsg.sdf.parse(r.getRespTime());
				if (now - d.getTime() > 30 * 1000) {
					logger.debug("actionId:" + r.getActionID()
							+ " had time out, system had removed it, context="
							+ r.getMessage() + ":" + r.getResponse());
					//iter.remove();
					this.mapResp.remove(r.getActionID());
					// 重新开始计数
					iter = mapResp.keySet().iterator();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// 获取本次的消息
		for (int i = 0; i < 10; i++) {
			ResponseMsg msg = this.mapResp.get(actionId);
			if (msg != null) {
				return msg;
				//break;

			}
			else
			{
				try {
					Thread.sleep(1000*1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
