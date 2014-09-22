package com.mdnet.travel.core.model;

public class WeixinAccount extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;// 指定使用identity主键生成策略
	private String wxFromUserName;// 腾讯分配给微信的原始ID，是微信帐号的唯一标识，在帐号设置中可以找到
	private String wxName;// 微信帐号名称
	private String wxAccount;// 微信号
	private int wxType;// 微信类型，0：订阅号；1：服务号
	private String makeTime;
	private String appId;
	private String appSecret;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getWxFromUserName() {
		return wxFromUserName;
	}
	public void setWxFromUserName(String wxFromUserName) {
		this.wxFromUserName = wxFromUserName;
	}
	public String getWxName() {
		return wxName;
	}
	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
	public String getWxAccount() {
		return wxAccount;
	}
	public void setWxAccount(String wxAccount) {
		this.wxAccount = wxAccount;
	}
	public int getWxType() {
		return wxType;
	}
	public void setWxType(int wxType) {
		this.wxType = wxType;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public static final int WX_TYPE_SERVICE=1;
	public static final int WX_TYPE_SUBSCRIBE=0;
}
