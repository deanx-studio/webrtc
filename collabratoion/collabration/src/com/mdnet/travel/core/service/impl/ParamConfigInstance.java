package com.mdnet.travel.core.service.impl;

public class ParamConfigInstance {
	protected static ParamConfigInstance _config = null;
	private String domain;
	private String websocket_proxy_url;
	private String outbound_proxy_url;
	private String ice_servers;
	private String realm;
	private String amiServer;
	private int amiPort;
	private String amiUsername;
	private String amiSecrect;
	

	public String getAmiUsername() {
		
		return amiUsername;
	}

	public void setAmiUsername(String amiUsername) {
		this.amiUsername = amiUsername;
	}

	public String getAmiSecrect() {
		return amiSecrect;
	}

	public void setAmiSecrect(String amiSecrect) {
		this.amiSecrect = amiSecrect;
	}

	public String getAmiServer() {
		return amiServer;
	}

	public void setAmiServer(String amiServer) {
		this.amiServer = amiServer;
	}

	public int getAmiPort() {
		return amiPort;
	}

	public void setAmiPort(int amiPort) {
		this.amiPort = amiPort;
	}

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

	protected ParamConfigInstance() {
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
	}

	public static ParamConfigInstance inst() {
		if (_config == null)
			_config = new ParamConfigInstance();
		return _config;
	}
}
