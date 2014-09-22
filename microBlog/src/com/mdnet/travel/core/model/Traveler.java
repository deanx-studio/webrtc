package com.mdnet.travel.core.model;

public class Traveler extends BaseModel{
	private static final long serialVersionUID = 7727L;
	public static final String ROLE_TRAVELER = "ROLE_TRAVELER";
	private String travelerId;
	private String username;
	private String password;
	private String mobile;
	private String authority;
	private String wxFromUserName;
	private String wxOpenId;
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getWxOpenId() {
		return wxOpenId;
	}
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
	public String getWxFromUserName() {
		return wxFromUserName;
	}
	public void setWxFromUserName(String wxFromUserName) {
		this.wxFromUserName = wxFromUserName;
	}
	public Traveler(){}
	public Traveler(String username, String password, String mobile) {
		this.username = username;
		this.password = password;
		this.mobile = mobile;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getTravelerId() {
		return travelerId;
	}
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
