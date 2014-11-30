package com.mdnet.asterisk.action;

import com.mdnet.asterisk.ami.ActionMsg;

/*
 * Action: Originate
 Channel: SIP/myphone
 Exten: 6001
 Context: LocalExtensions
 Priority: 1
 Timeout: 30000
 CallerID: "Asterisk" <6000>
 Async: true
 */
public class OriginateAction extends ActionMsg {

	public OriginateAction() {
		this.Action = "Originate";
	}

	private String Channel;// : SIP/myphone
	private String Exten;// : 6001
	private String Context;// : LocalExtensions
	private int Priority = 1;
	private int Timeout = 30000;
	private String CallerID;// : "Asterisk" <6000>
	private String Async = "true";
	private String Variable = null;

	public String getVariable() {
		return Variable;
	}

	public void setVariable(String variable) {
		Variable = variable;
	}

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getExten() {
		return Exten;
	}

	public void setExten(String exten) {
		Exten = exten;
	}

	public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		Context = context;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public int getTimeout() {
		return Timeout;
	}

	public void setTimeout(int timeout) {
		Timeout = timeout;
	}

	public String getCallerID() {
		return CallerID;
	}

	public void setCallerID(String callerID) {
		CallerID = callerID;
	}

	public String getAsync() {
		return Async;
	}

	public void setAsync(String async) {
		Async = async;
	}

	public String toString() {

		String msg = super.toString();
		msg += "Channel: " + this.Channel + "\r\n";
		msg += "Exten: " + this.Exten + "\r\n";
		msg += "Context: " + this.Context + "\r\n";
		msg += "Priority: " + this.Priority + "\r\n";
		msg += "Timeout: " + this.Timeout + "\r\n";
		msg += "CallerID: " + this.CallerID + "\r\n";
		if (this.Variable != null) {
			msg += "Variable: " + this.Variable + "\r\n";
		}
		msg += "Async: " + this.Async + "\r\n\r\n";
		return msg;
	}
}
