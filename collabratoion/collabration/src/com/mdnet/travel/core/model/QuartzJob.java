package com.mdnet.travel.core.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdnet.asterisk.ami.AMIBase;
import com.mdnet.travel.core.service.ICallService;
import com.mdnet.travel.core.service.impl.ParamConfig;

public class QuartzJob {

	public static int quartzCount;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService _callService;
	public static ICallService callService = null;

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public void work() {
		if (QuartzJob.callService == null)
			QuartzJob.callService = this._callService;
		// logger.info("定时器到时处理。");
		AMIBase.instance().checkConnect();
	}

	// private String domain;
	// private String websocket_proxy_url;
	// private String outbound_proxy_url;
	// private String ice_servers;
	// private String realm;

	public void setDomain(String domain) {
		ParamConfig.inst().setDomain(domain);
	}

	public void setWebsocket_proxy_url(String websocket_proxy_url) {
		ParamConfig.inst().setWebsocket_proxy_url(websocket_proxy_url);
	}

	public void setOutbound_proxy_url(String outbound_proxy_url) {
		ParamConfig.inst().setOutbound_proxy_url(outbound_proxy_url);
	}

	public void setIce_servers(String ice_servers) {
		ParamConfig.inst().setIce_servers(ice_servers);
	}

	public void setRealm(String realm) {
		ParamConfig.inst().setRealm(realm);
	}

	public void setAmiServer(String asteriskServer) {
		ParamConfig.inst().setAmiServer(asteriskServer);
	}

	public void setAmiPort(String asteriskPort) {
		ParamConfig.inst().setAmiPort(Integer.parseInt(asteriskPort));
	}
	public void setAmiUsername(String amiUsername) {
		ParamConfig.inst().setAmiUsername(amiUsername);
	}

	public void setAmiSecrect(String amiSecrect) {
		ParamConfig.inst().setAmiSecrect(amiSecrect);
	}
}
