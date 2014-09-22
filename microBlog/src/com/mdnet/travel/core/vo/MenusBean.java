package com.mdnet.travel.core.vo;

public class MenusBean extends BasicBean{
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
	//附加显示属性
	private String parentName;
	private String menuTypeStr;
	private String menuValue;
	private int createKeyMode;//默认为手动选择现有的专题目录
	public int getCreateKeyMode() {
		return createKeyMode;
	}
	public void setCreateKeyMode(int createKeyMode) {
		this.createKeyMode = createKeyMode;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getMenuTypeStr() {
		return menuTypeStr;
	}
	public void setMenuTypeStr(String menuTypeStr) {
		this.menuTypeStr = menuTypeStr;
	}
	public String getMenuValue() {
		return menuValue;
	}
	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
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
}
