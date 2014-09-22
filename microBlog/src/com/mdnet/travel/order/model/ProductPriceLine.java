package com.mdnet.travel.order.model;

public class ProductPriceLine {
	private int id;//
	private int productId;//产品编码
	private int lowPrice;//最低价格
	private int offPrice;//优惠部分的价格（不是优惠后的价格）
	private int bookPrice;//预订价格
	private int salePrice;//零售价格
	private String startValidate;//有效期起始日期
	private String endValidate;//有效期截止日期,有效期
	private String priceMemo;//价格说明
	private String modifyTime;//最后修改时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public int getOffPrice() {
		return offPrice;
	}
	public void setOffPrice(int offPrice) {
		this.offPrice = offPrice;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public String getStartValidate() {
		return startValidate;
	}
	public void setStartValidate(String startValidate) {
		this.startValidate = startValidate;
	}
	public String getEndValidate() {
		return endValidate;
	}
	public void setEndValidate(String endValidate) {
		this.endValidate = endValidate;
	}
	public String getPriceMemo() {
		return priceMemo;
	}
	public void setPriceMemo(String priceMemo) {
		this.priceMemo = priceMemo;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
}
