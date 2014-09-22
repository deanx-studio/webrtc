package com.mdnet.travel.core.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.MobilePayReturn;
import com.mdnet.travel.core.model.PayReturn;
import com.mdnet.travel.core.model.WebPayReturn;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.utils.xStreamOperation;

public class Alipay {

	protected Constant myConstant;

	public void setMyConstant(Constant constant) {
		this.myConstant = constant;
	}

	public PayReturn PayConfirmObj(HttpServletRequest request) {

		if (request.getParameter("notify_data") != null
				&& request.getParameter("notify_data").length() > 0) {
			String return_xml = request.getParameter("notify_data"); // post过来的消息，移动终端支付有notify_data

			try {
				String notify_data = CommonUtils.getValuedecode(return_xml,
						"UTF-8");
				return (MobilePayReturn) xStreamOperation.XMLToObject(
						notify_data, "notify", MobilePayReturn.class);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} // 解密post过来的消息
		} else {

			return this.convertWebPayReturn(request);
		}

	}

	protected WebPayReturn convertWebPayReturn(HttpServletRequest request) {
		WebPayReturn webPayReturn = new WebPayReturn();
		webPayReturn.setPayment_type(request.getParameter("payment_type"));
		webPayReturn.setSubject(request.getParameter("subject"));
		webPayReturn.setTrade_no(request.getParameter("trade_no"));
		webPayReturn.setBuyer_email(request.getParameter("buyer_email"));
		webPayReturn.setGmt_create(request.getParameter("gmt_create"));
		webPayReturn.setNotify_type(request.getParameter("notify_type"));
		webPayReturn.setQuantity(request.getParameter("quantity"));
		webPayReturn.setOut_trade_no(request.getParameter("out_trade_no"));
		webPayReturn.setNotify_time(request.getParameter("notify_time"));
		webPayReturn.setSeller_id(request.getParameter("seller_id"));
		webPayReturn.setTrade_status(request.getParameter("trade_status"));
		webPayReturn.setIs_total_fee_adjust(request
				.getParameter("is_total_fee_adjust"));
		webPayReturn.setTotal_fee(request.getParameter("total_fee"));
		webPayReturn.setGmt_payment(request.getParameter("gmt_payment"));
		webPayReturn.setSeller_email(request.getParameter("seller_email"));
		webPayReturn.setPrice(request.getParameter("price"));
		webPayReturn.setBuyer_id(request.getParameter("buyer_id"));
		webPayReturn.setNotify_id(request.getParameter("notify_id"));
		webPayReturn.setUse_coupon(request.getParameter("use_coupon"));
		webPayReturn.setSign(request.getParameter("sign"));

		webPayReturn.setDiscount(request.getParameter("discount"));
		webPayReturn.setBody(request.getParameter("body"));
		webPayReturn.setSign_type(request.getParameter("sign_type"));
		return webPayReturn;
	}

	public String createPayUrl(HttpServletRequest request, String orderId,
			String ticketName, String totalFee) {
		// String appUrl = request.getRequestURL().toString();
		// String context = request.getContextPath();
		// String[] contes = appUrl.split(context);
		String returnUr = /* contes[0] + context */
		this.myConstant.getPayConfirmUrl() + "/order/orderStatus";

		String notify_url = /* contes[0] + context */this.myConstant
				.getPayConfirmUrl() + "/order/payment.do";// TODO
		String returnUrl = null;
		String ticketN = null;
		try {
			returnUrl = URLEncoder.encode(returnUr, "UTF-8");
			ticketN = URLEncoder.encode(ticketName, "UTF-8");
			notify_url = URLEncoder.encode(notify_url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String payUrl = "";
		if (CommonUtils.IsMobile(request))// 移动终端支付地址
			payUrl = this.myConstant.getPAY_MOBILE();
		else
			// PC支付地址
			payUrl = this.myConstant.getPAY_WEB();
		String usrPayUrl = payUrl// myConstant.getPAY_MOBILE()
				+ "?return_url="
				+ returnUrl
				+ "&notify_url="
				+ notify_url
				+ "&out_trade_no="
				+ orderId
				+ "&subject="
				+ ticketN
				+ "&total_fee="
				+ ((totalFee != null) ? (Integer.parseInt(totalFee) / 100.0)
						: 0) + "&merchant_url=&out_user=";
		// System.out.println(
		// myConstant.getPAY_MOBILE()
		// + "?return_url="
		// + returnUrl
		// + "&notify_url="
		// + notify_url
		// + "&out_trade_no="
		// + orderId
		// + "&subject="
		// + ticketN
		// + "&total_fee="
		// + ((totalFee != null) ? (Integer.parseInt(totalFee) / 100.0)
		// : 0) + "&merchant_url=&out_user=");

		return usrPayUrl;
	}
}
