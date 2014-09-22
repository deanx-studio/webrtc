package com.mdnet.travel.core.vo;

public class ResetMobileVO extends BasicBean{

	private static final long serialVersionUID = 838027L;
	private String mobile;
	private String valid_code;
	public ResetMobileVO(){}
	public ResetMobileVO(String mobile, String valid_code) {
		super();
		this.mobile = mobile;
		this.valid_code = valid_code;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getValid_code() {
		return valid_code;
	}
	public void setValid_code(String valid_code) {
		this.valid_code = valid_code;
	}
	
}
