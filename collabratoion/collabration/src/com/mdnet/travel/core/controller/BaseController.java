package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.service.IAdminService;

/**
 * 
 * @author ldy
 * 
 */
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected final String REDIRECT = "redirect:";
	protected final String FORWARD = "forward:";

	@Resource(name = IAdminService.SERVICE_NAME)
	protected IAdminService adminService;

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handlerMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {
		return "redirect:/common/error/notfound.htm";
	}

	protected ModelAndView mav;
	protected String message;

	public ModelAndView createMav(String id) {
		if (id == null || id.length()==0) {
			// 从登录数据中获取id
			String name = SecurityContextHolder.getContext()
					.getAuthentication().getName();
			UserInfo ui = this.adminService.getUserInfo(name);
			if (ui != null) {
				id = ui.getTerminateNumber();

			}
		}
		this.mav = new ModelAndView();
		this.mav.addObject("termId", id);
		return this.mav;
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	// public ModelAndView getMav() {
	// this.mav = new ModelAndView();
	// return this.mav;
	// }

	protected void doPager(int pageNo, int itemCount, int pageCount) {
		int prevPage = pageNo - 1;
		int nextPage = pageNo + 1;
		// ֻ����һҳ���ڵ���1ʱ����ʾ��һҳ��ť
		if (prevPage >= 1)
			this.mav.addObject("prevPage", prevPage);
		// ��ǰ�б?�ص����С��һҳ����ݽ�������ʾ��һҳ��ť
		if (itemCount >= pageCount)
			this.mav.addObject("nextPage", nextPage);
		this.mav.addObject("pageNo", pageNo);
	}
}
