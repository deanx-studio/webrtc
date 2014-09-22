package com.mdnet.travel.core.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.KeyDefine;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.vo.KeysBean;
import com.mdnet.travel.core.vo.MenusBean;
import com.mdnet.travel.core.vo.NewsBean;
import com.mdnet.travel.core.weixin.pojo.AccessToken;
import com.mdnet.travel.core.weixin.pojo.Button;
import com.mdnet.travel.core.weixin.pojo.CommonButton;
import com.mdnet.travel.core.weixin.pojo.ComplexButton;
import com.mdnet.travel.core.weixin.pojo.Menu;
import com.mdnet.travel.core.weixin.pojo.ViewButton;
import com.mdnet.travel.core.weixin.utils.WeixinUtils;

@Controller
@RequestMapping("/menu")
public class MenuDefineHandler extends BaseController {
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;

	/**
	 * 列出当前配置的菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUI(HttpServletRequest request) {

		this.mav = new ModelAndView();
		List<MenusBean> menusList = this.messageService.findMenus(
				" order by parentId asc", this.getWeixinAccount()
						.getWxFromUserName());
		for (int i = 0; i < menusList.size(); i++) {
			if (menusList.get(i).getParentId() == 0)
				menusList.get(i).setParentName("---");
			else // if (menusList.get(i).getParentId() == 0)
			{
				MenusBean mb = this.messageService.findMenuById(menusList
						.get(i).getParentId());
				if (mb != null)
					menusList.get(i).setParentName(mb.getMenuName());
				else
					menusList.get(i).setParentName("未找到");
			}
			menusList.get(i).setMenuValue(menusList.get(i).getMenuUrl());
			if (menusList.get(i).getMenuType().equals("click")) {
				WeixinAccount acc = this.getWeixinAccount();
				List<KeyDefine> keys = this.messageService.findKeyValue(
						menusList.get(i).getMenuKey(), acc.getWxFromUserName());
				if (keys != null && keys.size() > 0) {
					menusList.get(i).setMenuValue(keys.get(0).getKeyName());
				} else {
					menusList.get(i).setMenuValue("未找到");
				}
				menusList.get(i).setMenuTypeStr("点击类型");
			} else if (menusList.get(i).getMenuType().equals("view"))
				menusList.get(i).setMenuTypeStr("视图类型");
			else
				menusList.get(i).setMenuTypeStr("---");
		}
		this.mav.addObject("menus_list", menusList);

		this.mav.setViewName("menu/list");

		return mav;
	}

	/**
	 * 调出现在的菜单配置，实时从微信获取
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/now", method = RequestMethod.GET)
	public ModelAndView nowUI() {

		this.mav = new ModelAndView();
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();// Constant.appId;// "wxb83077ea9f2584bd";
		String appSecret = acc.getAppSecret();// Constant.appSecret;//
												// "7d412bd3b0dfe6d0f3c63b2e79901965";
		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		Menu menusList = WeixinUtils.getNow(access_token.getToken());

		this.mav.addObject("menus_list", menusList);

		this.mav.setViewName("menu/list");

		return mav;
	}

	/**
	 * 调出新增页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUI(HttpServletRequest request) {

		this.mav = new ModelAndView();
		this.mav.setViewName("menu/add");
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> menusList = this.messageService.findAllKeys("1",
				acc.getWxFromUserName());
		this.mav.addObject("keys", menusList);
		List<MenusBean> top_menu = this.messageService.findMenus(
				" and parentId=0", this.getWeixinAccount().getWxFromUserName());// 是顶级菜单的
		this.mav.addObject("parentIds", top_menu);
		this.mav.setViewName("menu/add");
		this.mav.addObject("toUserName", this.getWeixinAccount()
				.getWxFromUserName());
		return mav;
	}

	/**
	 * 接收新增请求，成功后转移到编辑页面
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/add/action", method = RequestMethod.POST)
	public String addAction(MenusBean menu) {
		WeixinAccount acc = this.getWeixinAccount();
		int menuId = this.messageService.AddMenu(menu, acc.getWxFromUserName());
		if (menuId > 0) {
			return this.REDIRECT + "/menu/update?id=" + menuId;
		} else {
			return "";
		}
	}

	/**
	 * 处理更新请求
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/update/action", method = RequestMethod.POST)
	public String update(MenusBean menu) {
		WeixinAccount acc = this.getWeixinAccount();
		this.messageService.updateMenu(menu, acc.getWxFromUserName());

		return this.REDIRECT + "/menu/update?id=" + menu.getId();

	}

	/**
	 * 清除微信号的菜单请求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	@ResponseBody
	public String clear() {
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();// Constant.appId;// "wxb83077ea9f2584bd";
		String appSecret = acc.getAppSecret();// Constant.appSecret;//
												// "7d412bd3b0dfe6d0f3c63b2e79901965";
		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		int result = WeixinUtils.deleteMenu(access_token.getToken());

		return String.valueOf(result);
	}

	/**
	 * 发布新的菜单请求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deploy", method = RequestMethod.GET)
	@ResponseBody
	public String deploy() {
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();// Constant.appId;// "wxb83077ea9f2584bd";
		String appSecret = acc.getAppSecret();// Constant.appSecret;//
												// "7d412bd3b0dfe6d0f3c63b2e79901965";
		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		int result = WeixinUtils.deleteMenu(access_token.getToken());
		if (result == 0) {
			WeixinAccount wx = this.getWeixinAccount();
			Menu menu = this.messageService.getMenuList(wx.getAccountId());
			if (menu != null)
				result = WeixinUtils.createMenu(menu, access_token.getToken());
			else
				result = -2;// 获取失败
		} else
			result = -3;// 删除失败
		return String.valueOf(result);
	}

	/**
	 * 处理删除请求
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam(value = "id", required = true) int id) {
		int ret = this.messageService.DeleteMenu(id);
		return String.valueOf(ret);
	}

	/**
	 * 调出更新编辑菜单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateUI(
			@RequestParam(value = "id", required = true) int id) {

		this.mav = new ModelAndView();
		MenusBean menu = this.messageService.findMenuById(id);// 是顶级菜单的
		this.mav.addObject("menu", menu);
		this.mav.setViewName("menu/update");
		WeixinAccount acc = this.getWeixinAccount();
		List<KeysBean> menusList = this.messageService.findAllKeys("1",
				acc.getWxFromUserName());

		// 获取图文消息
		NewsBean nb = this.messageService
				.findNewsByArticleId(menu.getMenuKey(), acc.getWxFromUserName());
		if (nb == null)
			this.mav.addObject("msgId", -1);
		else
			this.mav.addObject("msgId", menu.getMenuKey());

		this.mav.addObject("keys", menusList);
		List<MenusBean> top_menu = this.messageService.findMenus(
				" and parentId=0", this.getWeixinAccount().getWxFromUserName());// 是顶级菜单的
		this.mav.addObject("parentIds", top_menu);
		this.mav.addObject("toUserName", this.getWeixinAccount().getWxFromUserName());
		return mav;
	}
}
