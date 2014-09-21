package com.mdnet.asterisk.ami.event;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventMsg {
	protected static String privilegeTag = "Privilege:";

	public EventMsg() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time = sdf.format(new Date());
	}

	protected String Event;// : PeerStatus
	protected String Privilege;// system,all
	protected String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getPrivilege() {
		return Privilege;
	}

	public void setPrivilege(String privilege) {
		Privilege = privilege;
	}

	protected int toInt(String i) {
		try {
			return Integer.parseInt(i);
		} catch (Exception e) {
			//e.printStackTrace();
			return -1;
		}
	}
}
