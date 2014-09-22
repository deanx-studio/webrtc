package com.mdnet.travel.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdnet.travel.core.dao.IOrderInfoDAO;
import com.mdnet.travel.core.dao.IProductInfoDAO;
import com.mdnet.travel.core.dao.PriceDAO;
import com.mdnet.travel.core.dao.ReqMessageDAO;
import com.mdnet.travel.core.dao.SpecialDAO;
import com.mdnet.travel.core.model.Special;
import com.mdnet.travel.core.service.IOrderMgrService;
import com.mdnet.travel.core.vo.ShowProductInfo;
import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductDetail;
import com.mdnet.travel.order.model.ProductInfo;
import com.mdnet.travel.order.model.ProductPriceLine;

@Service(IOrderMgrService.SERVICE_NAME)
@Scope("prototype")
public class OrderMgrServiceImpl implements IOrderMgrService {

	@Resource(name = IOrderInfoDAO.DAO_NAME)
	protected IOrderInfoDAO orderDAO;
	@Resource(name = IProductInfoDAO.DAO_NAME)
	protected IProductInfoDAO productDAO;
	@Resource(name = SpecialDAO.DAO_NAME)
	protected SpecialDAO specialDAO;
	@Resource(name = PriceDAO.DAO_NAME)
	protected PriceDAO priceDAO;

	@Override
	public ShowProductInfo[] getProductList(int productType, int page) {

		ShowProductInfo[] ps = null;
		List<ProductInfo> pis = this.productDAO.find("where productType="
				+ productType, page);
		if (pis != null)
			ps = new ShowProductInfo[pis.size()];
		for (int i = 0; i < pis.size(); i++) {
			ProductInfo pi = pis.get(i);
			ps[i] = new ShowProductInfo();
			ps[i].setName(pi.getProductName());
			ps[i].setImg(pi.getImgURL());
			
			//媒体信息
			Special sp = this.specialDAO.findByPid(pi.getId());
			if (sp != null)
				ps[i].setMediaID(sp.getId());
			else
				ps[i].setMediaID(0);
			ps[i].setProductID(pi.getId());
			//价格信息
			List<ProductPriceLine> prices = this.priceDAO.findPrice("productId="
					+ pi.getId(), 0);
			if (prices != null && prices.size() > 0)//单位：元
				ps[i].setLowPrice(prices.get(0).getLowPrice()/100);
			
		}
		return ps;
	}

	@Override
	public ProductDetail getProductInfo(int pid) {
		ProductDetail pd = new ProductDetail();
		// 获取基本信息
		List<ProductInfo> pis = this.productDAO.find("where id=" + pid, 0);
		if (pis != null && pis.size() > 0)
			pd.setProductInfo(pis.get(0));

		// 获取价格信息
		List<ProductPriceLine> prices = this.priceDAO.findPrice("productId="
				+ pid, 0);
		if (prices != null && prices.size() > 0)
			pd.setPrice(prices.get(0));
		return pd;
	}

	@Override
	public String saveOrder(String orderId, ProductDetail pd, String userName,
			String userMobile, int totalCount, int childrenCount,
			int oldCount, int adultCount, int childrenBedsCount,
			String startDate, String bookerName, String bookerPhone,
			String channelSource) {
		boolean isNew = false;
		OrderInfo oi = this.getOrders(orderId);
		if (oi == null) {
			isNew = true;
			oi = new OrderInfo();
			SimpleDateFormat sdf = new SimpleDateFormat("yMM");
			String ss = UUID.randomUUID().toString();
			int c = ss.hashCode() & 0x7FFFFFFF;
			String hash = String.valueOf(c);

			oi.setOrderId(sdf.format(new Date()) + hash);
		}
		oi.setAmount(totalCount);
		oi.setArriveDate(startDate);
		oi.setBookerName(bookerName);
		oi.setBookerPhone(bookerPhone);
		oi.setChannelSourceId(channelSource);
		oi.setChildrenCount(childrenCount);
		oi.setOldCount(oldCount);
		oi.setAdultCount(adultCount);
		oi.setChildrenBedsCount(childrenBedsCount);
		oi.setConsumeCount(0);
		oi.setCustomerPayMoney(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastConsumeTime = sdf.format(new Date());
		oi.setLastConsumeTime(lastConsumeTime);
		oi.setOrderDate(lastConsumeTime);
		oi.setUserMobile(userMobile);
		oi.setUserName(userName);
		oi.setOrderState(1);
		oi.setPayChannel(0);
		oi.setPayDate("");
		oi.setPayMoney(0);
		oi.setPayOrderId("");
		oi.setProductId(pd.getProductInfo().getId());
		oi.setProductName(pd.getProductInfo().getProductName());
		oi.setProductPrice(pd.getPrice().getSalePrice());

		if (isNew)
			this.orderDAO.save(oi);
		else
			this.orderDAO.update(oi);
		return oi.getOrderId();
	}

	@Override
	public OrderInfo getOrders(String orderId) {
		List<OrderInfo> ois = this.orderDAO.find(" where orderId='" + orderId
				+ "'", 0);
		if (ois != null && ois.size() > 0)
			return ois.get(0);
		else
			return null;
	}

	@Override
	public List<OrderInfo> getOrders(int sType, String context, int pageNo) {
		String where = "";
		if (context != null && context.length() > 0) {
			if (sType == 0)
				where += "where  userName like '%" + context + "%'";
			if (sType == 1)
				where += "where  userMobile like '%" + context + "%'";
			else if (sType == 2)
				where += "where  bookerName like '%" + context + "%'";
		}
		List<OrderInfo> ois = this.orderDAO.find(where ,//+ " order by id desc",
				pageNo);
		return ois;
	}

	@Override
	public void updateOrder(OrderInfo oi) {
		this.orderDAO.update(oi);
	}

}
