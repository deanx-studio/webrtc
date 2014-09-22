package com.mdnet.travel.core.vo;

public class ShowProductInfo {
	private int productID;
	private String img;
	private String name;
	private int MediaID;
	private int bookedCount;
	private int fullCount;
	private int lowPrice;
	
	public int getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}
	public int getBookedCount() {
		return bookedCount;
	}
	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	public int getFullCount() {
		return fullCount;
	}
	public void setFullCount(int fullCount) {
		this.fullCount = fullCount;
	}
	public int getMediaID() {
		return MediaID;
	}
	public void setMediaID(int mediaID) {
		MediaID = mediaID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
