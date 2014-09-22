package com.mdnet.travel.core.vo;

public class FindPassVO extends BasicBean{
	private static final long serialVersionUID = 26240L;
	private String valid_mobile;
	private Integer validate_code;
	private String new_pass;
	private String second_pass;
	
	public FindPassVO(){}
	public FindPassVO(String valid_mobile, Integer validate_code,
			String new_pass, String second_pass) {
		super();
		this.valid_mobile = valid_mobile;
		this.validate_code = validate_code;
		this.new_pass = new_pass;
		this.second_pass = second_pass;
	}
	public String getValid_mobile() {
		return valid_mobile;
	}
	public void setValid_mobile(String valid_mobile) {
		this.valid_mobile = valid_mobile;
	}
	public Integer getValidate_code() {
		return validate_code;
	}
	public void setValidate_code(Integer validate_code) {
		this.validate_code = validate_code;
	}
	public String getNew_pass() {
		return new_pass;
	}
	public void setNew_pass(String new_pass) {
		this.new_pass = new_pass;
	}
	public String getSecond_pass() {
		return second_pass;
	}
	public void setSecond_pass(String second_pass) {
		this.second_pass = second_pass;
	}
	
}
