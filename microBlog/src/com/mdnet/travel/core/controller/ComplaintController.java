package com.mdnet.travel.core.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.zhinet.travel.pojo.basepojo.Complaint;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mdnet.travel.core.vo.ComplaintBean;

@Controller
@RequestMapping("/complaint")
public class ComplaintController extends BaseController{
	@RequestMapping("/my/do")
	public String doComplaint(){
		return "do/complaint";
	}
	@RequestMapping("/my/save")
	public ModelAndView saveComplaint(ComplaintBean complaint,
			Authentication authentication){
		String errorMsg = null;
		String viewName = null;
		String username = authentication.getName();
		Integer primaryKey = this.travelerService.findPrimaryKey(username);
		complaint.setPrimaryKey(primaryKey+"");
		mav = new ModelAndView();
		if(null == complaint.getContent()){
			errorMsg = "投诉内容不能为空!!";
			viewName = this.FORWARD+"/complaint/my/do";
		}else{
			try {
				getProxy().saveComplaint(complaint);
				viewName = this.REDIRECT+"/complaint/my/list";
			} catch (RemoteException e) {
				errorMsg = "系统繁忙，请稍后重试！";
				viewName = this.FORWARD+"/complaint/my/do";
			}
		}
		this.mav.addObject("errorMsg", errorMsg);
		this.mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping("/my/list")
	public ModelAndView listComplaint(Authentication authentication){
		this.mav = new ModelAndView();
		
		String username = authentication.getName();
		List<Complaint> complaintList = new ArrayList<Complaint>();
		//找到主键,并根据主键找到该用户下的投诉列表
		if(StringUtils.isNotBlank(username)){
			Integer primaryKey = this.travelerService.findPrimaryKey(username);
			try {
				complaintList = getProxy().listComplaint(primaryKey);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.mav.setViewName("list/complaint");
		this.mav.addObject("complaint_list", complaintList);
		return this.mav;
	}
}
