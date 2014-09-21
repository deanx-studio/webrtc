package com.mdnet.asterisk.ami.event;

/*
 * ------Receive Event:------
 Event: VarSet
 Privilege: dialplan,all
 Channel: SIP/1000-00000014
 Variable: SIPURI
 Value: sip:7e176j28@192.0.2.168
 Uniqueid: 1409638154.22
 */
public class VarSet extends EventMsg {

	public static String ChannelTag = "Channel:";// SIP/1000-00000014
	public static String VariableTag = "Variable:";// SIPURI
	public static String ValueTag = "Value:";// sip:7e176j28@192.0.2.168
	public static String UniqueidTag = "Uniqueid:";// 1409638154.22

	protected String Channel;// : SIP/1000-00000014
	protected String Variable;// : SIPURI
	protected String Value;// : sip:7e176j28@192.0.2.168
	protected String Uniqueid;// : 1409638154.22

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getVariable() {
		return Variable;
	}

	public void setVariable(String variable) {
		Variable = variable;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getUniqueid() {
		return Uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}

	public VarSet parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}

			// Channel
			inx = evtMsg[i].indexOf(VarSet.ChannelTag);
			if (inx >= 0) {
				this.setChannel(evtMsg[i].substring(
						inx + VarSet.ChannelTag.length()).trim());
				continue;
			}
			// Variable
			inx = evtMsg[i].indexOf(VarSet.VariableTag);
			if (inx >= 0) {
				this.setVariable(evtMsg[i].substring(
						inx + VarSet.VariableTag.length()).trim());
				continue;
			}
			// Value
			inx = evtMsg[i].indexOf(VarSet.ValueTag);
			if (inx >= 0) {
				this.setValue(evtMsg[i].substring(
						inx + VarSet.ValueTag.length()).trim());
				continue;
			}
			// Uniqueid
			inx = evtMsg[i].indexOf(VarSet.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + VarSet.UniqueidTag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
