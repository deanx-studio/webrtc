package com.mdnet.travel.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.mdnet.travel.core.common.Constant;

import net.zhinet.travel.pojo.basepojo.RequestHead;

public class ProcessMessageUtil {
	//@Resource(name = "Constant")
	//protected static Constant myConstant;

	// 设置消息头
	/**
	 * 
	 * @param msgSource分销商的来源
	 * @param key他们之间的密钥
	 * @return
	 */
	public static RequestHead getHead(String msgSource, String key) {

		RequestHead requestHead = new RequestHead();

		requestHead.setMsgReqTime(SimpleDateUtil.convert2String(
				SimpleDateUtil.curTimeMillis(), SimpleDateUtil.TIME_FORMAT));
		requestHead.setMsgSerail(SimpleDateUtil.getUUID());
		requestHead.setMsgSource(msgSource);
		requestHead.setMsgType(1);
		String key_str = MD5
				.getMD5((key + requestHead.getMsgReqTime() + requestHead
						.getMsgSerail()).getBytes());
		requestHead.setSign(key_str);
		return requestHead;
	}

	// 判断一个字符是否为数字，如果为空或字符，则置为defaultValue
	public static int getNumValue(String str, int defaultValue) {
		if (str != null) {
			if (!str.trim().equals("")) {
				defaultValue = Integer.parseInt(str);
			}
		}
		return defaultValue;
	}

	// 判断一个字符是否有值，如果为空或空字符，则置为defaultValue
	public static String getNumValue(String str, String defaultValue) {
		if (str != null) {
			if (!str.trim().equals("")) {
				defaultValue = str;
			}
		}
		return defaultValue;
	}

	// 支付宝回调的get参数：
	// http://127.0.0.1:3703/Touch/jqmp/return_url.aspx?
	// vkey=3b8c19b6f3e193b4da3a7a7fb15690de
	// &buyer_email=13911531721
	// &buyer_id=2088402527303062
	// &exterface=create_direct_pay_by_user
	// &is_success=T
	// &notify_id=""
	// &notify_time=2013-11-29+10%3A26%3A15
	// &notify_type=trade_status_sync
	// &out_trade_no=1216057
	// &payment_type=1
	// &seller_email=pay%40guantu.com
	// &seller_id=""
	// &subject=""
	// &total_fee=2.00
	// &trade_no=2013112921630906
	// &trade_status=TRADE_SUCCESS
	// &sign=cba52ddb74ecb312cd7abac5e5c20261
	// &sign_type=MD5

	
}
