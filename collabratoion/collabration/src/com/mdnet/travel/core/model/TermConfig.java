package com.mdnet.travel.core.model;
/*
 * 暂时不用
 */
public class TermConfig {
	private int termId;
	private String termPwd;
	private int termSate;
	private String lastRegisterTime;
	private String lastEndCallTime;
	
	private String domain;
	private String websocket_proxy_url;
	private String outbound_proxy_url;
	private String ice_servers;
	private String realm;
	

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getWebsocket_proxy_url() {
		return websocket_proxy_url;
	}

	public void setWebsocket_proxy_url(String websocket_proxy_url) {
		this.websocket_proxy_url = websocket_proxy_url;
	}

	public String getOutbound_proxy_url() {
		return outbound_proxy_url;
	}

	public void setOutbound_proxy_url(String outbound_proxy_url) {
		this.outbound_proxy_url = outbound_proxy_url;
	}

	public String getIce_servers() {
		return ice_servers;
	}

	public void setIce_servers(String ice_servers) {
		this.ice_servers = ice_servers;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public int getTermId() {
		return termId;
	}

	public void setTermId(int termId) {
		this.termId = termId;
	}

	public String getTermPwd() {
		return termPwd;
	}

	public void setTermPwd(String termPwd) {
		this.termPwd = termPwd;
	}

	public int getTermSate() {
		return termSate;
	}

	public void setTermSate(int termSate) {
		this.termSate = termSate;
	}

	public String getLastRegisterTime() {
		return lastRegisterTime;
	}

	public void setLastRegisterTime(String lastRegisterTime) {
		this.lastRegisterTime = lastRegisterTime;
	}

	public String getLastEndCallTime() {
		return lastEndCallTime;
	}

	public void setLastEndCallTime(String lastEndCallTime) {
		this.lastEndCallTime = lastEndCallTime;
	}
}
