package com.mdnet.travel.core.model;

public class ValidateCode extends BaseModel{
	private static final long serialVersionUID = 33923L;

	private Integer vcId;
	private String traveler;
	private String createTime;
	private String mobile;
	private String validCode; 
	
	public ValidateCode(String traveler, String createTime, String mobile,
			String validCode) {
		this.traveler = traveler;
		this.createTime = createTime;
		this.mobile = mobile;
		this.validCode = validCode;
	}
	public ValidateCode(){}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getVcId() {
		return vcId;
	}
	public void setVcId(Integer vcId) {
		this.vcId = vcId;
	}
	public String getTraveler() {
		return traveler;
	}
	public void setTraveler(String traveler) {
		this.traveler = traveler;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getValidCode() {
		return validCode;
	}
	public void setValidCode(String validCode) {
		this.validCode = validCode;
	}
	
}
