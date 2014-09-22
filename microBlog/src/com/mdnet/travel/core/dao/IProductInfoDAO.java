package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.order.model.ProductInfo;

public interface IProductInfoDAO extends BasicDAO<ProductInfo>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.ProductInfoDAOImpl";

	List<ProductInfo> find(String where,
			int page);
    

}
