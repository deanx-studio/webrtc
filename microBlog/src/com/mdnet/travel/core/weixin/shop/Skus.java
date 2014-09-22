package com.mdnet.travel.core.weixin.shop;

public class Skus {
	private String sku_id;
	private int price;
	private String icon_url;
	private String product_code;
	private int ori_price;
	private int quantity;
	public String getSku_id() {
		return sku_id;
	}
	public void setSku_id(String sku_id) {
		this.sku_id = sku_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIcon_url() {
		return icon_url;
	}
	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public int getOri_price() {
		return ori_price;
	}
	public void setOri_price(int ori_price) {
		this.ori_price = ori_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
