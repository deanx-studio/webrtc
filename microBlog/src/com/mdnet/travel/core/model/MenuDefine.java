package com.mdnet.travel.core.model;

public class MenuDefine extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int parentId;//父菜单ID，0为顶级菜单
	private String menuName;
	private String menuType;//可选值："click" "view"
	private int menuKey;//
	private String menuUrl;
	//微信原始ID，微信消息中的toUserName
	private String toUserName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public int getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(int menuKey) {
		this.menuKey = menuKey;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
}
