package com.mdnet.travel.core.controller;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.service.IAdminService;

@Controller
@RequestMapping("/conducter")
public class ConducterController extends BaseController{
	@Resource(name = IAdminService.SERVICE_NAME)
	private IAdminService adminService;
	
	@RequestMapping("/term")
	public ModelAndView ShowTerminate(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "head", required = false) String head) {
		if (id == null) {
			// 从登录数据中获取id
			String name = SecurityContextHolder.getContext()
					.getAuthentication().getName();
			UserInfo ui = this.adminService.getUserInfo(name);
			if (ui != null) {
				id = ui.getTerminateNumber();
				
			}
		}

		this.createMav();
		if (head == null || head.compareTo("true") == 0)
			this.mav.setViewName("conduct/term");
		else
			this.mav.setViewName("nohead/conduct/term");
		this.mav.addObject("displayName", id);
		this.mav.addObject("privateIdentity", id);
		this.mav.addObject("publicIdentity", "sip:" + id + "@deanx.cn");
		this.mav.addObject("passwd", id);
		this.mav.addObject("realm", "asterisk");
		return this.mav;
	}
}
