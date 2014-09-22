package com.mdnet.travel.core.weixin.shop;

public class DeliveryInfo {
	private int delivery_type;//": 0,
	private int template_id;//": 0, 
	private Express[] express;
	public int getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(int delivery_type) {
		this.delivery_type = delivery_type;
	}
	public int getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}
	public Express[] getExpress() {
		return express;
	}
	public void setExpress(Express[] express) {
		this.express = express;
	}
}
