package com.mdnet.travel.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wxpay")
public class WxPayController extends BaseController {
	@RequestMapping("/test")
	public ModelAndView test() {
		this.getMav();
		this.mav.setViewName("wxpay/test");
		return this.mav;

	}
	
	/**
	 * 例子：
	 * "POST /travel-weixin/wxpay/notify?bank_billno=201407082392879&bank_type=3003&discount=0&fee_type=1&input_charset=UTF-8&notify_id=-60tV5zvWajHOCR26a57uuPo31MTN8TtQQTXvL6f3TMlChTvIFyN-MLJjl2y8aUJAHlYwwE7bro6JB6UfrRVT1iq-VOK74z5&out_trade_no=TkcRTRTMPikkmANb&partner=1219880101&product_fee=1&sign=A969C39687BCCC7F8535924C14B7A7D2&sign_type=MD5&time_end=20140708105811&total_fee=1&trade_mode=1&trade_state=0&transaction_id=1219880101201407083173341140&transport_fee=0 HTTP/1.0"
	 * @param request
	 * @return
	 */
	@RequestMapping("/notify")
	@ResponseBody
	public String payNotify(HttpServletRequest request) {
		
		return "success";

	}
	@RequestMapping("/wq")
	@ResponseBody
	public String Weiquan(HttpServletRequest request) {
		
		return "success";

	}
	
	/**
	 * native支付结果通知
	 * @param request
	 * @return
	 */
	@RequestMapping("/payNotify")
	@ResponseBody
	public String nativePayNotify(HttpServletRequest request) {
		
		return "success";

	}

	
	@RequestMapping("/pay")
	@ResponseBody
	public String payReq(HttpServletRequest request) {
		
		return "success";

	}
	@RequestMapping("/warning")
	@ResponseBody
	public String warning(HttpServletRequest request) {
		
		return "success";

	}
	
}
