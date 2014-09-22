package com.mdnet.travel.core.model;


public class Customer extends BaseModel {
	private static final long serialVersionUID = 61L;

	// 标识属性
	private Integer id;
	// 发送方账号(OpenID)
	private String fromUserName;
	// 订阅时间
	private String subscribeTime;
	// 取消订阅时间
	private String unSubscribeTime;
	// 最后活跃时间(在接收消息的时候每次更新相应CreateTime)
	private String lastVisit;
	// 地理位置维度
	private String location_x;
	// 地理位置精度
	private String location_y;
	// 地理位置信息
	private String label;

	public Customer(){}
	public Customer(String fromUserName){
		this.fromUserName = fromUserName;
	}
	public Customer(String fromUserName, String subscribeTime,
			String unSubscribeTime, String lastVisit, String location_x,
			String location_y, String label) {
		super();
		this.fromUserName = fromUserName;
		this.subscribeTime = subscribeTime;
		this.unSubscribeTime = unSubscribeTime;
		this.lastVisit = lastVisit;
		this.location_x = location_x;
		this.location_y = location_y;
		this.label = label;
	}

	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnSubscribeTime() {
		return unSubscribeTime;
	}

	public void setUnSubscribeTime(String unSubscribeTime) {
		this.unSubscribeTime = unSubscribeTime;
	}

	public String getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getLocation_x() {
		return location_x;
	}

	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}

	public String getLocation_y() {
		return location_y;
	}

	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
