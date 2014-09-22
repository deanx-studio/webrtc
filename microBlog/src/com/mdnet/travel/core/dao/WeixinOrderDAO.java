package com.mdnet.travel.core.dao;

import com.mdnet.travel.core.model.WeixinOrder;


public interface WeixinOrderDAO extends BasicDAO<WeixinOrder>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.WeixinOrderDAOImpl";

	WeixinOrder findBywxOrderId(String wxOrderId);
	
}
