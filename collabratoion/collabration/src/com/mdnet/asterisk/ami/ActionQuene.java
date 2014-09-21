package com.mdnet.asterisk.ami;

public class ActionQuene {
	public ActionQuene(int actionId2, ActionMsg actionMsg2) {
		this.ActionId = actionId2;
		this.actionMsg = actionMsg2;
		actionName = actionMsg2.getAction();
	}
	protected int ActionId;
	protected String actionName;
	public String getActionName() {
		return actionName;
	}
	public void setActionId(int actionId) {
		ActionId = actionId;
	}
	public ActionMsg actionMsg;
	public ResponseMsg respMsg;
}
