package com.mdnet.travel.core.model;

public class KeyDefine extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//
	private int keyValue;//键值标识
	private String keyName;//键名称
	private String keyDescript;//键的用途描述
	private String toUserName;// 微信原始ID，微信消息中的toUserName
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(int keyValue) {
		this.keyValue = keyValue;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getKeyDescript() {
		return keyDescript;
	}
	public void setKeyDescript(String keyDescript) {
		this.keyDescript = keyDescript;
	}
}
