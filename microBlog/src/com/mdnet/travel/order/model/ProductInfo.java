package com.mdnet.travel.order.model;

public class ProductInfo {
	private int id;//
	private String productName;// 产品名称
	private String startValidate;// 有效期起始日期
	private String endValidate;// 有效期截止日期,有效期
	private String productMemo;// 产品备注说明
	private int providerId;// 供应商ID：0：本平台；其他外平台
	private String productNo;// provider_id为非0时，在其他平台的产品编码
	private String applyTo;// 适用人群
	private String productDesc;// 产品说明
	private String bookDesc;// 预订说明
	private String imgURL;// 产品主图地址
	private int shelvesState;// 产品状态：0-下架；1-上架
	private int productType;// 产品类型：0：普通门票；1：指定日期门票；2：酒店；3：境外自驾
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getProductMemo() {
		return productMemo;
	}
	public void setProductMemo(String productMemo) {
		this.productMemo = productMemo;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getApplyTo() {
		return applyTo;
	}
	public void setApplyTo(String applyTo) {
		this.applyTo = applyTo;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public int getShelvesState() {
		return shelvesState;
	}
	public void setShelvesState(int shelvesState) {
		this.shelvesState = shelvesState;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}

}
