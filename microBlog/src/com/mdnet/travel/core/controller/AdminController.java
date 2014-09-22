package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.service.impl.MessageServiceImpl;
import com.mdnet.travel.core.utils.FileOperationUtil;
import com.mdnet.travel.core.vo.KeysBean;
import com.mdnet.travel.core.vo.NewsBean;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String adminPage() {

		Set<String> roles = AuthorityUtils
				.authorityListToSet(SecurityContextHolder.getContext()
						.getAuthentication().getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {

			return this.REDIRECT + "/special/list";
		} else if (roles.contains("ROLE_SUPER")) {
			return this.REDIRECT + "/super/home";
		}
		else if (roles.contains("ROLE_DRIVE")) {
			return this.REDIRECT + "/drive/home";
		}
		else if (roles.contains("ROLE_LEAD")) {
			return this.REDIRECT + "/leader/home";
		}
		return this.REDIRECT + "/";
	}

	// "/admin/article/recommend/action"
	@RequestMapping("/article/recommend/action")
	public String recommendUI(HttpServletRequest request) {
		FileOperationUtil fou = new FileOperationUtil();
		fou.changeValue(request);
		return this.REDIRECT + "/admin/article/list.do";
	}

	@RequestMapping("/article/recommend")
	@ResponseBody
	public String recommend() {
		return "article/recommend";
	}

	@RequestMapping("/article/state")
	@ResponseBody
	public String update_state(@RequestParam("newsId") int newsId,
			@RequestParam("state") String state) {
		String ret = "-1";
		try {
			state = state.toLowerCase();
			ret = String.valueOf(this.messageService.updateArticleState(newsId,
					state.equals("true") ? 1 : 0));
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return ret;
	}

	@RequestMapping("/article/add")
	public ModelAndView addUI() {
		// return "article/add";
		this.mav = new ModelAndView();
		// 菜单事件
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> keys = this.messageService.findAllKeys(null,
				acc.getWxFromUserName());

		this.mav.addObject("keys", keys);

		this.mav.setViewName("article/add");

		return mav;

	}

	@RequestMapping("/article/add/action")
	public String addNews(NewsBean news) {
		WeixinAccount acc = this.getWeixinAccount();
		int news_id = this.messageService
				.addNews(news, acc.getWxFromUserName());
		return this.REDIRECT + "/admin/article/updateUI.do?news_id=" + news_id;
	}

	/**
	 * pageNo从1开始
	 */

	@RequestMapping("/article/list")
	public ModelAndView listUI(
			@RequestParam(value = "page", required = false) String pageNoStr,
			HttpServletRequest request) {

		String search = "";
		try {
			String s = request.getParameter("s");
			if (s != null && s.length() > 0) {
				search = new String(s.getBytes("iso-8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int pageNo = (pageNoStr == null ? 1 : Integer.parseInt(pageNoStr));
		// 转到从0开始
		pageNo--;
		if (pageNo < 0)
			pageNo = 0;
		this.mav = new ModelAndView();
		WeixinAccount acc = this.getWeixinAccount();
		List<NewsBean> newsList = this.messageService.findAllNews(pageNo,
				search, acc.getWxFromUserName());
		this.mav.addObject("news_list", newsList);

		// 转到从1开始
		pageNo++;
		int prevPage = pageNo - 1 < 1 ? 1 : pageNo - 1;
		int nextPage = pageNo;
		if (newsList != null && newsList.size() > 0)
			nextPage = pageNo + 1;
		this.mav.addObject("pageNo", pageNo);
		this.mav.addObject("prevPage", prevPage);
		this.mav.addObject("nextPage", nextPage);
		this.mav.addObject("search", search);
		this.mav.setViewName("article/list");

		return mav;
	}

	@RequestMapping("/article/update2")
	public String update2UI(
			@RequestParam(value = "aid", required = true) int aid) {
		NewsBean nb = this.messageService.findNewsByArticleId(aid, this
				.getWeixinAccount().getWxFromUserName());
		return this.REDIRECT + "/admin/article/updateUI?news_id=" + nb.getId();
	}

	// "/admin/article/updateUI"
	@RequestMapping("/article/updateUI")
	public ModelAndView updateUI(
			@RequestParam(value = "news_id", required = true) Integer news_id) {
		this.mav = new ModelAndView();
		NewsBean news = null;
		if (null != news_id) {
			news = this.messageService.findNewsById(news_id);
		}
		// 菜单事件
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> keys = this.messageService.findAllKeys(null,
				acc.getWxFromUserName());
		this.mav.addObject("keys", keys);
		mav.setViewName("article/update");
		mav.addObject("news", news);
		return mav;
	}

	@RequestMapping("/article/update/action")
	public ModelAndView updateNews(NewsBean news0) {
		this.mav = new ModelAndView();
		if (null != news0) {
			this.messageService.updateNews(news0);
			this.mav.addObject("message", "更新数据成功。");
		}
		Integer news_id = news0.getId();
		NewsBean news = null;
		if (null != news_id) {
			news = this.messageService.findNewsById(news_id);
		}
		// 菜单事件
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> keys = this.messageService.findAllKeys(null,
				acc.getWxFromUserName());
		this.mav.addObject("keys", keys);
		mav.setViewName("article/update");
		mav.addObject("news", news);
		return mav;
	}

	@RequestMapping(value = "/article/delete", method = RequestMethod.GET)
	@ResponseBody
	public String deleteNews(
			@RequestParam(value = "newsid", required = true) int news_id) {
		int ret = this.messageService.deleteNews(news_id);
		// String ret_str = "";
		return String.valueOf(ret);
		// ret_str = String.valueOf(ret);
		// return ret_str;
	}

}
