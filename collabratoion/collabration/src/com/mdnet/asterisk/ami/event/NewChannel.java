package com.mdnet.asterisk.ami.event;

/*
 * ------Receive Event:------
 Event: Newchannel
 Privilege: call,all
 Channel: SIP/1000-00000014
 ChannelState: 0
 ChannelStateDesc: Down
 CallerIDNum: 1000
 CallerIDName: 
 AccountCode: 
 Exten: 9000
 Context: from-sip
 Uniqueid: 1409638154.22
 */
public class NewChannel extends EventMsg {
	protected String Channel;// : SIP/1000-00000014
	protected int ChannelState;// : 0
	protected String ChannelStateDesc;// : Down
	protected String CallerIDNum;// : 1000
	protected String CallerIDName;// :
	protected String AccountCode;// :
	protected String Exten;// : 9000
	protected String Context;// : from-sip
	protected String Uniqueid;// : 1409638154.22

	protected static String ChannelTag = "Channel:";
	protected static String ChannelStateTag = "ChannelState:";
	protected static String ChannelStateDescTag = "ChannelStateDesc:";
	protected static String CallerIDNumTag = "CallerIDNum:";
	protected static String CallerIDNameTag = "CallerIDName:";
	protected static String AccountCodeTag = "AccountCode:";
	protected static String ExtenTag = "Exten:";
	protected static String ContextTag = "Context:";
	protected static String UniqueidTag = "Uniqueid:";

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public int getChannelState() {
		return ChannelState;
	}

	public void setChannelState(int channelState) {
		ChannelState = channelState;
	}

	public String getChannelStateDesc() {
		return ChannelStateDesc;
	}

	public void setChannelStateDesc(String channelStateDesc) {
		ChannelStateDesc = channelStateDesc;
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

	public String getAccountCode() {
		return AccountCode;
	}

	public void setAccountCode(String accountCode) {
		AccountCode = accountCode;
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

	public String getUniqueid() {
		return Uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}

	public NewChannel parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}

			// protected static String ChannelTag = "Channel:";
			inx = evtMsg[i].indexOf(NewChannel.ChannelTag);
			if (inx >= 0) {
				this.setChannel(evtMsg[i].substring(
						inx + NewChannel.ChannelTag.length()).trim());
				continue;
			}
			// protected static String ChannelStateTag = "ChannelState:";
			inx = evtMsg[i].indexOf(NewChannel.ChannelStateTag);
			if (inx >= 0) {
				this.setChannelState(this.toInt(evtMsg[i].substring(
						inx + NewChannel.ChannelStateTag.length()).trim()));
				continue;
			}
			// protected static String ChannelStateDescTag =
			// "ChannelStateDesc:";
			inx = evtMsg[i].indexOf(NewChannel.ChannelStateDescTag);
			if (inx >= 0) {
				this.setChannelStateDesc(evtMsg[i].substring(
						inx + NewChannel.ChannelStateDescTag.length()).trim());
				continue;
			}
			// protected static String CallerIDNumTag = "CallerIDNum:";
			inx = evtMsg[i].indexOf(NewChannel.CallerIDNumTag);
			if (inx >= 0) {
				this.setCallerIDNum(evtMsg[i].substring(
						inx + NewChannel.CallerIDNumTag.length()).trim());
				continue;
			}
			// protected static String CallerIDNameTag = "CallerIDName:";
			inx = evtMsg[i].indexOf(NewChannel.CallerIDNameTag);
			if (inx >= 0) {
				this.setCallerIDName(evtMsg[i].substring(
						inx + NewChannel.CallerIDNameTag.length()).trim());
				continue;
			}
			// protected static String AccountCodeTag = "AccountCode:";
			inx = evtMsg[i].indexOf(NewChannel.AccountCodeTag);
			if (inx >= 0) {
				this.setAccountCode(evtMsg[i].substring(
						inx + NewChannel.AccountCodeTag.length()).trim());
				continue;
			}
			// protected static String ExtenTag = "Exten:";
			inx = evtMsg[i].indexOf(NewChannel.ExtenTag);
			if (inx >= 0) {
				this.setExten(evtMsg[i].substring(
						inx + NewChannel.ExtenTag.length()).trim());
				continue;
			}
			// protected static String ContextTag = "Context:";
			inx = evtMsg[i].indexOf(NewChannel.ContextTag);
			if (inx >= 0) {
				this.setContext(evtMsg[i].substring(
						inx + NewChannel.ContextTag.length()).trim());
				continue;
			}
			// protected static String UniqueidTag = "Uniqueid:";
			inx = evtMsg[i].indexOf(NewChannel.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + NewChannel.UniqueidTag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
