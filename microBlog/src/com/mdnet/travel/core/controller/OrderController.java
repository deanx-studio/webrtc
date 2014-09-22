package com.mdnet.travel.core.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.zhinet.travel.pojo.basepojo.OrderInfo;
import net.zhinet.travel.pojo.basepojo.TicketInfo;
import net.zhinet.travel.pojo.reqandrespojo.Order_CreateRes;
import net.zhinet.travel.pojo.reqandrespojo.Order_ListRes;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmRes;
import net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.travel.core.model.MobilePayReturn;
import com.mdnet.travel.core.model.PayReturn;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.service.Alipay;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.utils.ProcessMessageUtil;
import com.mdnet.travel.core.utils.SimpleDateUtil;
import com.mdnet.travel.core.utils.xStreamOperation;
import com.mdnet.travel.core.vo.OrderBean;
import com.mdnet.travel.core.vo.OrderConfirmBean;
import com.mdnet.travel.core.vo.SearchBean;
import com.mdnet.travel.core.weixin.menu.MenuManager;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

	private Alipay alipay = new Alipay();

	/**
	 * 此处用SearchBean来捕获搜索条件，其中province:pageNo city:orderId keyword:mobileNumber
	 * 
	 * @param search
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	protected ModelAndView list(
			@RequestParam(value = "openid", required = false) String openId,
			@RequestParam(value = "wid", required = false) String wid,
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			SearchBean search, HttpServletRequest request) {
		this.mav = this.getMav();
		this.mav.setViewName("order/list");
		openId = this.getOpenId(request, openId);
		if (openId == null)// 微信的ID不能为空，该请求需要从微信发起
		{
			// 提示使用微信登录
			this.mav.addObject("message", "对不起，不能获取您的身份信息，请确认从微信菜单请求。");
			return this.mav;
		}

		// 通过openId获取手机号码
		Traveler traveler = this.travelerService.findTravelByOpenId(openId);
		String mobile = "";
		String uname = "";
		if (traveler != null) {
			mobile = traveler.getMobile();
			uname = traveler.getUsername();
		}

		// mobile为空则重定向到微信ID和手机号码绑定页面
		if (mobile.length() <= 0) {
			this.mav.addObject("openId", openId);
			this.mav.setViewName("subscribe/bind");
			return this.mav;
		}

		// 获取订单记录
		List<OrderBean> orderViewList = getOrderList(pageNo, mobile);
		for (OrderBean orderList : orderViewList) {
			this.alipay.setMyConstant(myConstant);
			String zhifuUrl = this.alipay.createPayUrl(request,
					orderList.getOrderID(), orderList.getTicketName(),
					orderList.getOrderTotalMoney());
			orderList.setPayUrl(zhifuUrl);
		}
		int itemCount = 0;
		if (orderViewList != null)
			itemCount = orderViewList.size();
		else
			this.mav.addObject("message", "对不起，没有找到" + mobile + "的订单数据");
		this.mav.addObject("openId", openId);
		this.mav.addObject("orderList", orderViewList);
		this.mav.addObject("search_condition", search);
		this.pageCount = 10;
		this.doPager(pageNo != null ? pageNo : 1, itemCount);
		this.pageCount = 20;
		this.mav.addObject("uname", uname);
		this.mav.addObject("mobile", mobile);
		return this.mav;
	}

	public List<OrderBean> getOrderList(Integer pageNo, String mobile) {
		OrderInfo[] orderList = null;
		List<OrderBean> orderViewList = new ArrayList<OrderBean>();
		if (!StringUtils.isEmpty(mobile)) {
			try {
				// mobile, orderId, pageNo
				if (null != pageNo) {
					orderList = getProxy().findOrder(mobile, null, pageNo);
				} else {
					orderList = getProxy().findOrder(mobile, null, 1);
				}

			} catch (RemoteException e1) {
				orderList = null;
			}
			if (null != orderList) {

				for (OrderInfo order : orderList) {
					OrderBean orderBean = new OrderBean(order.getOrderID(),
							order.getOrderTotalMoney(), order.getOrderDate(),
							order.getOrderState(), null, order.getViewName(),
							order.getPlayDate(), null, order.getViewID(),
							order.getTicketId(), order.getAmount());
					orderBean.setTicketName(order.getTicketName());
					// 获取产品信息
					TicketInfo ti = getTicketInfo(order.getTicketId(),
							order.getViewID());
					if (ti != null) {
						orderBean.setImgUrl(ti.getImgUrl());
						orderBean.setProductState(0);// 上架
					} else
						orderBean.setProductState(1);// 下架
					orderViewList.add(orderBean);
				}
			}
		} else {
			orderViewList = null;
		}
		return orderViewList;
	}

	private TicketInfo getTicketInfo(int ticketId, int viewId) {
		List<TicketInfo> ticketList = new ArrayList<TicketInfo>();
		TicketInfo ticket = null;
		try {
			ticketList = getProxy().getTicketByVTID(ticketId, viewId);
		} catch (RemoteException e) {
			this.logger.error(e.getMessage());
			ticketList = null;
		}

		if (ticketList != null) {
			if (ticketList.size() == 1) {
				ticket = ticketList.get(0);
			}
		}

		return ticket;

	}

	/**
	 * 
	 * @param ticketId
	 * @param scenicId
	 * @return
	 */
	//
	@RequestMapping(value = "/go_pay", method = RequestMethod.GET)
	public ModelAndView goPay(@RequestParam("ticketId") Integer ticketId,
			@RequestParam(value = "openid", required = false) String openId,
			@RequestParam("scenicId") Integer scenicId,
			HttpServletRequest request) {
		openId = this.getOpenId(request, openId);

		/**
		 * 通过得到的票id，还有景区id联合传
		 */
		List<TicketInfo> targetTicketList = new ArrayList<TicketInfo>();
		TicketInfo targetTicket = null;
		try {
			targetTicketList = getProxy().getTicketByVTID(ticketId, scenicId);
		} catch (RemoteException e) {
			targetTicketList = null;
		}
		String travel_price = "";

		String travel_start_date = "";
		String travel_end_date = "";
		PriceCanledarRes priceCanledarRes = null;
		int message = 0;
		if (targetTicketList.size() <= 1) {

			targetTicket = targetTicketList.get(0);

			String proServe = targetTicket.getProReserve();

			targetTicket.setProReserve(proServe.replaceAll("\n", "<br />")
					.trim());

			travel_start_date = SimpleDateUtil.getUserDefinedDateTomorrow(
					new Date(), targetTicket.getPreOrderDays());
			travel_end_date = SimpleDateUtil.getUserDefinedDateTomorrow(
					new Date(), targetTicket.getPreOrderDays() + 1);

			if (targetTicket.getIsNeedDate() == 1
					|| targetTicket.getIsNeedDate() == 2) {
				try {
					priceCanledarRes = getProxy().getPriceByDate(
							travel_start_date, travel_end_date,
							targetTicket.getTicketId());
					message = priceCanledarRes.getPriceResult().getSalePrice();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					this.logger
							.error("查询价格时出现错误，错误为"
									+ priceCanledarRes.getResponseHead()
											.getResultMsg());
					message = 0;
					e.printStackTrace();
				}

				travel_price = new DecimalFormat("0.00")
						.format(message / 100.0);
			} else {
				travel_price = new DecimalFormat("0.00").format(targetTicket
						.getSalePrice() / 100.0);
				travel_end_date = targetTicket.getEndValidate();
			}
		}

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(travel_start_date);
		cal.add(cal.DATE, 1);
		Object[] weekday = new Object[7];
		weekday[0] = "星期日";
		weekday[1] = "星期一";
		weekday[2] = "星期二";
		weekday[3] = "星期三";
		weekday[4] = "星期四";
		weekday[5] = "星期五";
		weekday[6] = "星期六";
		// Date begin = java.sql.Date.valueOf(sdf.format(cal.getTime()));

		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(begin);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String w = (String) weekday[dayOfWeek - 1];// [begin.getDay()];

		mav = this.getMav();
		mav.addObject("w", w);
		mav.addObject("start_travel_date", travel_start_date);
		mav.addObject("end_travel_date", travel_end_date);
		mav.addObject("Ticket", targetTicket);
		mav.addObject("travel_price", travel_price);

		if (targetTicket.getIsNeedDate() == 1
				|| targetTicket.getIsNeedDate() == 2) {
			mav.setViewName("order/go_restaurant");

		} else {
			mav.setViewName("order/go_pay");
		}

		// 设置手机号码
		if (openId != null && openId.length() > 0) {
			Traveler traveler = this.travelerService.findTravelByOpenId(openId);
			this.mav.addObject("mobile", traveler.getMobile());
			this.mav.addObject("username", traveler.getUsername());
		}
		return mav;
	}

	// 获取订单号

	@RequestMapping(value = "/confirm")
	public String orderConfirm(HttpServletRequest request,
			OrderConfirmBean orderConfirm) {
		// 得到具体传过来的值
		String orderNum = orderConfirm.getNumber();

		String user = orderConfirm.getUser();
		String mobile = orderConfirm.getMobile();
		String confirm_mobile = orderConfirm.getConfirmMobile();
		String ticketId = orderConfirm.getTicketId();
		String endDate = orderConfirm.getEndDate();
		String ticketName = orderConfirm.getTicketName();
		String preOrderDays = orderConfirm.getPreOrderDays();
		String zhifuUrl = null;
		// 验证两个电话号码是否一致
		if (!mobile.equals(confirm_mobile)) {
			// TODO 未做处理

		} else {
			// 通过页面上传过来的值生成订单，并返回详细信息
			Order_CreateRes order_CreateRes = null;
			// 创建订单
			try {

				order_CreateRes = getProxy().orderCreateRes(confirm_mobile,
						orderConfirm.getStartDate(), endDate, user, orderNum,
						ticketId, 0, 0, ticketName);

				if (order_CreateRes.getResponseHead().getResultCode() != 0) {

					this.logger.error("订单创建失败，原因为"
							+ order_CreateRes.getResponseHead().getResultMsg());

					request.setAttribute("message", "下单失败:"
							+ order_CreateRes.getResponseHead().getResultMsg());
					return "common/success";

				}

				// 支付
				String orderId = order_CreateRes.getOrderId();
				String totalFee = order_CreateRes.getCustomerPayMoney();
				this.alipay.setMyConstant(myConstant);
				zhifuUrl = this.alipay.createPayUrl(request, orderId,
						ticketName, totalFee);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return this.REDIRECT + zhifuUrl;
	}

	@RequestMapping("/orderStatus")
	public ModelAndView showStatus(HttpServletRequest request) {

		String payOrderId = request.getParameter("trade_no");
		String orderId = request.getParameter("out_trade_no");

		Order_ListRes order_ListRes = getProxy().findOrderByOrderId(orderId);

		mav = this.getMav();
		mav.addObject("order_object", order_ListRes.getOrderList()[0]);
		mav.setViewName("order/orderStatus");
		return mav;

	}

	// @RequestMapping(value = "/payment", method = RequestMethod.POST)
	// public ModelAndView payment(HttpServletRequest request) {
	// // TODO 支付宝回调处理，get参数可参考PayServlet的注释
	//
	// // String payMoney = (Double
	// // .parseDouble(request.getParameter("total_fee")) * 100) + "";
	// Long time = SimpleDateUtil.curTimeMillis();
	//
	// String payOrderId = request.getParameter("trade_no");
	// String orderId = request.getParameter("out_trade_no");
	//
	// Order_ListRes order_ListRes = getProxy().findOrderByOrderId(orderId);
	//
	// // 得到订单钱数
	// String payMoney = order_ListRes.getOrderList()[0].getCustomerPayMoney();
	//
	// // 调用支付确认接口，并返回支付结果
	//
	// String trade_status = ProcessMessageUtil.getNumValue(
	// request.getParameter("trade_status"),
	// request.getParameter("result"));
	//
	// String returnView = "";
	// // 如果成功，执行此程序体
	// if (trade_status.toUpperCase().equals("TRADE_SUCCESS")
	// || trade_status.toUpperCase().equals("SUCCESS")) {
	// // 将订单确认请求进行封装
	// // new Order_Pay_ConfirmReq(orderId, payDate, payMoney, payOrderId,
	// // payType, requestHead)
	// Order_Pay_ConfirmReq order_Pay_ConfirmReq = new Order_Pay_ConfirmReq(
	// orderId, SimpleDateUtil.convert2String(time,
	// SimpleDateUtil.DATE_FORMAT), payMoney, payOrderId,
	// 0, ProcessMessageUtil.getHead(Constant.WX_MSGSOURCE,
	// Constant.WX_KEY));
	// Order_Pay_ConfirmRes orderPayConfirmRes = null;
	// request.setAttribute("orderResult", "");
	// mav = this.getMav();
	//
	// try {
	// // 进行订单确认并返回结果
	// orderPayConfirmRes = this.orderManage
	// .order_pay_confirm(order_Pay_ConfirmReq);
	//
	// this.logger.info("订单号为" + request.getParameter("out_trade_no")
	// + "的确认结果："
	// + orderPayConfirmRes.getResponseHead().getResultMsg());
	// mav.addObject("message", orderPayConfirmRes.getResponseHead()
	// .getResultMsg());
	//
	// // 订单确认返回并跳到指定页面
	// returnView = "common/success";
	// } catch (RemoteException e) {
	// this.logger.error("订单号为"
	// + request.getParameter("out_trade_no")
	// + "调用支付确认接口时出现错误,方法是"
	// + Thread.currentThread().getStackTrace()[1]
	// .getMethodName());
	// this.logger.error(e.getMessage());
	// returnView = "common/busy";
	// }
	// } else {
	// this.logger
	// .error("订单号为"
	// + request.getParameter("out_trade_no")
	// + "调用支付确认接口时出现错误,方法是"
	// + Thread.currentThread().getStackTrace()[1]
	// .getMethodName());
	// returnView = "common/fail";
	// }
	//
	// mav.setViewName("common/success");
	// return mav;
	// // return returnView;// 有错，此处应重定向
	// }

	/**
	 * PC终端支付确认测试数据：discount=0.00&payment_type=1&subject=%E6%94%AF%E4%BB%98%E6%
	 * B5%8B%E8%AF%95%E4%B8%93%E7%94%A8&trade_no=2014062622231906&buyer_email=
	 * 13911531721
	 * &gmt_create=2014-06-26+17%3A29%3A12&notify_type=trade_status_sync
	 * &quantity
	 * =1&out_trade_no=1425204129&seller_id=2088111975464271&notify_time
	 * =2014-06- 26+17%3A29%3A50&body=ZWMD&trade_status=TRADE_SUCCESS&
	 * is_total_fee_adjust =N
	 * &total_fee=0.01&gmt_payment=2014-06-26+17%3A29%3A50&seller_email=tbshop%
	 * 40zhinet.net&price=0.01&buyer_id=2088402527303062&notify_id=67
	 * a1133f8bbd91ee2677ad94b704c46c2c
	 * &use_coupon=N&sign_type=MD5&sign=6e2f55c928b39449a3a345ea43246f06
	 * 移动终端支付确认测试数据:service=alipay.wap.trade.create.direct&sign=0f6e632f48375d6
	 * b60a081c6fc8db803&sec_id=MD5&v=1.0&notify_data=%3Cnotify%
	 * 3E%3Cpayment_type%3E1%3C%2Fpayment_type%3E%3Csubject%3E%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%E4%B8%93%E7%94%A8%3C%2Fsubject%3E%3Ctrade_no%3E2014042372689955%3C%2Ftrade_no%3E%3Cbuyer_email%3E13661119413%3C%2Fbuyer_email%3E%3Cgmt_create%3E2014-04-23+17%3A37%3A52%3C%2Fgmt_create%3E%3Cnotify_type%3Etrade_status_sync%3C%2Fnotify_type%3E%3Cquantity%3E1%3C%2Fquantity%3E%3Cout_trade_no%3E1390628422%3C%2Fout_trade_no%3E%3Cnotify_time%3E2014-04-23+17%3A38%3A18%3C%2Fnotify_time%3E%3Cseller_id%3E2088111975464271%3C%2Fseller_id%3E%3Ctrade_status%3ETRADE_FINISHED%3C%2Ftrade_status%3E%3Cis_total_fee_adjust%3EN%3C%2Fis_total_fee_adjust%3E%3Ctotal_fee%3E0.01%3C%2Ftotal_fee%3E%3Cgmt_payment%3E2014-04-23+17%3A38%3A18%3C%2Fgmt_payment%3E%3Cseller_email%3Etbshop%40zhinet.net%3C%2Fseller_email%3E%3Cgmt_close%3E2014-04-23+17%3A38%3A18%3C%2Fgmt_close%3E%3Cprice%3E0.01%3C%2Fprice%3E%3Cbuyer_id%3E2088302180405551%3C%2Fbuyer_id%3E%3Cnotify_id%3E4e127d6cc7ac3e426b8ed50363625d2f52%3C%2Fnotify_id%3E%3Cuse_coupon%3EN%3C%2Fuse_coupon%3E%3C%2Fnoti
	 * f y % 3 E
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView payConfirm(HttpServletRequest request) {

		//记录请求日志
		//this.logger.error(request.get"");
		// 获取支付确认参数
		this.alipay.setMyConstant(myConstant);
		PayReturn payReturn = this.alipay.PayConfirmObj(request);

		Long time = SimpleDateUtil.curTimeMillis();

		this.getMav();

		Order_ListRes order_ListRes = getProxy().findOrderByOrderId(
				payReturn.getOut_trade_no());
		if (order_ListRes == null || order_ListRes.getOrderList() == null
				|| order_ListRes.getOrderList().length == 0) {
			this.mav.addObject("message",
					"对不起,订单号:" + payReturn.getOut_trade_no() + "不存在,请确认！");
			mav.setViewName("common/success");
			return this.mav;
		}
		// 得到订单钱数
		String payMoney = order_ListRes.getOrderList()[0].getCustomerPayMoney();

		// 调用支付确认接口，并返回支付结果
		String trade_status = ProcessMessageUtil.getNumValue(
				payReturn.getTrade_status(), "fail");

		//String returnView = "";

		// 如果成功，执行此程序体
		if (trade_status.toUpperCase().equals("TRADE_FINISHED")) {

			Order_Pay_ConfirmReq order_Pay_ConfirmReq = new Order_Pay_ConfirmReq(
					payReturn.getOut_trade_no(), SimpleDateUtil.convert2String(
							time, SimpleDateUtil.DATE_FORMAT), payMoney,
					payReturn.getTrade_no(), 0, ProcessMessageUtil.getHead(
							this.myConstant.getWX_MSGSOURCE(),
							this.myConstant.getWX_KEY()));
			Order_Pay_ConfirmRes orderPayConfirmRes = null;
			request.setAttribute("orderResult", "");

			try {
				// 进行订单确认并返回结果
				orderPayConfirmRes = this.getProxy().OrderPayConfirm(
						order_Pay_ConfirmReq);

				this.logger.info("订单号为" + payReturn.getOut_trade_no()
						+ "的确认结果："
						+ orderPayConfirmRes.getResponseHead().getResultMsg());
				mav.addObject("message", orderPayConfirmRes.getResponseHead()
						.getResultMsg());

				// 订单确认返回并跳到指定页面
				//returnView = "common/success";
			} catch (Exception e) {
				this.logger.error("订单号为"
						+ request.getParameter("out_trade_no")
						+ "调用支付确认接口时出现错误,方法是"
						+ Thread.currentThread().getStackTrace()[1]
								.getMethodName());
				this.logger.error(e.getMessage());
				//returnView = "common/busy";
			}

		} else {
			this.logger
					.error("订单号为"
							+ payReturn.getOut_trade_no()
							+ "调用支付确认接口时出现错误,方法是"
							+ Thread.currentThread().getStackTrace()[1]
									.getMethodName());
			//returnView = "common/success";
		}

		mav.setViewName("common/success");
		return mav;

	}

	@RequestMapping("/getPriceForDate")
	@ResponseBody
	public String getPriceForDate(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("productNo") int productNo) {

		PriceCanledarRes priceCanledarRes = new PriceCanledarRes();
		int message = 0;
		//String price = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String json = "";
		String time = "";

		Date begin = null;
		Date end = null;
		try {
			begin = sdf.parse(startDate);
			end = sdf.parse(endDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		double between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		double day = between / (24 * 3600);

		String t = "";
		for (int i = 1; i <= day; i++) {
			Calendar cd = Calendar.getInstance();
			try {
				cd.setTime(sdf.parse(startDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cd.add(Calendar.DATE, i - 1);// 增加一天
			time = sdf.format(cd.getTime());
			if (i == 1) {
				t += time;
			} else {
				t += "," + time;
			}
		}

		// String price = getPriceByDate(startDate,endDate,productNo);
		// 将结果返回到页面i
		try {

			priceCanledarRes = getProxy().getPriceByDate(startDate, endDate,
					productNo);

			if (priceCanledarRes != null
					&& priceCanledarRes.getPriceResult() != null) {

				message = priceCanledarRes.getPriceResult()
						.getDistributePrice();
				this.logger.info("价格查询成功，结果为" + message);
				// price = new DecimalFormat("0.00").format(message / 100.0);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson g = new Gson();
		json = g.toJson(priceCanledarRes);

		return json;

	}
}
