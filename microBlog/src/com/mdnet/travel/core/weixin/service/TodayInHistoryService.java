package com.mdnet.travel.core.weixin.service;

public interface TodayInHistoryService {

	public static final String SERVICE_NAME = "com.mdnet.travel.core.weixin.service.impl.TodayInHistoryServiceImpl";
	/**
	 * 获取历史上的今天的数据
	 * @return
	 */
	String getTodayInHistoryInfo();
}
