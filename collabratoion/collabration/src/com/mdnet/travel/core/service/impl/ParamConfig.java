package com.mdnet.travel.core.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParamConfig {
	protected static ParamConfig _config = null;
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

	protected ParamConfig() {
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
	}

	public static ParamConfig inst() {
		if (_config == null)
			_config = new ParamConfig();
		return _config;
	}
}