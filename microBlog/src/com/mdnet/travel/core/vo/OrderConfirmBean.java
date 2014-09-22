package com.mdnet.travel.core.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class OrderConfirmBean extends BasicBean{
	private static final long serialVersionUID = 2341L;
	private String number;
	private String user;
	private String mobile;
	private String confirmMobile;
	private String scenicId;
	private String ticketId;
	private String sub;
	private String startDate;
	private String endDate;
	private String ticketName;
	private String preOrderDays;
	
	public OrderConfirmBean(String number, String user, String mobile,
			String confirmMobile, String scenicId, String ticketId, String sub) {
		this.number = number;
		this.user = user;
		this.mobile = mobile;
		this.confirmMobile = confirmMobile;
		this.scenicId = scenicId;
		this.ticketId = ticketId;
		this.sub = sub;
	}
	
	public String getPreOrderDays() {
		return preOrderDays;
	}


	public void setPreOrderDays(String preOrderDays) {
		this.preOrderDays = preOrderDays;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public OrderConfirmBean() {
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getConfirmMobile() {
		return confirmMobile;
	}
	public void setConfirmMobile(String confirmMobile) {
		this.confirmMobile = confirmMobile;
	}
	public String getScenicId() {
		return scenicId;
	}
	public void setScenicId(String scenicId) {
		this.scenicId = scenicId;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
}
