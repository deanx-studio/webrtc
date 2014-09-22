package com.mdnet.travel.core.weixin.service;

import javax.servlet.http.HttpServletRequest;

public interface CoreService {

	public final static String SERVICE_NAME = "com.mdnet.travel.core.weixin.service.impl.CoreServiceImpl";
	String processRequest(HttpServletRequest request);
}
