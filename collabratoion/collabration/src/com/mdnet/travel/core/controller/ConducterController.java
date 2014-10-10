package com.mdnet.travel.core.controller;

import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.TerminateInfo;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.service.IAdminService;
import com.mdnet.travel.core.service.ICallService;

@Controller
@RequestMapping("/conducter")
public class ConducterController extends BaseController{
	@Resource(name = IAdminService.SERVICE_NAME)
	private IAdminService adminService;
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService callService;

	@RequestMapping("/videoTerm")
	public ModelAndView ShowTerminate(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "head", required = false) String head) {

		this.createMav(id);
		if (head == null || head.compareTo("true") == 0)
			this.mav.setViewName("conduct/videoTerm");
		else
			this.mav.setViewName("nohead/conduct/videoTerm");
		return this.mav;
	}
	@RequestMapping("/audioTerm")
	public ModelAndView ShowAudioTerminate(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "head", required = false) String head,
			@RequestParam(value = "page", required = false) String page) {

		this.createMav(id);
		if (head == null || head.compareTo("true") == 0)
			this.mav.setViewName("conduct/audioTerm");
		else
			this.mav.setViewName("nohead/conduct/audioTerm");
		int  pageNo = 0;
		if(page != null) pageNo = Integer.parseInt(page);
		List<TerminateInfo> terms = this.callService.listTerm(">=-2", null, null, pageNo, 50);
		this.mav.addObject("termList", terms);
		return this.mav;
	}
}
