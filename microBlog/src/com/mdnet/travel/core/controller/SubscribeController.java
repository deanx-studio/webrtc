package com.mdnet.travel.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;

import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.SearchBean;

@Controller
@RequestMapping("/sub")
public class SubscribeController extends BaseController {

	@RequestMapping(value = "/bind", method = RequestMethod.GET)
	protected ModelAndView bindUI(
			@RequestParam(value = "openid", required = false) String openId) {

		this.getMav();
		if (openId != null && openId.length() > 0) {
			Traveler traveler = this.travelerService.findTravelByOpenId(openId);
			this.mav.addObject("openId", openId);
			if (traveler != null) {
				this.mav.addObject("travelerId", traveler.getTravelerId());
				this.mav.addObject("username", traveler.getUsername());
				this.mav.addObject("mobile", traveler.getMobile());
			}
		} else {
			this.mav.addObject("message", "请从微信客户端访问此网页。");
		}
		this.mav.setViewName("subscribe/bind");
		return this.mav;
	}

	@RequestMapping(value = "/checkUname", method = RequestMethod.POST)
	@ResponseBody
	protected String checkUname(
			@RequestParam(value = "username", required = true) String username) {
		String mobile = this.travelerService.findMobile(username);
		if (mobile != null)
			return "0";// 存在
		else
			return "1";// 不存在
	}

	@RequestMapping(value = "/sendValidateCode", method = RequestMethod.POST)
	@ResponseBody
	protected String sendValidateCode(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "mobile", required = true) String mobile) {

		if (null != username && null != mobile) {
			if (mobile.length() == 0
					|| mobile.substring(0, 1).compareTo("1") != 0
					|| mobile.length() != 11 || !this.isNumeric(mobile)) {
				return "-3";// 手机号码非法
			}
			String validCode = CommonUtils.getRandomSixNum();
			String validContent = "您正在使用【想走就走】的注册服务,验证码为:" + validCode
					+ ",请妥善保管!";
			// 保存到数据库
			String info = this.travelerService.saveValidCode(username, mobile,
					validCode);
			if (info.compareTo("保存成功") == 0) {
				// 发送验证短信
				try {
					getProxy().sendSMS(validContent, mobile.trim());
				} catch (RemoteException e) {
					this.logger.info("注册发码异常");
					return "-2";// 短信发送失败
				}
			}

		} else {
			return "-1";// "用户名或手机号不能为空";
		}
		return "0";
	}

	@RequestMapping(value = "/bindAction", method = RequestMethod.POST)
	protected ModelAndView bindAction(
			@RequestParam(value = "openid", required = true) String openId,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userPwd", required = true) String UserPwd,
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "smsCode", required = true) String smsCode,
			@RequestParam(value = "travelerId", required = true) String travelerId,
			HttpServletRequest request) {

		this.getMav();

		this.mav.addObject("openId", openId);
		this.mav.addObject("username", username);
		this.mav.addObject("mobile", mobile);
		this.mav.addObject("travelerId", travelerId);
		this.mav.setViewName("subscribe/bind");

		// 获取验证码，进行比对
		String smsCodeinDB = this.travelerService
				.findValidateCodeByMobileAndName(username, mobile);
		if (smsCode.length() == 0 || smsCodeinDB.compareTo(smsCode) != 0) {
			this.mav.addObject("message", "对不起，短信码输入错误，请确认。");
			return this.mav;
		}
		if (mobile.length() == 0 || mobile.substring(0, 1).compareTo("1") != 0
				|| mobile.length() != 11) {
			this.mav.addObject("message", "手机号码不合法。");
			return this.mav;
		}
		// String chkMobile = this.travelerService.findMobile(username);
		// if (chkMobile == null) {
		// 当前为默认密码
		UserPwd = "9000";
		int newId = this.travelerService.saveTraveler(username, UserPwd,
				mobile, openId, Traveler.ROLE_TRAVELER, "", travelerId);
		this.mav.addObject("travelerId", newId);
		if (newId > 0) {
			this.mav.addObject("message", "用户数据保存成功。");
			request.getSession().setAttribute("openId", openId);
		} else {
			this.mav.addObject("message", "对不起，用户数据保存失败");
		}
		// } else
		// this.mav.addObject("message", "对不起，改用户已经存在，请更换用户名。");

		return this.mav;
	}

	@RequestMapping("/enter")
	public String enter() {
		return "subscribe/enter";
	}

	@RequestMapping(value = "/scenic/tickets", method = RequestMethod.GET)
	public ModelAndView listTicketByScenicId(
			@RequestParam(value = "scenic_id", required = false) String scenicId) {
		TicketInfo[] ticketInfoList = null;
		try {
			StringBuilder scenicName = new StringBuilder();
			ticketInfoList = getProxy().getTicketsByScenicId(Integer
					.parseInt(scenicId), scenicName);
		} catch (NumberFormatException e) {
			ticketInfoList = null;
		} catch (RemoteException e) {
			ticketInfoList = null;
		}
		mav = this.getMav();
		int itemCount = 0;
		if (ticketInfoList != null)
			itemCount = ticketInfoList.length;
		this.doPager(1, itemCount);

		mav.addObject("ticketInfoList", ticketInfoList);
		mav.setViewName("ticket/list");
		return mav;
	}

	@RequestMapping("/list/action")
	public ModelAndView list(SearchBean search) {
		mav = this.getMav();
		TicketInfo[] ticketInfoList = null;
		String temp = null;
		try {
			if (null != search) {
				String city = search.getCity();
				if (city.contains("市")) {
					String[] strs = city.split("市");
					temp = strs[0].trim();
				} else {
					temp = city.trim();
				}
				if (null != temp && "" != temp) {
					try {
						ticketInfoList = getProxy().list(temp);

					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			ticketInfoList = null;
		}
		mav.addObject("ticketInfoList", ticketInfoList);
		mav.setViewName("ticket/list");
		return mav;
	}
}
