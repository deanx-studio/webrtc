package com.mdnet.travel.core.vo;

public class NewsBean extends BasicBean{
	private static final long serialVersionUID = 594L;

	private String keyName;
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	private int articleState;
	public int getArticleState() {
		return articleState;
	}
	public void setArticleState(int articleState) {
		this.articleState = articleState;
	}
	private int id;
	public int getId() {
		return id; 
	} 
	public void setId(int id) {
		this.id = id;
	}
	private int seq;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	private Integer news_id;
	private String title;
	private String description;
	private String pic_url;
	private String url;
	public NewsBean(){}
	public NewsBean(String title, String description, String pic_url, String url) {
		this.title = title;
		this.description = description;
		this.pic_url = pic_url;
		this.url = url;
	}
	
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
