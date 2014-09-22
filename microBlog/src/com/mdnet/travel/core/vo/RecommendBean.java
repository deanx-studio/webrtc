package com.mdnet.travel.core.vo;


public class RecommendBean extends BasicBean {
	private static final long serialVersionUID = 87001L;
	private String Title;//大标题，如：票的名称等。
	private String Description;//文本内容
	private String PicUrl;//图片的url地址
	private String Url;//图文消息链接地址
	
	public RecommendBean() {
	}

	public RecommendBean(String title, String description, String picUrl,
			String url) {
		Title = title;
		Description = description;
		PicUrl = picUrl;
		Url = url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
	
}
