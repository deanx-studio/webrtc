package com.mdnet.travel.core.vo;

public class RegistBean extends BasicBean{
	private static final long serialVersionUID = 1L;
	private String username;
	private String pass;
	private String confirm_pass;
	private String mobile;
	private String valid_code;
	public RegistBean() {}
	
	public RegistBean(String username, String pass, String confirm_pass,
			String mobile, String valid_code) {
		super();
		this.username = username;
		this.pass = pass;
		this.confirm_pass = confirm_pass;
		this.mobile = mobile;
		this.valid_code = valid_code;
	}
	
	public String getValid_code() {
		return valid_code;
	}

	public void setValid_code(String valid_code) {
		this.valid_code = valid_code;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
