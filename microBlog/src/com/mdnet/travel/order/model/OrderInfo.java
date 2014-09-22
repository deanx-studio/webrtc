package com.mdnet.travel.order.model;

public class OrderInfo {
	private int id;
	// 产品信息
	private int productId;// 产品ID
	private String productName;// 产品名称

	// 消费者/用户信息
	private int productPrice;// 产品单价 单位：分，可以有两位小数
	private int amount;// 购买数量 整数
	private int childrenCount;// 包含儿童的数量
	private int childrenBedsCount;
	private int adultCount;
	private int oldCount;
	
	private String userName;// 消费者姓名
	private String userMobile;// 消费者手机号
	private String userCardNo;// 消费者证件号码

	private String orderDate;// 下单时间
	// 支付信息
	private String payDate;// 付款时间
	private int payMoney;// 产品售价，支付总金额 单位：分，可以有两位小数
	private int customerPayMoney;// 实际支付总金额 单位：分，可以有两位小数
	private int payChannel;// 付款渠道，默认为0，0：支付宝；1：财付通；2：微信
	private String payOrderId;// 支付ID

	// 订单管理信息
	private int orderState;// 订单状态:
							// 0-无记录；1-下单；2-下单失败；3：出单/支付成功；4：客户取消；5：退款；6：已经消费
	private String orderId;//
	private String arriveDate;// 到达时间

	// 渠道/下单方信息
	private String bookerName;// 下单人名称信息
	private String bookerPhone;// 下单人手机号
	private String channelSourceId;// 购买渠道/平台标识

	// 消费结果
	private int consumeCount;// 消费数量
	private String lastConsumeTime;// 最后消费时间

	public int getChildrenBedsCount() {
		return childrenBedsCount;
	}

	public void setChildrenBedsCount(int childrenBedsCount) {
		this.childrenBedsCount = childrenBedsCount;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getOldCount() {
		return oldCount;
	}

	public void setOldCount(int oldCount) {
		this.oldCount = oldCount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserCardNo() {
		return userCardNo;
	}

	public void setUserCardNo(String userCardNo) {
		this.userCardNo = userCardNo;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(int childrenCount) {
		this.childrenCount = childrenCount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public int getCustomerPayMoney() {
		return customerPayMoney;
	}

	public void setCustomerPayMoney(int customerPayMoney) {
		this.customerPayMoney = customerPayMoney;
	}

	public int getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(int payChannel) {
		this.payChannel = payChannel;
	}

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getBookerName() {
		return bookerName;
	}

	public void setBookerName(String bookerName) {
		this.bookerName = bookerName;
	}

	public String getBookerPhone() {
		return bookerPhone;
	}

	public void setBookerPhone(String bookerPhone) {
		this.bookerPhone = bookerPhone;
	}

	public String getChannelSourceId() {
		return channelSourceId;
	}

	public void setChannelSourceId(String channelSourceId) {
		this.channelSourceId = channelSourceId;
	}

	public int getConsumeCount() {
		return consumeCount;
	}

	public void setConsumeCount(int consumeCount) {
		this.consumeCount = consumeCount;
	}

	public String getLastConsumeTime() {
		return lastConsumeTime;
	}

	public void setLastConsumeTime(String lastConsumeTime) {
		this.lastConsumeTime = lastConsumeTime;
	}

}
