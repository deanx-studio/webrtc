package com.mdnet.asterisk.ami.event;

/* peerStatus 事件实例
 ------Receive Event:------
 Event: PeerStatus
 Privilege: system,all
 ChannelType: SIP
 Peer: SIP/1000
 PeerStatus: Registered
 Address: 222.129.40.193:19965

 ------Receive Event:------
 Event: PeerStatus
 Privilege: system,all
 ChannelType: SIP
 Peer: SIP/1002
 PeerStatus: Unregistered
 Cause: Expired
 */
public class PeerStatusMsg extends EventMsg {

	public static String ChannelTypeTag = "ChannelType:";
	public static String PeerTag = "Peer:";
	public static String PeerStatusTag = "PeerStatus:";
	public static String AddressTag = "Address:";
	public static String CauseTag = "Cause:";

	protected String ChannelType;// : SIP
	protected String Peer;// : SIP/1000
	protected String PeerStatus;// : Registered
	protected String Address;// : 222.129.40.193:19965
	protected String Cause;// : Expired

	public String getCause() {
		return Cause;
	}

	public void setCause(String cause) {
		Cause = cause;
	}

	public String getChannelType() {
		return ChannelType;
	}

	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}

	public String getPeer() {
		return Peer;
	}

	public void setPeer(String peer) {
		Peer = peer;
	}

	public String getPeerStatus() {
		return PeerStatus;
	}

	public void setPeerStatus(String peerStatus) {
		PeerStatus = peerStatus;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void updateDB() {
		// TODO Auto-generated method stub

	}

	public PeerStatusMsg parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			// Privilege:
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}
			// ChannelType:
			inx = evtMsg[i].indexOf(PeerStatusMsg.ChannelTypeTag);
			if (inx >= 0) {
				this.setChannelType(evtMsg[i].substring(
						inx + PeerStatusMsg.ChannelTypeTag.length()).trim());
				continue;
			}
			// Peer:
			inx = evtMsg[i].indexOf(PeerStatusMsg.PeerTag);
			if (inx >= 0) {
				this.setPeer(evtMsg[i].substring(
						inx + PeerStatusMsg.PeerTag.length()).trim());
				continue;
			}
			// PeerStatus:
			inx = evtMsg[i].indexOf(PeerStatusMsg.PeerStatusTag);
			if (inx >= 0) {
				this.setPeerStatus(evtMsg[i].substring(
						inx + PeerStatusMsg.PeerStatusTag.length()).trim());
				continue;
			}
			// Address:
			inx = evtMsg[i].indexOf(PeerStatusMsg.AddressTag);
			if (inx >= 0) {
				this.setAddress(evtMsg[i].substring(
						inx + PeerStatusMsg.AddressTag.length()).trim());
				continue;
			}
			// Address:
			inx = evtMsg[i].indexOf(PeerStatusMsg.CauseTag);
			if (inx >= 0) {
				this.setCause(evtMsg[i].substring(
						inx + PeerStatusMsg.CauseTag.length()).trim());
				continue;
			}
		}// end for
		return this;
	}
}
