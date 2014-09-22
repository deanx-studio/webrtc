package com.mdnet.travel.core.model;

public class MetaKeys extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String pageUri;
	private String keywords;
	private String modifyTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String pageUri) {
		this.pageUri = pageUri;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
