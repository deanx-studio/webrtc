package com.mdnet.travel.core.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.vo.MenusBean;

@Controller
@RequestMapping("/wxm")
public class MenuClickController extends BaseController {
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;

	@RequestMapping(value = "/click", method = RequestMethod.GET)
	public String clickMenu(HttpServletRequest request,
			HttpServletResponse response) {
		String qString = request.getQueryString();
		String mid = request.getParameter("mid");
		if (mid == null)
			return "";
		MenusBean menu = null;
		try {
			// 获取菜单对应的url地址
			menu = messageService.findMenuById(Integer.parseInt(mid));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (menu != null) {
			String redirectUrl = menu.getMenuUrl();
			String[] web_root = new String[3];
			web_root[0] = this.myConstant.getWeixin_web();
			web_root[1] = "http://localhost:8080";
			// 临时数据
			web_root[2] = "http://112.125.121.163:8080/travel-weixin/";
			redirectUrl = cutUrl(qString, redirectUrl, web_root);
			// try {
			// response.sendRedirect(redirectUrl);
			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			return this.REDIRECT + redirectUrl;
		} else
			return this.REDIRECT;
	}

	public String cutUrl(String qString, String redirectUrl, String[] web_root) {
		// for (int i = 0; i < web_root.length; i++) {
		// int inx = redirectUrl.indexOf(web_root[i]);
		// if (inx >= 0) {
		// redirectUrl = redirectUrl.substring(web_root[i].length());
		// break;
		// }
		// }
		if (redirectUrl.indexOf(this.myConstant.getWeixin_web()) >= 0) {
			if (redirectUrl.indexOf('?') >= 0)
				return redirectUrl + "&" + qString;
			else
				return redirectUrl + "?" + qString;
		} else//外部链接不需要额外拼参数
			return redirectUrl;
	}
}
