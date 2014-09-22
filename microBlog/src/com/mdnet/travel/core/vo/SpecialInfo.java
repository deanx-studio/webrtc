package com.mdnet.travel.core.vo;

public class SpecialInfo {
	private String title;
	private String subhead;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubhead() {
		return subhead;
	}
	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}
	private int is_show;//1为显示
	//private int seq;
	private int hashCode;//唯一标识
	
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	private String smart;//
	private String smart_text;//
	public int getIs_show() {
		return is_show;
	}
	public void setIs_show(int is_show) {
		this.is_show = is_show;
	}
//	public int getSeq() {
//		return seq;
//	}
//	public void setSeq(int seq) {
//		this.seq = seq;
//	}
	public String getSmart() {
		return smart;
	}
	public void setSmart(String smart) {
		this.smart = smart;
	}
	public String getSmart_text() {
		return smart_text;
	}
	public void setSmart_text(String smart_text) {
		this.smart_text = smart_text;
	}
}
