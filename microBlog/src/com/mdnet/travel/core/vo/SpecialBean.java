package com.mdnet.travel.core.vo;

public class SpecialBean {
	private int id;// 指定使用identity主键生成策略
	private String title;// 专题资料介绍的标题
	private int specialState;// 专题的状态
	private String align;
	private String toUserName;
	//为文章列表增加的字段
	private String img;
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	private String specialBody;// 媒体内容
	private String specialWriter;// 媒体作者
	private String specialMaketime;// 媒体时间
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
