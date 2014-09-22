package com.mdnet.travel.core.model;

public class MobilePayReturn extends PayReturn{
	
//	payment_type : 1
//	subject : 支付测试专用
//	trade_no : 2014042372689955
//	buyer_email : 13661119413
//	gmt_create : 2014-04-23 17:37:52
//	notify_type : trade_status_sync
//	quantity : 1
//	out_trade_no : 1390628422
//	notify_time : 2014-04-23 17:38:18
//	seller_id : 2088111975464271
//	trade_status : TRADE_FINISHED
//	is_total_fee_adjust : N
//	total_fee : 0.01
//	gmt_payment : 2014-04-23 17:38:18
//	seller_email : tbshop@zhinet.net
//	gmt_close : 2014-04-23 17:38:18
//	price : 0.01
//	buyer_id : 2088302180405551
//	notify_id : 4e127d6cc7ac3e426b8ed50363625d2f52
//	use_coupon : N
	
	//
	protected String gmt_close;
	public String getGmt_close() {
		return gmt_close;
	}

	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}


}
