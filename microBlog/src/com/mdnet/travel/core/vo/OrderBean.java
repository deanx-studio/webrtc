package com.mdnet.travel.core.vo;

public class OrderBean extends BasicBean{
	private static final long serialVersionUID = 20338L;
	private String orderID;//订单 号
	private String orderTotalMoney;//订单金额
	private String orderDate;//下单时间
	private Integer orderState;//订单状态
	private String ticketName;//门票名称
	private String viewName;//景点名称
	private String playDate;//游玩时间
	private String imgUrl; //图片URL
	private  int viewId; //景区ID
	private int ticketId; //票ID
	private int orderNumber; //订单数量
	private String payUrl;
	private int productState;
	public int getProductState() {
		return productState;
	}
	public void setProductState(int productState) {
		this.productState = productState;
	}
	public String getPayUrl() {
		return payUrl;
	}
	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public OrderBean(String orderID, String orderTotalMoney, String orderDate,
			Integer orderState, String ticketName, String viewName,
			String playDate, String imgUrl,int viewId, int ticketId,int orderNumber) {
		this.orderID = orderID;
		this.orderTotalMoney = orderTotalMoney;
		this.orderDate = orderDate;
		this.orderState = orderState;
		this.ticketName = ticketName;
		this.viewName = viewName;
		this.playDate = playDate;
		this.imgUrl = imgUrl;
		this.viewId = viewId;
		this.ticketId = ticketId;
		this.orderNumber = orderNumber;
	}
	public int getViewId() {
		return viewId;
	}
	public void setViewId(int viewId) {
		this.viewId = viewId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderTotalMoney() {
		return orderTotalMoney;
	}
	public void setOrderTotalMoney(String orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getPlayDate() {
		return playDate;
	}
	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
