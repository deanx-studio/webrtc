package com.mdnet.travel.core.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zhinet.travel.pojo.basepojo.ScenicInfo;
import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.dao.ReqMessageDAO;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.ExceptionInfo;
import com.mdnet.travel.core.vo.RegistBean;
import com.mdnet.travel.core.vo.SignupCheck;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		if (CommonUtils.IsMobile(request))
			return this.REDIRECT + this.myConstant.getMobileHomePage();///mobilehome";
		else
			return this.REDIRECT + this.myConstant.getPCHomePage();//"/custom/book";
	}

	@RequestMapping(value = { "mobilehome" }, method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		String cityName = "";
		String commentDate = "";

		String provinceName = "";
		List<ScenicInfo> viewList = new ArrayList<ScenicInfo>();
		try {
			viewList = getProxy().getRecommendViews(cityName, commentDate,
					provinceName);
			// viewList.get(0).set
		} catch (RemoteException e) {
			viewList = null;
		}

		for (ScenicInfo view : viewList) {
			int minMoney = getMinValue(view.getScenicTickets());
			view.setScenicSeaLevel(minMoney);
		}

		this.mav = new ModelAndView();
		this.mav.setViewName("home");

		this.mav.addObject("view_list", viewList);
		return mav;
	}

	private int getMinValue(TicketInfo[] ticketInfos) {
		int minMoney = 0;

		if (ticketInfos != null && ticketInfos.length > 0) {

			minMoney = ticketInfos[0].getSalePrice();

			for (int i = 1; i < ticketInfos.length; i++) {
				// System.out.println(ticketInfos[i].getSalePrice());
				if (ticketInfos[i].getSalePrice() < minMoney) {

					int temp = 0;
					temp = minMoney;
					minMoney = ticketInfos[i].getSalePrice();
					ticketInfos[i].setSalePrice(temp);
				}
			}

			// System.out.println(minMoney+"-----------");

		}

		return minMoney;
	}

	@RequestMapping("/signup")
	public String signupUI() {
		return "signup";
	}

	@RequestMapping("/forget")
	public String forget() {
		return "forget";
	}

	@RequestMapping("/dosignup")
	public ModelAndView signup(RegistBean regist) {
		String username = regist.getUsername();
		String pass = regist.getPass();
		String confirm_pass = regist.getConfirm_pass();
		String mobile = regist.getMobile();
		String validCode = regist.getValid_code();

		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(pass)
				&& StringUtils.isNotEmpty(confirm_pass)
				&& StringUtils.isNotEmpty(mobile)
				&& StringUtils.isNotEmpty(validCode)) {
			if (this.travelerService.findValidCodeByMobile(mobile.trim())
					.equals(validCode.trim())) {
				if (null != this.travelerService.findMobile(username.trim())) {
					this.message = "用户名已被占用!";
				} else {
					if (pass.trim().equals(confirm_pass.trim())) {
						Boolean flag = (this.travelerService.saveTraveler(
								username, pass, mobile, "",
								Traveler.ROLE_TRAVELER, "", null) > 0 ? true
								: false);
						if (flag) {
							this.message = "注册成功,赶快登入瞧瞧!";
						} else {
							this.message = "系统繁忙,请稍后重试哦!";
						}
					} else {
						this.message = "注册失败,两次输入密码不一致！";
					}
				}
			} else {
				this.message = "注册失败,输入验证码不符";
			}

		} else {
			this.message = "注册失败,*号的为必填项，请确认...";
		}
		this.mav = new ModelAndView();
		this.mav.setViewName(this.FORWARD + "/signup");
		this.mav.addObject("message", this.message);
		return mav;
	}

	@RequestMapping(value = "/check/username", method = RequestMethod.POST)
	public void check_username(SignupCheck signup, HttpServletResponse response) {
		PrintWriter out = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			out = response.getWriter();
		} catch (IOException e) {
			this.logger.info("获取输出流错误!");
		}
		String username = signup.getUsername();
		if (StringUtils.isNotEmpty(username)) {
			if (null != this.travelerService.findMobile(username.trim())) {
				out.print("用户名已被占用!");
			} else {
				out.print("可以使用");
			}
		} else {
			out.print("请输入用户名!");
		}
	}

	@RequestMapping(value = "/signup/get_valid_code", method = RequestMethod.POST)
	public void sendValidCode(RegistBean regist, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		String username = regist.getUsername();
		String mobile = regist.getMobile();
		String info = "";
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			this.logger.info("获取响应流失败");
		}
		if (null != username && null != mobile) {
			// TODO 待完成：检测手机号是否符合要求
			String validCode = CommonUtils.getRandomSixNum();
			String validContent = "尊敬的用户,您好。您正在使用我们的注册服务,验证码为:" + validCode
					+ ",请妥善保管!";
			try {
				getProxy().sendSMS(validContent, mobile.trim());
			} catch (RemoteException e) {
				this.logger.info("注册发码异常");
			}
			info = this.travelerService.saveValidCode(username, mobile,
					validCode);
		} else {
			info = "用户名或手机号不能为空";
		}
		out.print(info);
	}

	/**
	 * 404
	 */
	@RequestMapping("/exception/notfound")
	public ModelAndView notfound() {
		this.mav = new ModelAndView();
		this.mav.setViewName("404_or_500");
		this.mav.addObject("exception", new ExceptionInfo("当前页已迁移！",
				"/image/client/404.jpg"));
		return this.mav;
	}

	/**
	 * 500
	 */
	@RequestMapping("/exception/busy")
	public ModelAndView busy() {
		this.mav = new ModelAndView();
		this.mav.setViewName("404_or_500");
		this.mav.addObject("exception", new ExceptionInfo("系统繁忙，请稍后重试！",
				"/image/client/500.jpg"));
		return this.mav;
	}
}
