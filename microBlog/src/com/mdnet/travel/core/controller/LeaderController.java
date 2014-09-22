package com.mdnet.travel.core.controller;

import java.rmi.RemoteException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.service.ILeaderService;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.service.IOrderMgrService;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.ShowProductInfo;
import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductDetail;

@Controller
@RequestMapping("/leader")
public class LeaderController extends BaseController {
	@Resource(name = IOrderMgrService.SERVICE_NAME)
	private IOrderMgrService orderMgrService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		this.getMav();
		// this.mav.addObject("menuIndex", 0);
		ShowProductInfo[] ps = this.orderMgrService.getProductList(3, 0);

		this.mav.addObject("productList", ps);
		this.mav.setViewName("leader/home");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		return this.mav;
	}

	@RequestMapping(value = { "benifit" }, method = RequestMethod.GET)
	public ModelAndView orderListPage(HttpServletRequest request) {
		String uname = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		this.getMav();
		this.mav.setViewName("leader/benifit");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		return mav;
	}

	@RequestMapping(value = { "order/list" }, method = RequestMethod.GET)
	public ModelAndView orderListPage(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page) {
		String uname = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		this.getMav();
		this.mav.setViewName("leader/orderList");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		List<OrderInfo> ois = this.orderMgrService.getOrders(2, uname, pageNo);
		this.mav.addObject("orderList", ois);
		int itemCount = 0;
		if (ois != null)
			itemCount = ois.size();
		this.doPager(pageNo, itemCount, 20);
		return mav;
	}

	@RequestMapping(value = { "order/save" }, method = RequestMethod.POST)
	@ResponseBody
	public String orderSave(
			@RequestParam(value = "productID", required = true) int pid,
			@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userMobile", required = true) String userMobile,
			@RequestParam(value = "oldCount", required = true) int oldCount,
			@RequestParam(value = "adultCount", required = true) int adultCount,
			@RequestParam(value = "childrenBedsCount", required = true) int childrenBedsCount,
			@RequestParam(value = "childrenCount", required = true) int childrenCount,
			@RequestParam(value = "startDate", required = true) String startDate) {

		int totalCount = oldCount + adultCount + childrenCount; 
		String uname = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		ProductDetail pd = this.orderMgrService.getProductInfo(pid);
		if (pd.getProductInfo() != null) {
			orderId = this.orderMgrService.saveOrder(orderId, pd, userName,
					userMobile, totalCount, childrenCount, oldCount, adultCount, childrenBedsCount, startDate, uname,
					"", "weixin");
			try {
				this.getProxy().sendSMS(
						"客户您好，您已经成功预订‘" + pd.getProductInfo().getProductName()
								+ "’，参团人数：" + totalCount + "人，出发日期:"
								+ startDate + "。凭此短信优惠"
								+ pd.getPrice().getOffPrice() / 100 + "元",
						userMobile);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				orderId = "-1";
			}
		} else {
			orderId = "0";
		}
		return orderId;
	}

	@RequestMapping(value = { "order" }, method = RequestMethod.GET)
	public ModelAndView orderPage(HttpServletRequest request,
			@RequestParam(value = "productID", required = false) int pid,
			@RequestParam(value = "orderId", required = false) String orderId) {
		this.getMav();
		this.mav.setViewName("leader/order");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));

		this.mav.addObject("totalCount", 2);
		this.mav.addObject("childrenCount", 0);
		if (orderId != null) {
			OrderInfo oi = this.orderMgrService.getOrders(orderId);
			if (oi != null) {
				this.mav.addObject("startDate", oi.getArriveDate());
				this.mav.addObject("totalCount", oi.getAmount());
				this.mav.addObject("childrenCount", oi.getChildrenCount());
				pid = oi.getProductId();
			}
		}
		this.mav.addObject("pid", pid);
		ProductDetail pd = this.orderMgrService.getProductInfo(pid);
		this.mav.addObject("productName", pd.getProductInfo().getProductName());
		this.mav.addObject("salePrice", pd.getPrice().getLowPrice() / 100);
		this.mav.addObject("offPrice", pd.getPrice().getOffPrice() / 100);
		return mav;
	}
}
