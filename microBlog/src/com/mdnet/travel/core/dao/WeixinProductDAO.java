package com.mdnet.travel.core.dao;

import com.mdnet.travel.core.model.WeixinProduct;

public interface WeixinProductDAO extends BasicDAO<WeixinProduct>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.WeixinProductDAOImpl";
	WeixinProduct getProductInfo(String wxProductId);
}
