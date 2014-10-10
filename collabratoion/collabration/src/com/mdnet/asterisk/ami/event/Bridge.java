package com.mdnet.asterisk.ami.event;

/*
 Event: Bridge
 Privilege: call,all
 Bridgestate: Unlink
 Bridgetype: core
 Channel1: SIP/2000-00000004
 Channel2: SIP/2001-00000005
 Uniqueid1: 1412931452.4
 Uniqueid2: 1412931452.5
 CallerID1: 2000
 CallerID2: 2001
 **************************
 Event: Bridge
 Privilege: call,all
 Bridgestate: Link
 Bridgetype: core
 Channel1: SIP/2000-00000006
 Channel2: SIP/2001-00000007
 Uniqueid1: 1412931683.6
 Uniqueid2: 1412931683.7
 CallerID1: 2000
 CallerID2: 2001
 */
public class Bridge extends EventMsg {
	// Event: Bridge
	// Privilege: call,all
	protected static String BridgestateTag = "Bridgestate:";
	protected static String BridgetypeTag = "Bridgetype:";
	protected static String Channel1Tag = "Channel1:";
	protected static String Channel2Tag = "Channel2:";
	protected static String Uniqueid1Tag = "Uniqueid1:";
	protected static String Uniqueid2Tag = "Uniqueid2:";
	protected static String CallerID1Tag = "CallerID1:";
	protected static String CallerID2Tag = "CallerID2:";

	private String Bridgestate;
	private String Bridgetype;// : core
	private String Channel1;// : SIP/2000-00000006
	private String Channel2;// : SIP/2001-00000007
	private String Uniqueid1;// : 1412931683.6
	private String Uniqueid2;// : 1412931683.7
	private String CallerID1;// : 2000
	private String CallerID2;// : 2001

	public String getBridgestate() {
		return Bridgestate;
	}

	public void setBridgestate(String bridgestate) {
		Bridgestate = bridgestate;
	}

	public String getBridgetype() {
		return Bridgetype;
	}

	public void setBridgetype(String bridgetype) {
		Bridgetype = bridgetype;
	}

	public String getChannel1() {
		return Channel1;
	}

	public void setChannel1(String channel1) {
		Channel1 = channel1;
	}

	public String getChannel2() {
		return Channel2;
	}

	public void setChannel2(String channel2) {
		Channel2 = channel2;
	}

	public String getUniqueid1() {
		return Uniqueid1;
	}

	public void setUniqueid1(String uniqueid1) {
		Uniqueid1 = uniqueid1;
	}

	public String getUniqueid2() {
		return Uniqueid2;
	}

	public void setUniqueid2(String uniqueid2) {
		Uniqueid2 = uniqueid2;
	}

	public String getCallerID1() {
		return CallerID1;
	}

	public void setCallerID1(String callerID1) {
		CallerID1 = callerID1;
	}

	public String getCallerID2() {
		return CallerID2;
	}

	public void setCallerID2(String callerID2) {
		CallerID2 = callerID2;
	}

	public Bridge parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}

			inx = evtMsg[i].indexOf(Bridge.BridgestateTag);
			if (inx >= 0) {
				this.setBridgestate(evtMsg[i].substring(
						inx + Bridge.BridgestateTag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.BridgetypeTag);
			if (inx >= 0) {
				this.setBridgetype(evtMsg[i].substring(
						inx + Bridge.BridgetypeTag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.CallerID1Tag);
			if (inx >= 0) {
				this.setCallerID1(evtMsg[i].substring(
						inx + Bridge.CallerID1Tag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.CallerID2Tag);
			if (inx >= 0) {
				this.setCallerID2(evtMsg[i].substring(
						inx + Bridge.CallerID2Tag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.Channel1Tag);
			if (inx >= 0) {
				this.setChannel1(evtMsg[i].substring(
						inx + Bridge.Channel1Tag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.Channel2Tag);
			if (inx >= 0) {
				this.setChannel2(evtMsg[i].substring(
						inx + Bridge.Channel2Tag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.Uniqueid1Tag);
			if (inx >= 0) {
				this.setUniqueid1(evtMsg[i].substring(
						inx + Bridge.Uniqueid1Tag.length()).trim());
				continue;
			}
			inx = evtMsg[i].indexOf(Bridge.Uniqueid2Tag);
			if (inx >= 0) {
				this.setUniqueid2(evtMsg[i].substring(
						inx + Bridge.Uniqueid2Tag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
