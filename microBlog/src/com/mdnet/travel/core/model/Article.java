package com.mdnet.travel.core.model;

public class Article extends BaseModel {
	private static final long serialVersionUID =98915L;
	public static final Integer AVAILABLE = 1;//1:可用，其他值为不可用
	public static final Integer UNAVAILABLE = 0;
	private int id;
	private int articleId;
	private int seq; 
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	//微信原始ID，微信消息中的toUserName
	private String toUserName;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	//private Integer aticleId;
	private String title;//大标题，如：票的名称等。
	private String description;//文本内容
	private String picUrl;//图片的url地址
	private String url;//图文消息链接地址
	private int aticleState;//主要是根据核心中推荐的票是否过期而确定是否可用
	public Article() {
	}
	public Article(String title, String description, String picUrl, String url) {
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
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
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getAticleState() {
		return aticleState;
	}
	public void setAticleState(int aticleState) {
		this.aticleState = aticleState;
	}
	
}
