package com.mdnet.travel.core.vo;

public class KeysBean extends BasicBean{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int key_value;
	private String key_name;
	private String key_descript;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKey_value() {
		return key_value;
	}
	public void setKey_value(int key_value) {
		this.key_value = key_value;
	}
	public String getKey_name() {
		return key_name;
	}
	public void setKey_name(String key_name) {
		this.key_name = key_name;
	}
	public String getKey_descript() {
		return key_descript;
	}
	public void setKey_descript(String key_descript) {
		this.key_descript = key_descript;
	}
}
