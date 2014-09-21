package com.mdnet.travel.core.controller;

import java.util.Set;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.vo.ExceptionInfo;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView showHomePage() {
		this.createMav();
		this.mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		this.createMav();
		this.mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = { "/loginRoot" }, method = RequestMethod.GET)
	public String loginRootPage() {
		Set<String> roles = AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext()
						.getAuthentication().getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			return this.REDIRECT + "/admin/home";
		} else if (roles.contains("ROLE_CONDUCTER")) {
			return this.REDIRECT + "conducter/home";
		} else if (roles.contains("ROLE_USER")) {
			return this.REDIRECT + "/user/home";
		} else
			return this.REDIRECT + "/";
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
