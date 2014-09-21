package com.mdnet.travel.core.vo;

public class ExceptionInfo {

	public String content;
	public String src;
	public ExceptionInfo(){}
	public ExceptionInfo(String content, String src) {
		this.content = content;
		this.src = src;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
}
