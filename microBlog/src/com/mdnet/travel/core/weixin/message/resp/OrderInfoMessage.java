package com.mdnet.travel.core.weixin.message.resp;

public class OrderInfoMessage {
	private int errcode;//	错误码
	private String errmsg;//	错误信息

	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	private String order_id;// "7197417460812533543",
	private int order_status;// 6,
	private int order_total_price;// 6,
	private int order_create_time;// 1394635817,
	private int order_express_price;// 5,
	private String buyer_openid;// "oDF3iY17NsDAW4UP2qzJXPsz1S9Q",
	private String buyer_nick;// "likeacat",
	private String receiver_name;// "张小猫",
	private String receiver_province;// "广东省",
	private String receiver_city;// "广州市",
	private String receiver_address;// "华景路一号南方通信大厦5楼",
	private String receiver_mobile;// "123456789",
	private String receiver_phone;// "123456789",
	private String product_id;// "pDF3iYx7KDQVGzB7kDg6Tge5OKFo",
	private String product_name;// "安莉芳E-BRA专柜女士舒适内衣蕾丝3/4薄杯聚拢上托性感文胸KB0716",
	private int product_price;// 1,
	private String product_sku;// "10000983:10000995;10001007:10001010",
	private int product_count;// 1,
	private String product_img;// "http://img2.paipaiimg.com/00000000/item-52B87243-63CCF66C00000000040100003565C1EA.0.300x300.jpg",
	private String delivery_id;// "1900659372473",
	private String delivery_company;// "059Yunda",
	private String trans_id;// "1900000109201404103172199813"
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getOrder_total_price() {
		return order_total_price;
	}
	public void setOrder_total_price(int order_total_price) {
		this.order_total_price = order_total_price;
	}
	public int getOrder_create_time() {
		return order_create_time;
	}
	public void setOrder_create_time(int order_create_time) {
		this.order_create_time = order_create_time;
	}
	public int getOrder_express_price() {
		return order_express_price;
	}
	public void setOrder_express_price(int order_express_price) {
		this.order_express_price = order_express_price;
	}
	public String getBuyer_openid() {
		return buyer_openid;
	}
	public void setBuyer_openid(String buyer_openid) {
		this.buyer_openid = buyer_openid;
	}
	public String getBuyer_nick() {
		return buyer_nick;
	}
	public void setBuyer_nick(String buyer_nick) {
		this.buyer_nick = buyer_nick;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_province() {
		return receiver_province;
	}
	public void setReceiver_province(String receiver_province) {
		this.receiver_province = receiver_province;
	}
	public String getReceiver_city() {
		return receiver_city;
	}
	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_mobile() {
		return receiver_mobile;
	}
	public void setReceiver_mobile(String receiver_mobile) {
		this.receiver_mobile = receiver_mobile;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_sku() {
		return product_sku;
	}
	public void setProduct_sku(String product_sku) {
		this.product_sku = product_sku;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(String delivery_id) {
		this.delivery_id = delivery_id;
	}
	public String getDelivery_company() {
		return delivery_company;
	}
	public void setDelivery_company(String delivery_company) {
		this.delivery_company = delivery_company;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

}
