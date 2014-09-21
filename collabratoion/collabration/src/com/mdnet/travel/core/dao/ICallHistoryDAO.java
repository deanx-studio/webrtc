package com.mdnet.travel.core.dao;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.CallHistory;

public interface ICallHistoryDAO extends BasicDAO<CallHistory> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.CallHistoryDAOImpl";

	void updateHistory(String channel, int channelState);

	List<CallHistory> findByHQL(String where, int pageNo, int count);
}
