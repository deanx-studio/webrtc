package com.mdnet.asterisk.ami.event;

/*------Receive Event:------
 Event: Newexten
 Privilege: dialplan,all
 Channel: SIP/1000-00000014
 Context: from-sip
 Extension: 9000
 Priority: 1
 Application: Answer
 AppData: 9000
 Uniqueid: 1409638154.22
 */
public class NewExten extends EventMsg {

	public static String ChannelTag = "Channel:";// SIP/1000-00000014
	public static String ContextTag = "Context:";// from-sip
	public static String ExtensionTag = "Extension:";// 9000
	public static String PriorityTag = "Priority:";// 1
	public static String ApplicationTag = "Application:";// Answer
	public static String AppDataTag = "AppData:";// 9000
	public static String UniqueidTag = "Uniqueid:";// 1409638154.22

	protected String Channel;
	protected String Context;
	protected String Extension;
	protected int Priority;
	protected String Application;
	protected String AppData;
	protected String Uniqueid;

	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getContext() {
		return Context;
	}

	public void setContext(String context) {
		Context = context;
	}

	public String getExtension() {
		return Extension;
	}

	public void setExtension(String extension) {
		Extension = extension;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public String getApplication() {
		return Application;
	}

	public void setApplication(String application) {
		Application = application;
	}

	public String getAppData() {
		return AppData;
	}

	public void setAppData(String appData) {
		AppData = appData;
	}

	public String getUniqueid() {
		return Uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		Uniqueid = uniqueid;
	}

	public NewExten parse(String evtName, String[] evtMsg) {
		this.setEvent(evtName);
		for (int i = 1; i < evtMsg.length; i++) {
			int inx = evtMsg[i].indexOf(EventMsg.privilegeTag);
			if (inx >= 0) {
				this.setPrivilege(evtMsg[i].substring(
						inx + EventMsg.privilegeTag.length()).trim());
				continue;
			}

			// protected static String ChannelTag = "Channel:";
			inx = evtMsg[i].indexOf(NewExten.ChannelTag);
			if (inx >= 0) {
				this.setChannel(evtMsg[i].substring(
						inx + NewExten.ChannelTag.length()).trim());
				continue;
			}

			// protected static String ExtenTag = "Exten:";
			inx = evtMsg[i].indexOf(NewExten.ExtensionTag);
			if (inx >= 0) {
				this.setExtension(evtMsg[i].substring(
						inx + NewExten.ExtensionTag.length()).trim());
				continue;
			}
			// protected static String ContextTag = "Context:";
			inx = evtMsg[i].indexOf(NewExten.ContextTag);
			if (inx >= 0) {
				this.setContext(evtMsg[i].substring(
						inx + NewExten.ContextTag.length()).trim());
				continue;
			}
			// Priority: 1
			inx = evtMsg[i].indexOf(NewExten.PriorityTag);
			if (inx >= 0) {
				this.setPriority(this.toInt(evtMsg[i].substring(
						inx + NewExten.PriorityTag.length()).trim()));
				continue;
			}
			// Application: Answer
			inx = evtMsg[i].indexOf(NewExten.ApplicationTag);
			if (inx >= 0) {
				this.setApplication(evtMsg[i].substring(
						inx + NewExten.ApplicationTag.length()).trim());
				continue;
			}
			// AppData: 9000
			inx = evtMsg[i].indexOf(NewExten.AppDataTag);
			if (inx >= 0) {
				this.setAppData(evtMsg[i].substring(
						inx + NewExten.AppDataTag.length()).trim());
				continue;
			}
			// protected static String UniqueidTag = "Uniqueid:";
			inx = evtMsg[i].indexOf(NewExten.UniqueidTag);
			if (inx >= 0) {
				this.setUniqueid(evtMsg[i].substring(
						inx + NewExten.UniqueidTag.length()).trim());
				continue;
			}
		}
		return this;
	}
}
