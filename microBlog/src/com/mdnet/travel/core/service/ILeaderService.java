package com.mdnet.travel.core.service;

import com.mdnet.travel.core.vo.ShowProductInfo;

public interface ILeaderService {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.LeaderServiceImpl";

	ShowProductInfo[] getProductList(ProxyService proxyService, int pageNo);

}
