package com.mdnet.travel.core.model;

public class WeixinOrder extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String localOrderId;//本平台的订单号
	public String getLocalOrderId() {
		return localOrderId;
	}
	public void setLocalOrderId(String localOrderId) {
		this.localOrderId = localOrderId;
	}
	private String weixinOrderId;// "7197417460812533543",
	private int orderStatus;// 6,
	private int orderTotalPrice;// 6,
	private int orderCreateTime;// 1394635817,
	private int orderExpressPrice;// 5,
	private String buyerOpenid;// "oDF3iY17NsDAW4UP2qzJXPsz1S9Q",
	private String buyerNick;// "likeacat",
	private String receiverName;// "张小猫",
	private String receiverProvince;// "广东省",
	private String receiverCity;// "广州市",
	private String receiverAddress;// "华景路一号南方通信大厦5楼",
	private String receiverMobile;// "123456789",
	private String receiverPhone;// "123456789",
	private String productId;// "pDF3iYx7KDQVGzB7kDg6Tge5OKFo",
	private String productName;// "安莉芳E-BRA专柜女士舒适内衣蕾丝3/4薄杯聚拢上托性感文胸KB0716",
	private int productPrice;// 1,
	private String productSku;// "10000983:10000995;10001007:10001010",
	private int productCount;// 1,
	private String productImg;// "http://img2.paipaiimg.com/00000000/item-52B87243-63CCF66C00000000040100003565C1EA.0.300x300.jpg",
	private String deliveryId;// "1900659372473",
	private String deliveryCompany;// "059Yunda",
	private String transId;// "1900000109201404103172199813"
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getWeixinOrderId() {
		return weixinOrderId;
	}
	public void setWeixinOrderId(String weixinOrderId) {
		this.weixinOrderId = weixinOrderId;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public int getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(int orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	public int getOrderExpressPrice() {
		return orderExpressPrice;
	}
	public void setOrderExpressPrice(int orderExpressPrice) {
		this.orderExpressPrice = orderExpressPrice;
	}
	public String getBuyerOpenid() {
		return buyerOpenid;
	}
	public void setBuyerOpenid(String buyerOpenid) {
		this.buyerOpenid = buyerOpenid;
	}
	public String getBuyerNick() {
		return buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverProvince() {
		return receiverProvince;
	}
	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}
	public String getReceiverCity() {
		return receiverCity;
	}
	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductSku() {
		return productSku;
	}
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryCompany() {
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
}
