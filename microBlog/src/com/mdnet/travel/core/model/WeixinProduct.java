package com.mdnet.travel.core.model;

public class WeixinProduct extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;//指定使用identity主键生成策略 -->
	private String weixinProductId;//微信平台产品编码
	private int localProductId;//本地产品编码
	private String sku;//产品分类，以,号分开
	private int productPrice;//产品微信零售价
	private int productState;//产品状态，0：下架；1：上架
	private String makeTime;//创建或者最后更新时间
	private String cateId;//产品分类ID
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWeixinProductId() {
		return weixinProductId;
	}
	public void setWeixinProductId(String weixinProductId) {
		this.weixinProductId = weixinProductId;
	}
	public int getLocalProductId() {
		return localProductId;
	}
	public void setLocalProductId(int localProductId) {
		this.localProductId = localProductId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductState() {
		return productState;
	}
	public void setProductState(int productState) {
		this.productState = productState;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	
}
