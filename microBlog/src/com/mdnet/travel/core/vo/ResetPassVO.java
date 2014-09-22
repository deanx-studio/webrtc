package com.mdnet.travel.core.vo;

public class ResetPassVO {

	private String old_pass;
	private String new_pass;
	private String second_pass;
	public ResetPassVO(){}
	
	public ResetPassVO(String old_pass, String new_pass, String second_pass) {
		this.old_pass = old_pass;
		this.new_pass = new_pass;
		this.second_pass = second_pass;
	}
	public String getOld_pass() {
		return old_pass;
	}
	public void setOld_pass(String old_pass) {
		this.old_pass = old_pass;
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
