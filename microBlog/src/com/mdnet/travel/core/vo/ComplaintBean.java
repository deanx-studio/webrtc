package com.mdnet.travel.core.vo;

public class ComplaintBean extends BasicBean{
	private static final long serialVersionUID = 3290539L;
	private String type;
	private String content;
	private String primaryKey;
	private String order_no;
	private String complaint_state;
	
	
	
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getComplaint_state() {
		return complaint_state;
	}
	public void setComplaint_state(String complaint_state) {
		this.complaint_state = complaint_state;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public ComplaintBean(){}
	public ComplaintBean(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
