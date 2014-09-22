package com.mdnet.travel.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.FindPassVO;
import com.mdnet.travel.core.vo.MemberInfoVO;
import com.mdnet.travel.core.vo.RegistBean;
import com.mdnet.travel.core.vo.ResetMobileVO;
import com.mdnet.travel.core.vo.ResetPassVO;
import com.mdnet.travel.core.vo.ReturnInfoVO;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {
	@RequestMapping("/my/basic")
	public ModelAndView basicInfo() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		String mobile = this.travelerService.findMobile(username);
		RegistBean traveler = new RegistBean(username, null, null, mobile,null);
		this.mav = new ModelAndView();
		this.mav.setViewName("my/basic");
		this.mav.addObject("traveler", traveler);
		return mav;
	}

	@RequestMapping("/my/reset_info")
	public ModelAndView resetInfo() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		String mobile = this.travelerService.findMobile(username);
		RegistBean traveler = new RegistBean(username, null, null, mobile,null);
		this.mav = new ModelAndView();
		this.mav.addObject("traveler", traveler);
		this.mav.setViewName("my/reset_info");
		
		return this.mav;
	}

	@RequestMapping("/my/do_reset_info")
	public ModelAndView doResetInfo(ResetMobileVO mobiles) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		
		//查询验证码并判断验证码是否正确
		String validCode = this.travelerService.findValidateCodeByMobileAndName(username,mobiles.getMobile());
		
		this.mav = new ModelAndView();
		
		if(validCode.equals(mobiles.getValid_code())){
			
			String info = this.travelerService.resetMobileByUser(mobiles, username);
			this.mav.addObject("reset", new ReturnInfoVO(info));
		}else{
			
			this.mav.addObject("reset", new ReturnInfoVO("验证码不正确 "));
		}
		
		
		
		this.mav.setViewName(this.FORWARD + "/account/my/reset_info");
		
		return mav;
	}

	/**
	 * 发送验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/get_valid_code")
	public void getValidCode(
			@RequestParam(value = "valid_mobile", required = false) String validMobile,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = authentication.getName();
		String mobile = "";
		String info = "";
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			info = "系统繁忙,稍后重试!";
		}
		// 未登录
		if (name.trim().equals("anonymousUser")) {
			// 找到用户，如果没有记录，提示不是会员，需注册
			if (StringUtils.isNotBlank(validMobile)) {
				mobile = validMobile.trim();
				MemberInfoVO memberInfo = this.travelerService
						.findUserByMobile(mobile);
				if (null != memberInfo) {
					name = memberInfo.getUsername();
				} else {
					info = "该号码未绑定,请确认!";
				}
			} else {
				info = "请输入已绑定手机号";
			}
		} else {
			// 已登录 
			mobile = this.travelerService.findMobile(name.trim());
		}
		// 保存验证码应以手机号做唯一标识
		// 发码和入库
		if (!name.equals("anonymousUser")) {
			String validCode = CommonUtils.getRandomSixNum();
			String validMessage = "尊敬的智旅会员:" + name + ",您好!您在智旅网验证的验证码为:"
					+ validCode + ",请妥善保管,谢谢使用!!";
			Boolean flag = false;
			try {
				flag = getProxy().sendSMS(validMessage, mobile);
			} catch (RemoteException e) {
				this.logger.info(e.getMessage());
				info = "系统繁忙,稍后重试!";
			}
			if(flag){
				info = this.travelerService.saveValidCode(name, mobile,
						validCode);
			}else{
				info = "系统繁忙,稍后重试!";
			}
			
		} else {
			info = "请确认手机号是否已绑定";
		}
		out.print(info);
	}
	
	
	
	/**
	 * 换个手机号码并发送验证码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/resetMobile")
	public void resetMobileAndSendValidCode(
			@RequestParam(value = "valid_mobile", required = false) String validMobile,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = authentication.getName();
		String mobile = "";
		String info = "";
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			info = "系统繁忙,稍后重试!";
		}
		// 未登录
		if (name.trim().equals("anonymousUser")) {
			// 找到用户，如果没有记录，提示不是会员，需注册
			if (StringUtils.isNotBlank(validMobile)) {
				mobile = validMobile.trim();
				MemberInfoVO memberInfo = this.travelerService
						.findUserByMobile(mobile);
				if (null != memberInfo) {
					name = memberInfo.getUsername();
				} else {
					info = "该号码未绑定,请确认!";
				}
			} else {
				info = "请输入已绑定手机号";
			}
		}
		// 保存验证码应以手机号做唯一标识
		// 发码和入库
		if (!name.equals("anonymousUser")) {
			//判断此手机号是否已经绑定
			MemberInfoVO memberInfoVO = this.travelerService.findUserByMobile(validMobile.trim());
			
			if(memberInfoVO != null){
				
				info = "此手机号已经绑定另外一个账号，您暂时不能绑定";
				out.print(info);
				return;
				
			}
			
			String validCode = CommonUtils.getRandomSixNum();
			String validMessage = "尊敬的智旅会员:" + name + ",您好!您在智旅网验证的验证码为:"
					+ validCode + ",请妥善保管,谢谢使用!!";
			Boolean flag = false;
			try {
				flag = getProxy().sendSMS(validMessage, validMobile);
			} catch (RemoteException e) {
				this.logger.info(e.getMessage());
				info = "系统繁忙,稍后重试!";
			}
			if(flag){
				info = this.travelerService.saveValidCode(name, validMobile.trim(),
						validCode);
			}else{
				info = "系统繁忙,稍后重试!";
			}
			
		} else {
			info = "请确认手机号是否已绑定";
		}
		out.print(info);
	}
	
	
	

	@RequestMapping("/my/reset_pass")
	public String resetPass() {
		return "my/reset_pass";
	}

	@RequestMapping("/my/do_reset_pass")
	public ModelAndView doResetPass(ResetPassVO passInfo) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String message = this.travelerService.resetPassByUser(passInfo,
				userDetails.getUsername());
		ReturnInfoVO info = new ReturnInfoVO();
		info.setInfo(message);
		this.mav = new ModelAndView();
		this.mav.setViewName(this.FORWARD + "/account/my/reset_pass");
		this.mav.addObject("info", info);
		return mav;
	}

	/**
	 * 找回用户名或密码
	 */
	@RequestMapping(value = "/find_name_or_pass", method = RequestMethod.POST)
	public ModelAndView findPass(FindPassVO findInfo) {
		String message = this.travelerService.findPassOrUser(findInfo);
		this.info = new ReturnInfoVO();
		info.setInfo(message);
		this.mav = new ModelAndView();
		this.mav.setViewName(this.FORWARD + "/forget");
		this.mav.addObject("Message", info);
		return mav;
	}
}
