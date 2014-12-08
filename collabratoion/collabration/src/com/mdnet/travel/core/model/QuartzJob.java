package com.mdnet.travel.core.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mdnet.asterisk.ami.AMIBase;
import com.mdnet.travel.core.dao.IParamConfigDAO;
import com.mdnet.travel.core.service.IAdminService;
import com.mdnet.travel.core.service.ICallService;
import com.mdnet.travel.core.service.impl.ParamConfigInstance;

public class QuartzJob {

	public static int quartzCount;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService _callService;
	public static ICallService callService = null;

	@Resource(name = IAdminService.SERVICE_NAME)
	protected IAdminService adminService;
	
	
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	
	public void work() {
		if (QuartzJob.callService == null){
			QuartzJob.callService = this._callService;
			//第一次加载参数数据
			adminService.reloadParam();
			
		}
		// logger.info("定时器到时处理。");
		AMIBase.instance().checkConnect();
	}

	// private String domain;
	// private String websocket_proxy_url;
	// private String outbound_proxy_url;
	// private String ice_servers;
	// private String realm;

	/*
	 //参数改为从数据库中读取
	public void setDomain(String domain) {
		ParamConfigInstance.inst().setDomain(domain);
	}

	public void setWebsocket_proxy_url(String websocket_proxy_url) {
		ParamConfigInstance.inst().setWebsocket_proxy_url(websocket_proxy_url);
	}

	public void setOutbound_proxy_url(String outbound_proxy_url) {
		ParamConfigInstance.inst().setOutbound_proxy_url(outbound_proxy_url);
	}

	public void setIce_servers(String ice_servers) {
		ParamConfigInstance.inst().setIce_servers(ice_servers);
	}

	public void setRealm(String realm) {
		ParamConfigInstance.inst().setRealm(realm);
	}

	public void setAmiServer(String asteriskServer) {
		ParamConfigInstance.inst().setAmiServer(asteriskServer);
	}

	public void setAmiPort(String asteriskPort) {
		ParamConfigInstance.inst().setAmiPort(Integer.parseInt(asteriskPort));
	}
	public void setAmiUsername(String amiUsername) {
		ParamConfigInstance.inst().setAmiUsername(amiUsername);
	}

	public void setAmiSecrect(String amiSecrect) {
		ParamConfigInstance.inst().setAmiSecrect(amiSecrect);
	}
	*/
}
