package com.mdnet.travel.core.model;

public class Media extends BaseModel {
	private int id;// 指定使用identity主键生成策略
	private String title;// 专题资料介绍的标题
	private int mediaState;// 0:禁用；1启用
	private String toUserName;// 微信原始ID，微信消息中的toUserName
	private String media_url;// 媒体地址
	private String mediaType;// 媒体类型,文件后缀
	private String maketime;// 媒体创建时间
	private String mediaMD5;// 实体文件MD5验证码
	private String physicalPath;// 保存路径
	private int mediaSize;//媒体大小
	private String originalFileName;
	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public int getMediaSize() {
		return mediaSize;
	}

	public void setMediaSize(int mediaSize) {
		this.mediaSize = mediaSize;
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

	public int getMediaState() {
		return mediaState;
	}

	public void setMediaState(int mediaState) {
		this.mediaState = mediaState;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getMedia_url() {
		return media_url;
	}

	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public String getMaketime() {
		return maketime;
	}

	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}

	public String getMediaMD5() {
		return mediaMD5;
	}

	public void setMediaMD5(String mediaMD5) {
		this.mediaMD5 = mediaMD5;
	}

	public String getPhysicalPath() {
		return physicalPath;
	}

	public void setPhysicalPath(String physicalPath) {
		this.physicalPath = physicalPath;
	}
}
