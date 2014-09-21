package com.mdnet.asterisk.ami.event;
/*
 * ------Receive Event:------
Event: FullyBooted
Privilege: system,all
Status: Fully Booted
 */
public class FullyBooted extends EventMsg {
	protected String Status;
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public FullyBooted parse(String evtName, String[] evtMsg) {
		String privilegeTag = "Privilege:";
		String StatusTag = "Status:";
		
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			
			// Privilege:
			int inx = evtMsg[i].indexOf(privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(inx
						+ privilegeTag.length()).trim());
				continue;
			}
			// Status:
			inx = evtMsg[i].indexOf(StatusTag);
			if (inx >= 0) {
				this.setStatus(evtMsg[i].substring(inx
						+ StatusTag.length()).trim());
				continue;
			}
			
		}// end for
		return this;
	}
}
