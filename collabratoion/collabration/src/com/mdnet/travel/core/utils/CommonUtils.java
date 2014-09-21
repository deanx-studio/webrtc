package com.mdnet.travel.core.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

	/**
	 * 判断是否是从手机或者PAD访问的
	 * 
	 * @param request
	 * @return
	 * true:为移动终端
	 * false:为PC用户
	 */
	public static boolean IsMobile(HttpServletRequest request) {
		String user_agent = request.getHeader("User-Agent");
		String wap_profile = request.getHeader("x-wap-profile");
		if(user_agent ==null)
			return true;
		if (user_agent.contains("Android") || user_agent.contains("iPhone")
				|| (wap_profile != null && wap_profile.length() > 0)) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * 产生四位随机数
	 * @return
	 */
	public static String getRandomSixNum() {
		Random rd = new Random(); // 创建随机对象
		String n = "";
		int rdGet; // 取得随机数
		do {
			rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
			// rdGet=Math.abs(rd.nextInt())%26+97; //产生97到122的随机数(a-z的键位值)
			char num1 = (char) rdGet;
			String dd = Character.toString(num1);
			n += dd;

		} while (n.length() < 6);// 假如长度小于4
		return n;
	}
	
	/**
	 * 
	 * 得到returnUrl
	 */
	public static String getReturnUrl(){
		
		String returnUrl = "/order/orderStatus";
	
		return returnUrl;
	}
	
	/**
	 * 得到notifyUrl
	 * 
	 */
	public static String getNotifyUrl(){
		
		String notify_Url = "/order/payment.do";
		return notify_Url;
	}
	
	
	// 将字符串encode
	public static String getValueEncode(String value, String enc)
			throws UnsupportedEncodingException {

		value = java.net.URLEncoder.encode(value, enc);

		return value;
	}
	
	// 将字符串decode
	public static String getValuedecode(String value, String enc)
			throws UnsupportedEncodingException {

		value = java.net.URLDecoder.decode(value, enc);

		return value;
	}
	
	// 得到项目所在的服务器地址(需在host文件中设置)
	public static String getServerUrl(HttpServletRequest request) {

		String serverUrl = "";
		serverUrl = "http://" + request.getLocalAddr() + ":"
				+ request.getLocalPort();
		return serverUrl;
	}
}
