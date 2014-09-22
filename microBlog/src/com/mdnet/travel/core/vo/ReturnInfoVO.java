package com.mdnet.travel.core.vo;

public class ReturnInfoVO extends BasicBean{
	private static final long serialVersionUID = 2233L;
	private String info;

	public ReturnInfoVO(){}
	
	public ReturnInfoVO(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
