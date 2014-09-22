package com.mdnet.travel.core.common;

public class Constant {
	protected String PAY_MOBILE = null;
	//public static Properties prop;
	protected String WX_MSGSOURCE = null;
	protected String WX_KEY = null;
	protected String END_POINT = null;
	protected String weixin_web = "";
	protected String PAY_WEB="";
	protected String MobileHomePage;
	protected String PCHomePage;
	

	public String getMobileHomePage() {
		return MobileHomePage;
	}

	public void setMobileHomePage(String mobileHomePage) {
		MobileHomePage = mobileHomePage;
	}

	public String getPCHomePage() {
		return PCHomePage;
	}

	public void setPCHomePage(String pCHomePage) {
		PCHomePage = pCHomePage;
	}

	public String getPAY_WEB() {
		return PAY_WEB;
	}

	public void setPAY_WEB(String pAY_WEB) {
		PAY_WEB = pAY_WEB;
	}

	public String getWX_MSGSOURCE() {
		return WX_MSGSOURCE;
	}

	public void setWX_MSGSOURCE(String wX_MSGSOURCE) {
		WX_MSGSOURCE = wX_MSGSOURCE;
	}

	public String getWX_KEY() {
		return WX_KEY;
	}

	public void setWX_KEY(String wX_KEY) {
		WX_KEY = wX_KEY;
	}

	public String getEND_POINT() {
		return END_POINT;
	}

	public void setEND_POINT(String eND_POINT) {
		END_POINT = eND_POINT;
	}

	public String getWeixin_web() {
		return weixin_web;
	}

	public void setWeixin_web(String weixin_web) {
		this.weixin_web = weixin_web;
	}
	public String getPAY_MOBILE() {
		return PAY_MOBILE;
	}

	public void setPAY_MOBILE(String pAY_MOBILE) {
		PAY_MOBILE = pAY_MOBILE;
	}

	String payConfirmUrl;

	public String getPayConfirmUrl() {
		return payConfirmUrl;
	}

	public void setPayConfirmUrl(String payConfirmUrl) {
		this.payConfirmUrl = payConfirmUrl;
	}

	//TODO 应注意此处常量池极有可能捣乱，
//	static {
//		Properties prop = FileOperationUtil.getProp(classpath);
//		WX_MSGSOURCE = prop.getProperty("msgSource1");
//		WX_KEY = prop.getProperty("value1");
//		PAY_MOBILE = prop.getProperty("MobilePayUrl");
//		END_POINT = prop.getProperty("endpoint");
//		weixin_web = prop.getProperty("weixin_web");
//	}
	
}
