package com.mdnet.asterisk.ami.event;

/*
 * ------Receive Event:------
 Event: Newstate
 Privilege: call,all
 Channel: SIP/1000-00000014
 ChannelState: 4
 ChannelStateDesc: Ring
 CallerIDNum: 1000
 CallerIDName: 
 ConnectedLineNum: 
 ConnectedLineName: 
 Uniqueid: 1409638154.22
 */
public class NewState extends EventMsg {

	protected String Channel;// : SIP/1000-00000014
	protected int ChannelState;// : 0
	protected String ChannelStateDesc;// : Down
	protected String CallerIDNum;// : 1000
	protected String CallerIDName;// :
	protected int ConnectedLineNum;
	protected String ConnectedLineName;
	protected String Uniqueid;// : 1409638154.22

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

	public String getUniqueid() {
		return Uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}

	public static String getCallerIDNumTag() {
		return CallerIDNumTag;
	}

	public static void setCallerIDNumTag(String callerIDNumTag) {
		CallerIDNumTag = callerIDNumTag;
	}

	public static String getCallerIDNameTag() {
		return CallerIDNameTag;
	}

	public static void setCallerIDNameTag(String callerIDNameTag) {
		CallerIDNameTag = callerIDNameTag;
	}

	protected static String ChannelTag = "Channel:";
	protected static String ChannelStateTag = "ChannelState:";
	protected static String ChannelStateDescTag = "ChannelStateDesc:";
	protected static String CallerIDNumTag = "CallerIDNum:";
	protected static String CallerIDNameTag = "CallerIDName:";
	protected static String ConnectedLineNumTag = "ConnectedLineNum:";
	protected static String ConnectedLineNameTag = "ConnectedLineName:";
	protected static String UniqueidTag = "Uniqueid:";

	public NewState parse(String evtName, String[] evtMsg) {
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
						inx + NewState.ChannelTag.length()).trim());
				continue;
			}
			// protected static String ChannelStateTag = "ChannelState:";
			inx = evtMsg[i].indexOf(NewState.ChannelStateTag);
			if (inx >= 0) {
				this.setChannelState(this.toInt(evtMsg[i].substring(
						inx + NewState.ChannelStateTag.length()).trim()));
				continue;
			}
			// protected static String ChannelStateDescTag =
			// "ChannelStateDesc:";
			inx = evtMsg[i].indexOf(NewState.ChannelStateDescTag);
			if (inx >= 0) {
				this.setChannelStateDesc(evtMsg[i].substring(
						inx + NewState.ChannelStateDescTag.length()).trim());
				continue;
			}
			// protected static String CallerIDNumTag = "CallerIDNum:";
			inx = evtMsg[i].indexOf(NewState.CallerIDNumTag);
			if (inx >= 0) {
				this.setCallerIDNum(evtMsg[i].substring(
						inx + NewState.CallerIDNumTag.length()).trim());
				continue;
			}
			// protected static String CallerIDNameTag = "CallerIDName:";
			inx = evtMsg[i].indexOf(NewState.CallerIDNameTag);
			if (inx >= 0) {
				this.setCallerIDName(evtMsg[i].substring(
						inx + NewState.CallerIDNameTag.length()).trim());
				continue;
			}
			// protected static String AccountCodeTag = "ConnectedLineName:";
			inx = evtMsg[i].indexOf(NewState.ConnectedLineNameTag);
			if (inx >= 0) {
				this.setConnectedLineName(evtMsg[i].substring(
						inx + NewState.ConnectedLineNameTag.length()).trim());
				continue;
			}
			// protected static String ExtenTag = "ConnectedLineNum:";
			inx = evtMsg[i].indexOf(NewState.ConnectedLineNumTag);
			if (inx >= 0) {
				String lineNumStr = evtMsg[i].substring(
						inx + NewState.ConnectedLineNumTag.length()).trim();

				int lineNum = 0;
				try {
					lineNum = Integer.parseInt(lineNumStr);
				} catch (Exception e) {

				}
				this.setConnectedLineNum(lineNum);
				continue;
			}

			// protected static String UniqueidTag = "Uniqueid:";
			inx = evtMsg[i].indexOf(NewState.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + NewState.UniqueidTag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
