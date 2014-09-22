package com.mdnet.travel.core.vo;

import com.mdnet.travel.core.model.PersonalCustom;

public class PersonalCustomBean {

	public PersonalCustomBean(PersonalCustom personal)
	{
		this.setAdaptmentPerson(personal.getAdaptmentPerson());
		this.setAdultPerson(personal.getAdultPerson());
		this.setAdvice(personal.getAdvice());
		this.setAirClass(personal.getAirClass());
		this.setAirCompany(personal.getAirCompany().split(","));
		this.setAutoModel(personal.getAutoModel());
		this.setChildrenPerson(personal.getChildrenPerson());
		this.setCities(personal.getCities().split(","));
		this.setElseService(personal.getElseService().split(","));
		this.setEmail(personal.getEmail());
		this.setHotelGeogrophy(personal.getHotelGeogrophy());
		this.setHotelLevel(personal.getHotelLevel());
		this.setId(personal.getId());
		this.setKingNumber(personal.getKingNumber());
		this.setMakeTime(personal.getMakeTime());
		this.setMealProvider(personal.getMealProvider());
		this.setMealType(personal.getMealType());
		this.setMemo(personal.getMemo());
		this.setMobile(personal.getMobile());
		this.setNational(personal.getNational().split(","));
		this.setOldPerson(personal.getOldPerson());
		this.setSessionID(personal.getSessionID());
		this.setStandardNumber(personal.getStandardNumber());
		this.setStartDate(personal.getStartDate());
		this.setState(personal.getState());
		this.setTripDays(personal.getTripDays());
		this.setTripMode(personal.getTripMode());
		this.setUserName(personal.getUserName());
	
	}
	//基础数据
	private int id;
	private String sessionID;
	private String makeTime;
	
	//身份信息
	private String mobile;
	private String userName;
	private String email;
	
	//目的地数据
	private String[] national;
	private String[] cities;
	
	//反馈数据
	private int state;//0:正在写入资料；1：资料写入完毕，短信通知已经发送；2：已经联系客户了
	private String advice;
	
	
	//出行天数
	private String startDate;
	private int tripDays;
	
	//人员组成
	private int adultPerson;
	private int childrenPerson;
	private int oldPerson;
	//酒店情况
	private int standardNumber;
	private int adaptmentPerson;
	private int kingNumber;
	private String hotelGeogrophy;
	private int hotelLevel;
	
	//航空要求
	private String[] airCompany;
	private int airClass;
	
	//车辆选择
	private int tripMode;
	private String autoModel;
	
	//用餐
	private int mealType;
	private int mealProvider;
	
	//其他服务
	private String[] elseService;
	//备注要求
	private String memo;
	
	public int getMealType() {
		return mealType;
	}
	public void setMealType(int mealType) {
		this.mealType = mealType;
	}
	public int getMealProvider() {
		return mealProvider;
	}
	public void setMealProvider(int mealProvider) {
		this.mealProvider = mealProvider;
	}
	public String[] getElseService() {
		return elseService;
	}
	public void setElseService(String[] elseService) {
		this.elseService = elseService;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String[] getAirCompany() {
		return airCompany;
	}
	public void setAirCompany(String[] airCompany) {
		this.airCompany = airCompany;
	}
	public int getAirClass() {
		return airClass;
	}
	public void setAirClass(int airClass) {
		this.airClass = airClass;
	}
	public int getTripMode() {
		return tripMode;
	}
	public void setTripMode(int tripMode) {
		this.tripMode = tripMode;
	}
	public String getAutoModel() {
		return autoModel;
	}
	public void setAutoModel(String autoModel) {
		this.autoModel = autoModel;
	}
	public int getAdultPerson() {
		return adultPerson;
	}
	public void setAdultPerson(int adultPerson) {
		this.adultPerson = adultPerson;
	}
	public int getChildrenPerson() {
		return childrenPerson;
	}
	public void setChildrenPerson(int childrenPerson) {
		this.childrenPerson = childrenPerson;
	}
	public int getOldPerson() {
		return oldPerson;
	}
	public void setOldPerson(int oldPerson) {
		this.oldPerson = oldPerson;
	}
	public int getStandardNumber() {
		return standardNumber;
	}
	public void setStandardNumber(int standardNumber) {
		this.standardNumber = standardNumber;
	}
	public int getAdaptmentPerson() {
		return adaptmentPerson;
	}
	public void setAdaptmentPerson(int adaptmentPerson) {
		this.adaptmentPerson = adaptmentPerson;
	}
	public int getKingNumber() {
		return kingNumber;
	}
	public void setKingNumber(int kingNumber) {
		this.kingNumber = kingNumber;
	}
	public String getHotelGeogrophy() {
		return hotelGeogrophy;
	}
	public void setHotelGeogrophy(String hotelGeogrophy) {
		this.hotelGeogrophy = hotelGeogrophy;
	}
	public int getHotelLevel() {
		return hotelLevel;
	}
	public void setHotelLevel(int hotelLevel) {
		this.hotelLevel = hotelLevel;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getTripDays() {
		return tripDays;
	}
	public void setTripDays(int number) {
		this.tripDays = number;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getNational() {
		return national;
	}
	public void setNational(String[] national) {
		this.national = national;
	}
	public String[] getCities() {
		return cities;
	}
	public void setCities(String[] cities) {
		this.cities = cities;
	}
	
}
