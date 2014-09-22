package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.travel.core.model.GroupDate;
import com.mdnet.travel.core.model.MetaKeys;
import com.mdnet.travel.core.model.PersonalCustom;
import com.mdnet.travel.core.service.ICustomService;
import com.mdnet.travel.core.service.IOrderMgrService;
import com.mdnet.travel.core.vo.GroupListBean;
import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductDetail;

@Controller
@RequestMapping("/drive")
public class DriveController extends BaseController {
	@Resource(name = ICustomService.SERVICE_NAME)
	protected ICustomService customService;
	@Resource(name = IOrderMgrService.SERVICE_NAME)
	private IOrderMgrService orderMgrService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home() {
		this.getMav();
		this.mav.addObject("menuIndex", 0);
		this.mav.setViewName("drive/home");
		return this.mav;
	}

	@RequestMapping(value = { "private/list" }, method = RequestMethod.GET)
	public ModelAndView privateList(
			@RequestParam(value = "page", required = false) String pageNo,
			@RequestParam(value = "t", required = false) String t,
			@RequestParam(value = "context", required = false) String context) {
		this.getMav();
		this.mav.addObject("menuIndex", 0);

		if (context != null) {
			String s = "";
			try {
				s = new String(context.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			context = s;
		}
		this.mav.setViewName("private/list");
		int page = 0;
		int count = 20;
		int sType = -1;
		if (pageNo != null)
			page = Integer.parseInt(pageNo);
		if (t != null)
			sType = Integer.parseInt(t);
		this.mav.addObject("privateList",
				customService.findall(page, count, sType, context));
		this.mav.addObject("stype", sType);
		this.mav.addObject("sText", context);
		return this.mav;
	}

	@RequestMapping(value = { "private/advice" }, method = RequestMethod.POST)
	public String privateAdvice(
			@RequestParam(value = "sid", required = true) String sessionId,
			@RequestParam(value = "advice", required = true) String advice) {

		return "";
	}

	@RequestMapping(value = { "private/detail" }, method = RequestMethod.GET)
	public ModelAndView privateDetail(
			@RequestParam(value = "sid", required = true) String sessionId) {
		this.getMav();
		this.mav.addObject("menuIndex", 2);
		this.mav.setViewName("private/detail");
		PersonalCustom pc = this.customService.getPersonal(sessionId);
		this.mav.addObject("p", pc);
		return this.mav;
	}

	@RequestMapping(value = { "pay" }, method = RequestMethod.POST)
	@ResponseBody
	public String orderPay(
			@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "payMoney", required = true) int payMoney) {
		OrderInfo oi = this.orderMgrService.getOrders(orderId);
		if (oi == null)
			return "订单号" + orderId + "不存在";
		oi.setPayMoney(payMoney * 100);
		oi.setOrderState(3);// 标记为已经付款
		this.orderMgrService.updateOrder(oi);
		return "0";
	}

	@RequestMapping(value = { "finish" }, method = RequestMethod.POST)
	@ResponseBody
	public String orderOver(
			@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "status", required = true) int status) {
		OrderInfo oi = this.orderMgrService.getOrders(orderId);
		if (oi == null)
			return "订单号" + orderId + "不存在";

		oi.setOrderState(status);// 标记为已经付款
		this.orderMgrService.updateOrder(oi);
		return "0";
	}

