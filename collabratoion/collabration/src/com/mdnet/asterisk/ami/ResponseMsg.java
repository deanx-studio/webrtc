package com.mdnet.asterisk.ami;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * -----Receive Response:-------
 Response: Success
 ActionID: 0
 Message: Authentication accepted
 */
public class ResponseMsg {
	public final static String ResponseTag = "Response:";
	public final static String ActionIDTag = "ActionID:";
	public final static String MessageTag = "Message:";
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public ResponseMsg() {
		
		this.respTime = ResponseMsg.sdf.format(new Date());
	}

	protected String respTime;

	public String getRespTime() {
		return respTime;
	}

	protected String Response;// : Success
	protected int ActionID;// : 0
	protected String Message;// : Authentication accepted

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public int getActionID() {
		return ActionID;
	}

	public void setActionID(int actionID) {
		ActionID = actionID;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public ResponseMsg parse(String[] respMsg) {

		for (int i = 0; i < respMsg.length; i++) {
			int inx = respMsg[i].indexOf(ResponseMsg.ResponseTag);
			if (inx >= 0) {
				this.setResponse(respMsg[i].substring(inx
						+ ResponseMsg.ResponseTag.length()).trim());
				continue;
			}
			inx = respMsg[i].indexOf(ResponseMsg.ActionIDTag);
			if (inx >= 0) {
				String aid = respMsg[i].substring(inx
						+ ResponseMsg.ActionIDTag.length());
				this.setActionID(Integer.parseInt(aid.trim()));
				continue;
			}
			inx = respMsg[i].indexOf(ResponseMsg.MessageTag);
			if (inx >= 0) {
				this.setMessage(respMsg[i].substring(inx
						+ ResponseMsg.MessageTag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
