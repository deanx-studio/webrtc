package com.mdnet.travel.core.dao;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.TerminateInfo;

public interface ITerminateInfo extends BasicDAO<TerminateInfo> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.TerminateInfoImpl";

	List<TerminateInfo> find(String where, int pageNo);
	

}
