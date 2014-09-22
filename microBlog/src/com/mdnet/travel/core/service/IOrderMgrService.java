package com.mdnet.travel.core.service;

import java.util.List;

import com.mdnet.travel.core.vo.ShowProductInfo;
import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductDetail;

public interface IOrderMgrService {
	public final static String SERVICE_NAME = "com.mdnet.travel.order.service.impl.OrderMgrServiceImpl";

	ShowProductInfo[] getProductList(int productType, int page);

	ProductDetail getProductInfo(int pid);

	String saveOrder(String orderId, ProductDetail pid, String userName,
			String userMobile, int totalCount, int childrenCount,
			int oldCount, int adultCount, int childrenBedsCount,
			String startDate, String bookerName, String bookerPhone,
			String channelSource);

	OrderInfo getOrders(String orderId);

	List<OrderInfo> getOrders(int sType, String context, int pageNo);

	void updateOrder(OrderInfo oi);
}