	@RequestMapping(value = { "book/list" }, method = RequestMethod.GET)
	public ModelAndView bookList(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "t", required = false) String sType,
			@RequestParam(value = "context", required = false) String context) {
		this.getMav();
		this.mav.addObject("menuIndex", 2);
		this.mav.setViewName("book/list");
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		int stype = 2;
		if (sType != null && sType.length() > 0)
			stype = Integer.parseInt(sType);

		List<OrderInfo> ois = null;
		if (context == null)
			context = "";
		try {
			ois = this.orderMgrService
					.getOrders(stype, new String(
							context.getBytes("iso-8859-1"), "utf-8"), pageNo);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mav.addObject("bookList", ois);
		int itemCount = 0;
		if (ois != null)
			itemCount = ois.size();
		this.doPager(pageNo, itemCount, 20);
		this.mav.addObject("stype", sType);
		this.mav.addObject("context", context);
		return this.mav;
	}

	@RequestMapping(value = "/keyUI", method = RequestMethod.GET)
	public ModelAndView keyUI(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String pageNo) {
		int page = 0;
		if (pageNo != null)
			page = Integer.parseInt(pageNo);
		this.getMav(request);
		this.mav.addObject("keysList",
				this.travelerService.getAllMetaKeys(page));
		this.mav.setViewName("drive/keyUI");

		return this.mav;
	}

	@RequestMapping(value = "/group/add", method = RequestMethod.POST)
	@ResponseBody
	public String groupAdd(
			@RequestParam(value = "GroupName", required = true) String groupName,
			@RequestParam(value = "ProductId", required = true) int productId,
			@RequestParam(value = "productName", required = true) String productName,
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "BookCount", required = true) int bookCount,
			@RequestParam(value = "TotalCount", required = true) int totalCount) {
		int gid = this.customService.AddGroup(groupName, productName,
				startDate, productId, bookCount, totalCount);

		return String.valueOf(gid);
	}

	@RequestMapping(value = "/group/update", method = RequestMethod.POST)
	@ResponseBody
	public String groupUpdate(
			@RequestParam(value = "GroupId", required = true) int groupId,
			@RequestParam(value = "GroupName", required = true) String groupName,
			@RequestParam(value = "ProductId", required = true) int productId,
			@RequestParam(value = "ProductName", required = true) String productName,
			@RequestParam(value = "StartDate", required = true) String startDate,
			@RequestParam(value = "BookCount", required = true) int bookCount,
			@RequestParam(value = "TotalCount", required = true) int totalCount) {
		int gid = this.customService.UpdateGroup(groupId, groupName,
				productName, startDate, productId, bookCount, totalCount);

		return String.valueOf(gid);
	}

	@RequestMapping(value = "/group/delete", method = RequestMethod.POST)
	@ResponseBody
	public String groupDelete(
			@RequestParam(value = "GroupId", required = true) int groupId) {

		int result = this.customService.deleteGroup(groupId);

		return String.valueOf(result);
	}

	@RequestMapping(value = "/group/markFull", method = RequestMethod.POST)
	@ResponseBody
	public String groupMarkFull(
			@RequestParam(value = "GroupId", required = true) int groupId) {

		String result = this.customService.markGroupFull(groupId);

		return result;
	}

	@RequestMapping(value = "/group/set", method = RequestMethod.GET)
	public ModelAndView groupSet(HttpServletRequest request,
			@RequestParam(value = "productID", required = false) String page,
			@RequestParam(value = "t", required = false) String sType,
			@RequestParam(value = "context", required = false) String sText) {
		this.getMav(request);
		List<GroupDate> gd = this.customService.getGroupList("", 0);
		List<GroupListBean> glist = new ArrayList<GroupListBean>();
		for (int i = 0; i < gd.size(); i++) {
			GroupListBean gb = new GroupListBean();
			ProductDetail pd = this.orderMgrService.getProductInfo(gd.get(i)
					.getProductId());
			gb.setGroupId(gd.get(i).getId());
			gb.setProductName(pd.getProductInfo().getProductName());
			gb.setGroupName(gd.get(i).getProductName());
			gb.setStartDate(gd.get(i).getStartDate());
			gb.setProductId(gd.get(i).getProductId());
			gb.setBookCount(gd.get(i).getBookCount());
			gb.setTotalCount(gd.get(i).getTotalCount());
			glist.add(gb);
		}

		this.mav.addObject("productList",
				this.orderMgrService.getProductList(3, 0));
		this.mav.addObject("stype", sType);
		this.mav.addObject("sText", sText);
		int pageNo = 0, itemCount = 0, pageCount = 20;
		if (page != null)
			pageNo = Integer.parseInt(page);
		itemCount = glist.size();
		this.doPager(pageNo, itemCount, pageCount);
		this.mav.addObject("groupList", glist);

		this.mav.setViewName("drive/group/set");
		return this.mav;
	}

	@RequestMapping(value = "/getSpecKey", method = RequestMethod.GET)
	@ResponseBody
	public String getSpecKey(
			@RequestParam(value = "specId", required = true) int specId) {
		MetaKeys keys = this.travelerService.getMetaKeysByUri(String
				.valueOf(specId));
		if (keys == null)
			keys = this.travelerService.updateMetaKeys(String.valueOf(specId),
					"");
		Gson g = new Gson();
		try {
			keys.setKeywords(java.net.URLEncoder.encode(keys.getKeywords(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "[" + g.toJson(keys) + "]";
	}

	@RequestMapping(value = "/updateKey", method = RequestMethod.POST)
	@ResponseBody
	public String updateKey(
			@RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "keys", required = true) String newKeys) {
		newKeys = newKeys.replace("，", ",");
		return this.travelerService.saveMetaKeys(id, newKeys);
	}
}
