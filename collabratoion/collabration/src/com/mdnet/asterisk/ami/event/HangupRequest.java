package com.mdnet.asterisk.ami.event;

public class HangupRequest extends EventMsg {
	/*
	 * 被叫挂机 Event: HangupRequest Privilege: call,all Channel: SIP/2001-0000003d
	 * Uniqueid: 1413526236.61 Cause: 18 14:14:13 INFO (EventNotify.java:72)
	 * [onEvent()] ------2014-10-17 14:14:13->recv event:HangupRequest(class
	 * com.mdnet.asterisk.ami.event.Hangup) 14:14:13 INFO (EventNotify.java:13)
	 * [fireEvent()] ------Receive Event:------ 主叫挂机 Event: Hangup Privilege:
	 * call,all Channel: SIP/2001-0000003d Uniqueid: 1413526236.61 CallerIDNum:
	 * 2001 CallerIDName: <unknown> ConnectedLineNum: 2000 ConnectedLineName:
	 * <unknown> AccountCode: Cause: 18 Cause-txt: No user responding
	 */
	public static String ChannelTag = "Channel:";
	public static String UniqueidTag = "Uniqueid:";
	private String Channel;
	private String Uniqueid;

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

	public HangupRequest parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(HangupRequest.ChannelTag);
			if (inx >= 0) {
				this.setChannel(evtMsg[i].substring(
						inx + HangupRequest.ChannelTag.length()).trim());
				continue;
			}

			// protected static String ChannelTag = "Channel:";
			inx = evtMsg[i].indexOf(HangupRequest.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + HangupRequest.UniqueidTag.length()).trim());
				continue;
			}

		}// end for
		return this;
	}
}
