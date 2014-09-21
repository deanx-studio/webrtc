package com.mdnet.asterisk.ami;

public class ActionMsg {
	// Action是我们程序发起的命令，让asterisk执行某些操作。也就是给asterisk发送各种类型的操作请求，如：
	// 1. Originate——让asterisk发起呼叫
	// 2. Redirect——将通话重定向到某个功能节点
	// 3. Hangup——挂断某个通话
	// 4. Monitor、StopMonitor——开始和停止录音
	// 5. Reload——让asterisk重新加载配置文件
	public String toString() {
		String msg = "Action: " + this.Action + "\r\n";
		msg += "ActionID: " + this.ActionID + "\r\n";
		return msg;
	}

	public ActionMsg() {
		this.ActionID = ActionMsg.gActionID++;
	}

	protected String Action;// : Login

	public String getAction() {
		return Action;
	}

	protected void setAction(String action) {
		Action = action;

	}

	protected static int gActionID;// : 1
	protected int ActionID;// : 1

	public int getActionID() {
		return ActionID;
	}

	protected void setActionID(int actionID) {
		ActionID = actionID;
	}

}
