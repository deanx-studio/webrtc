package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zhinet.travel.inf.impl.OrderManageImplProxy;
import net.zhinet.travel.inf.impl.ScenicTicketImplProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.ITravelerService;
import com.mdnet.travel.core.service.IWeixinAccountService;
import com.mdnet.travel.core.service.ProxyService;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.ReturnInfoVO;

/**
 * 
 * @author ldy
 * 
 */
public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected final String REDIRECT = "redirect:";
	protected final String FORWARD = "forward:";

	@Resource(name = ITravelerService.SERVICE_NAME)
	protected ITravelerService travelerService;

	@Resource(name = IWeixinAccountService.SERVICE_NAME)
	protected IWeixinAccountService wxAccountService;

	protected int pageCount = 20;
	protected SimpleDateFormat dateDF = new SimpleDateFormat("yyyy-MM-dd");
	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource(name = "constant")
	protected Constant myConstant;

	// @Resource(name = "ProxyService")
	private ProxyService proxyService = null;

	protected ProxyService getProxy() {
		if (proxyService == null)
			proxyService = new ProxyService(myConstant);
		return proxyService;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String handlerMissingServletRequestParameterException(
			MissingServletRequestParameterException ex) {
		return "redirect:/common/error/notfound.htm";
	}

	// protected ScenicTicketImplProxy scenicTicket = new
	// ScenicTicketImplProxy();
	// protected OrderManageImplProxy orderManage = new OrderManageImplProxy();

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ModelAndView mav;
	protected String message;
	protected ReturnInfoVO info;

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public HttpServletRequest getRequest() {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}

	public String getOpenId(HttpServletRequest req, String openId) {
		if (openId == null || openId.length() == 0) {
			Object obj = req.getSession().getAttribute("openId");
			if (obj != null)
				openId = (String) obj;
		} else {
			req.getSession().setAttribute("openId", openId);
		}
		return openId;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ModelAndView getMav(HttpServletRequest request) {
		this.getMav();
		this.mav.addObject("IsMobile",CommonUtils.IsMobile(request));
		String uri = request.getRequestURI();
		int inx = uri.lastIndexOf('/');
		uri = uri.substring(inx+1);
		String keys = this.travelerService.getMetaKeys(uri);
		keys = keys.replace("，", ",");
		this.mav.addObject("metaKeys", keys);
		return this.mav;
	}
	
	public ModelAndView getMav() {
		this.mav = new ModelAndView();
		return this.mav;
	}

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

	protected void doPager(int pageNo, int itemCount) {
		int prevPage = pageNo - 1;
		int nextPage = pageNo + 1;
		// ֻ����һҳ���ڵ���1ʱ����ʾ��һҳ��ť
		if (prevPage >= 1)
			this.mav.addObject("prevPage", prevPage);
		// ��ǰ�б?�ص����С��һҳ����ݽ�������ʾ��һҳ��ť
		if (itemCount >= this.pageCount)
			this.mav.addObject("nextPage", nextPage);
		this.mav.addObject("pageNo", pageNo);
	}

	// 获取当前登录帐户的微信的相关数据
	protected WeixinAccount getWeixinAccount() {

		String uname = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		Traveler traveler = this.travelerService.findTravelerByUname(uname);
		if (traveler != null)
			return this.wxAccountService
					.getWeixinAccountByFromuserName(traveler
							.getWxFromUserName());
		else
			return null;
	}
	
	
}
