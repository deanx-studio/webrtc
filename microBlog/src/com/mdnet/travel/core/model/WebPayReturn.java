package com.mdnet.travel.core.model;

public class WebPayReturn extends PayReturn {
	
	//payment_type=1//公共数据
	//subject=%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%E4%B8%93%E7%94%A8
	//trade_no=2014062622231906
	//buyer_email=13911531721
	//gmt_create=2014-06-26+17%3A29%3A12
	//notify_type=trade_status_sync
	//quantity=1
	//out_trade_no=1425204129
	//notify_time=2014-06-26+17%3A29%3A50
	//seller_id=2088111975464271
	//trade_status=TRADE_SUCCESS
	//is_total_fee_adjust=N
	//total_fee=0.01
	//gmt_payment=2014-06-26+17%3A29%3A50
	//seller_email=tbshop%40zhinet.net
	//price=0.01
	//buyer_id=2088402527303062
	//notify_id=67a1133f8bbd91ee2677ad94b704c46c2c
	//use_coupon=N
	//sign=6e2f55c928b39449a3a345ea43246f06
	
	protected String discount;//=0.00&
	protected String body;//=ZWMD
	protected String sign_type;//=MD5
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
		
}
