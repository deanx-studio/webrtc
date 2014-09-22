package com.mdnet.travel.core.vo;

public class SearchBean {

	private String province;
	private String city;
	private String keyword;
	private String district;
	public SearchBean() {
	}
	public SearchBean(String province, String city, String keyword) {
		super();
		this.province = province;
		this.city = city;
		this.keyword = keyword;
	}
	
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
}
