package com.mdnet.asterisk.ami.event;

/*
 * ------Receive Event:------
 Event: Hangup
 Privilege: call,all
 Channel: SIP/1000-00000018
 Uniqueid: 1409714276.26
 CallerIDNum: 1000
 CallerIDName: <unknown>
 ConnectedLineNum: <unknown>
 ConnectedLineName: <unknown>
 AccountCode: 
 Cause: 16
 Cause-txt: Normal Clearing
 */
public class Hangup extends EventMsg {

	public static String ChannelTag = "Channel:";// SIP/1000-00000018
	public static String UniqueidTag = "Uniqueid:";// 1409714276.26
	public static String CallerIDNumTag = "CallerIDNum:";// 1000
	public static String CallerIDNameTag = "CallerIDName:";// <unknown>
	public static String ConnectedLineNumTag = "ConnectedLineNum:";// <unknown>
	public static String ConnectedLineNameTag = "ConnectedLineName:";// <unknown>
	public static String AccountCodetag = "AccountCode:";//
	public static String CauseTag = "Cause:";// 16
	public static String CauseTxtTag = "Cause-txt:";// Normal Clearing

	protected String Channel;// : SIP/1000-00000018
	protected String Uniqueid;// : 1409714276.26
	protected String CallerIDNum;// : 1000
	protected String CallerIDName;// : <unknown>
	protected int ConnectedLineNum;// : <unknown>
	protected String ConnectedLineName;// : <unknown>
	protected String AccountCode;// :
	protected String Cause;// : 16
	protected String CauseTxt;// : Normal Clearing

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getUniqueid() {
		return Uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}

	public String getCallerIDNum() {
		return CallerIDNum;
	}

	public void setCallerIDNum(String callerIDNum) {
		CallerIDNum = callerIDNum;
	}

	public String getCallerIDName() {
		return CallerIDName;
	}

	public void setCallerIDName(String callerIDName) {
		CallerIDName = callerIDName;
	}

	public int getConnectedLineNum() {
		return ConnectedLineNum;
	}

	public void setConnectedLineNum(int connectedLineNum) {
		ConnectedLineNum = connectedLineNum;
	}

	public String getConnectedLineName() {
		return ConnectedLineName;
	}

	public void setConnectedLineName(String connectedLineName) {
		ConnectedLineName = connectedLineName;
	}

	public String getAccountCode() {
		return AccountCode;
	}

	public void setAccountCode(String accountCode) {
		AccountCode = accountCode;
	}

	public String getCause() {
		return Cause;
	}

	public void setCause(String cause) {
		Cause = cause;
	}

	public String getCauseTxt() {
		return CauseTxt;
	}

	public void setCauseTxt(String causeTxt) {
		CauseTxt = causeTxt;
	}

	public Hangup parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}

			// protected static String ChannelTag = "Channel:";
			inx = evtMsg[i].indexOf(Hangup.ChannelTag);
			if (inx >= 0) {
				this.setChannel(evtMsg[i].substring(
						inx + Hangup.ChannelTag.length()).trim());
				continue;
			}
			// protected String Uniqueid;// : 1409714276.26
			inx = evtMsg[i].indexOf(Hangup.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + Hangup.UniqueidTag.length()).trim());
				continue;
			}
			// protected String CallerIDNum;// : 1000
			inx = evtMsg[i].indexOf(Hangup.CallerIDNumTag);
			if (inx >= 0) {
				this.setCallerIDNum(evtMsg[i].substring(
						inx + Hangup.CallerIDNumTag.length()).trim());
				continue;
			}
			// protected String CallerIDName;// : <unknown>
			inx = evtMsg[i].indexOf(Hangup.CallerIDNameTag);
			if (inx >= 0) {
				this.setCallerIDName(evtMsg[i].substring(
						inx + Hangup.CallerIDNameTag.length()).trim());
				continue;
			}
			// protected String ConnectedLineNum;// : <unknown>
			inx = evtMsg[i].indexOf(Hangup.ConnectedLineNumTag);
			if (inx >= 0) {
				String lineNum = evtMsg[i].substring(
						inx + Hangup.ConnectedLineNumTag.length()).trim();
				this.setConnectedLineNum(this.toInt(lineNum));
				continue;
			}
			// protected String ConnectedLineName;// : <unknown>
			inx = evtMsg[i].indexOf(Hangup.ConnectedLineNameTag);
			if (inx >= 0) {
				this.setConnectedLineName(evtMsg[i].substring(
						inx + Hangup.ConnectedLineNameTag.length()).trim());
				continue;
			}
			// protected String AccountCode;// :
			inx = evtMsg[i].indexOf(Hangup.AccountCodetag);
			if (inx >= 0) {
				this.setAccountCode(evtMsg[i].substring(
						inx + Hangup.AccountCodetag.length()).trim());
				continue;
			}
			// protected String Cause;// : 16
			inx = evtMsg[i].indexOf(Hangup.CauseTag);
			if (inx >= 0) {
				this.setCause(evtMsg[i].substring(
						inx + Hangup.CauseTag.length()).trim());
				continue;
			}
			// protected String CauseTxt;// : Normal Clearing
			inx = evtMsg[i].indexOf(Hangup.CauseTxtTag);
			if (inx >= 0) {
				this.setCauseTxt(evtMsg[i].substring(
						inx + Hangup.CauseTxtTag.length()).trim());
				continue;
			}

		}
		return this;
	}
}
