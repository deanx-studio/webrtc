package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.order.model.ProductPriceLine;

public interface PriceDAO extends BasicDAO<ProductPriceLine> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.PriceDAOImpl";

	List<ProductPriceLine> findPrice(String where, int page);
}
