package com.mdnet.asterisk.ami.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mdnet.travel.core.model.QuartzJob;

public class EventNotify {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private String eventMsg;

	public void fireEvent(String EventMsg) {
		this.eventMsg = EventMsg;
		logger.info("------Receive Event:------\r\n" + this.eventMsg);
		String[] evtMsg = EventMsg.split("\r\n");

		if (evtMsg.length > 2) {
			String eventTag = "Event:";
			int inx = evtMsg[0].indexOf(eventTag);
			if (inx >= 0) {
				String evtName = evtMsg[0].substring(inx + eventTag.length())
						.trim();
				this.onEvent(parseEvent(evtName, evtMsg));
			}
		}

	}

	private EventMsg parseEvent(String evtName, String[] evtMsg) {

		if (evtName.contains("PeerStatus")) {
			PeerStatusMsg msg = new PeerStatusMsg();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("FullyBooted")) {
			FullyBooted msg = new FullyBooted();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("Newchannel")) {
			NewChannel msg = new NewChannel();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("VarSet")) {
			VarSet msg = new VarSet();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("Newstate")) {
			NewState msg = new NewState();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("Newexten")) {
			NewExten msg = new NewExten();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("Hangup")) {
			Hangup msg = new Hangup();
			msg.parse(evtName, evtMsg);
			return msg;
		} else if (evtName.contains("Bridge")) {
			Bridge msg = new Bridge();
			msg.parse(evtName, evtMsg);
			return msg;
		} else {
			EventMsg msg = new EventMsg();
			msg.setEvent(evtName);
			return msg;
		}

	}

	public void onEvent(EventMsg msg) {

		logger.info("------" + msg.getTime() + "->recv event:" + msg.getEvent()
				+ "(" + msg.getClass() + ")");
		if (msg.getEvent().contains("PeerStatus")) {

			QuartzJob.callService.updateRegister((PeerStatusMsg) msg);
		}
		// else if (msg.getEvent().contains("FullyBooted")) {
		//
		// }
		else if (msg.getEvent().contains("Newchannel")) {
			QuartzJob.callService.newChannel((NewChannel) msg);
		} else if (msg.getEvent().contains("VarSet")) {

		} else if (msg.getEvent().contains("Newstate")) {
			QuartzJob.callService.updateCall(msg);
		} else if (msg.getEvent().contains("Newexten")) {
			QuartzJob.callService.updateCall(msg);
		} else if (msg.getEvent().contains("Hangup")) {
			QuartzJob.callService.hangup((Hangup) msg);
		} else if (msg.getEvent().contains("Bridge")) {
			QuartzJob.callService.bridge((Bridge) msg);
		}
		// if (msg.getEvent().contains("PeerStatus")) {
		// PeerStatus peerStatus = (PeerStatus) msg;
		// peerStatus.updateDB();
		// } else if (msg.getEvent().contains("FullyBooted")) {
		// // do nothing
		// }
	}

}
