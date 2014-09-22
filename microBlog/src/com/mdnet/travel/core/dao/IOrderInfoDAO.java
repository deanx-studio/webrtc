package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.order.model.OrderInfo;

public interface IOrderInfoDAO extends BasicDAO<OrderInfo>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.OrderInfoDAOImpl";

	List<OrderInfo> find(String where, int page);
    

}
