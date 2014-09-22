package com.mdnet.travel.order.model;

public class ProductDetail {
	private ProductInfo productInfo;
	private ProductPriceLine price;
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	public ProductPriceLine getPrice() {
		return price;
	}
	public void setPrice(ProductPriceLine price) {
		this.price = price;
	}
}
