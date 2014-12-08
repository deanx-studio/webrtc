package com.mdnet.travel.core.dao;

import net.zhinet.travel.pojo.basepojo.ParamConfig;

public interface IParamConfigDAO extends BasicDAO<ParamConfig>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.ParamConfigDAOImpl";

	void setParam(String paramKey, String keyValue, String keyDesc);

	String getValue(String paramKey);

}
