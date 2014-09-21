package net.zhinet.travel.pojo.basepojo;

import com.mdnet.travel.core.model.BaseModel;

public class UserInfo extends BaseModel {
	private static final long serialVersionUID = 7727L;
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_CONDUCTER = "ROLE_CONDUCTER";
	private int id;
	private String username;
	private String password;
	private String mobile;
	private String authority;
	private String makeTime;
	private String terminateNumber;//
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTerminateNumber() {
		return terminateNumber;
	}

	public void setTerminateNumber(String terminateNumber) {
		this.terminateNumber = terminateNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		if (authority.compareTo(ROLE_ADMIN) == 0)
			this.setRole("管理员");
		else if (authority.compareTo(ROLE_USER) == 0)
			this.setRole("用户");
		else if (authority.compareTo(ROLE_CONDUCTER) == 0)
			this.setRole("操作员");
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

}
