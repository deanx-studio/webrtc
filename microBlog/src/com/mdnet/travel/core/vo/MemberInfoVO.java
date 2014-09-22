package com.mdnet.travel.core.vo;

public class MemberInfoVO extends BasicBean{
	private static final long serialVersionUID = 28565L;
	private String username;
	private String password;
	private String mobile;
	private String authority;
	public MemberInfoVO(){}
	public MemberInfoVO(String username, String password, String mobile,
			String authority) {
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.authority = authority;
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
