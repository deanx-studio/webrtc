package com.mdnet.travel.core.model;

public class Special extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;// 指定使用identity主键生成策略
	private String title;// 专题资料介绍的标题
	private int specialState;// 专题的状态
	private String toUserName;// 微信原始ID，微信消息中的toUserName
	private String specialBody;// 媒体内容
	private String specialWriter;// 媒体作者
	private String specialMaketime;// 媒体时间
	private String textAlign;//对齐方式
	private String productIds;//对应的产品编码
	public String getProductIds() {
		return productIds;
	}
	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}
	public String getTextAlign() {
		return textAlign;
	}
	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSpecialState() {
		return specialState;
	}
	public void setSpecialState(int specialState) {
		this.specialState = specialState;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getSpecialBody() {
		return specialBody;
	}
	public void setSpecialBody(String specialBody) {
		this.specialBody = specialBody;
	}
	public String getSpecialWriter() {
		return specialWriter;
	}
	public void setSpecialWriter(String specialWriter) {
		this.specialWriter = specialWriter;
	}
	public String getSpecialMaketime() {
		return specialMaketime;
	}
	public void setSpecialMaketime(String specialMaketime) {
		this.specialMaketime = specialMaketime;
	}
}
