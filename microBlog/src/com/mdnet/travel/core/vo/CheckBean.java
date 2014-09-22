package com.mdnet.travel.core.vo;

public class CheckBean extends BasicBean{
	
	private static final long serialVersionUID = 91L;
	
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	public CheckBean(){}
	public CheckBean(String signature, String timestamp, String nonce,
			String echostr) {
		this.signature = signature;
		this.timestamp = timestamp;
		this.nonce = nonce;
		this.echostr = echostr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getEchostr() {
		return echostr;
	}
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
}
