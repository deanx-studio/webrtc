package com.mdnet.travel.core.vo;

import java.util.Date;

public class ScenicInfoBean extends BasicBean{
	private static final long serialVersionUID = 434L;
	private Integer scenicId; //景区ID
	private String cityName; //所在城市编码
	private String scenicName; //景区名称
	private String scenicImg; //景区主题图片URL地址
	private String scenicImages; //景区图片册URL地址
	private String scenicAddr; //景区地址
	private String scenicTraffic; //景区交通(简短)
	private String scenicIntro; //景区简介
	private String scenicTrafficDetail; //景区交通指南(详细)
	private double scenicLongitude; //景区位置的经度数据
	private double scenicLatitude; //景区位置的纬度数据
	private int scenicSeaLevel; //景区所在海拔高度
	private short scenicType; //景区类型 
	private short status; //是否开发状态
	private int userId; //用户在wordpress中的ID
	private Date makeTime;
	private TicketInfoBean[] scenicTickets = null; //景区电子票务信息
	public ScenicInfoBean() {
	}
	public ScenicInfoBean(Integer scenicId, String cityName, String scenicName,
			String scenicImg, String scenicImages, String scenicAddr,
			String scenicTraffic, String scenicIntro,
			String scenicTrafficDetail, short scenicType, short status,
			Date makeTime) {
		super();
		this.scenicId = scenicId;
		this.cityName = cityName;
		this.scenicName = scenicName;
		this.scenicImg = scenicImg;
		this.scenicImages = scenicImages;
		this.scenicAddr = scenicAddr;
		this.scenicTraffic = scenicTraffic;
		this.scenicIntro = scenicIntro;
		this.scenicTrafficDetail = scenicTrafficDetail;
		this.scenicType = scenicType;
		this.status = status;
		this.makeTime = makeTime;
	}
	public Integer getScenicId() {
		return scenicId;
	}
	public void setScenicId(Integer scenicId) {
		this.scenicId = scenicId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getScenicName() {
		return scenicName;
	}
	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}
	public String getScenicImg() {
		return scenicImg;
	}
	public void setScenicImg(String scenicImg) {
		this.scenicImg = scenicImg;
	}
	public String getScenicImages() {
		return scenicImages;
	}
	public void setScenicImages(String scenicImages) {
		this.scenicImages = scenicImages;
	}
	public String getScenicAddr() {
		return scenicAddr;
	}
	public void setScenicAddr(String scenicAddr) {
		this.scenicAddr = scenicAddr;
	}
	public String getScenicTraffic() {
		return scenicTraffic;
	}
	public void setScenicTraffic(String scenicTraffic) {
		this.scenicTraffic = scenicTraffic;
	}
	public String getScenicIntro() {
		return scenicIntro;
	}
	public void setScenicIntro(String scenicIntro) {
		this.scenicIntro = scenicIntro;
	}
	public String getScenicTrafficDetail() {
		return scenicTrafficDetail;
	}
	public void setScenicTrafficDetail(String scenicTrafficDetail) {
		this.scenicTrafficDetail = scenicTrafficDetail;
	}
	public double getScenicLongitude() {
		return scenicLongitude;
	}
	public void setScenicLongitude(double scenicLongitude) {
		this.scenicLongitude = scenicLongitude;
	}
	public double getScenicLatitude() {
		return scenicLatitude;
	}
	public void setScenicLatitude(double scenicLatitude) {
		this.scenicLatitude = scenicLatitude;
	}
	public int getScenicSeaLevel() {
		return scenicSeaLevel;
	}
	public void setScenicSeaLevel(int scenicSeaLevel) {
		this.scenicSeaLevel = scenicSeaLevel;
	}
	public short getScenicType() {
		return scenicType;
	}
	public void setScenicType(short scenicType) {
		this.scenicType = scenicType;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}
	public TicketInfoBean[] getScenicTickets() {
		return scenicTickets;
	}
	public void setScenicTickets(TicketInfoBean[] scenicTickets) {
		this.scenicTickets = scenicTickets;
	}
	
	
}
