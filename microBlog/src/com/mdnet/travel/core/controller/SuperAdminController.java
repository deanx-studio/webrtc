package com.mdnet.travel.core.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.ITravelerService;
import com.mdnet.travel.core.service.IWeixinAccountService;
import com.mdnet.travel.core.vo.UserListBean;

@Controller
@RequestMapping("/super")
public class SuperAdminController extends BaseController {

	

	@RequestMapping("/home")
	public String adminPage() {
		return this.REDIRECT + "/super/user/list";
	}

	@RequestMapping("/user/delete")
	@ResponseBody
	public String deleteUser(
			@RequestParam(value = "travelerId", required = true) int id) {
		int ret = this.travelerService.deleteUser(id);
		return String.valueOf(ret);
	}

	@RequestMapping("/user/edit")
	public ModelAndView userEdit(
			@RequestParam(value = "travelerId", required = false) String id,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userPwd", required = true) String passWd,
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "wxAccount", required = true) String fromUserName,
			@RequestParam(value = "role", required = true) String role) {
		this.getMav();
		int travelerId = 0;
		if (id == null || id.length()==0) {
			// 新增
			travelerId = this.travelerService.saveTraveler(username, passWd,
					mobile, "", role, fromUserName, null);
			this.mav.addObject("message", "用户创建成功，");
		} else {
			// //通过名称查找，找到后比对ID，一致表明是本人的，不一致表明不是本的，不能更新
			boolean chkResult = this.travelerService.checkUsename(
					Integer.parseInt(id), username);
			// 更新
			if (chkResult) {
				travelerId = this.travelerService.saveTraveler(username,
						passWd, mobile, "", role, fromUserName, id);
				this.mav.addObject("message", "更新成功。");
			} else
				this.mav.addObject("message", "用户名重复，不能更新。");
		}
		this.mav.addObject("accountList",
				this.wxAccountService.findWXAccounts(-1));
		this.mav.addObject("travelerObj",
				this.travelerService.findTravelerById(travelerId));
		this.mav.setViewName("super/userUpdate");
		return this.mav;
	}

	@RequestMapping("/user/add")
	public ModelAndView showAddUI(
			@RequestParam(value = "id", required = false) String id) {
		this.getMav();
		if (id != null) {
			this.mav.addObject("travelerObj",
					this.travelerService.findTravelerById(Integer.parseInt(id)));
			this.mav.setViewName("super/userUpdate");
		} else {
			this.mav.setViewName("super/userAdd");
		}

		this.mav.addObject("accountList",
				this.wxAccountService.findWXAccounts(-1));
		return this.mav;
	}

	@RequestMapping("/user/list")
	public ModelAndView userList(
			@RequestParam(value = "pageNo", required = false) String page,
			@RequestParam(value = "role", required = false) String role) {

		int pageNo = 1;
		int itemCount = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		this.getMav();
		this.mav.setViewName("super/userList");
		List<UserListBean> userList = this.travelerService.findAdmin(
				pageNo - 1, role);
		this.mav.addObject("userList", userList);
		if (userList != null)
			itemCount = userList.size();
		this.doPager(pageNo, itemCount);
		return this.mav;
	}

	/*************** 微信帐号开始 **************/
	@RequestMapping("/weixin/list")
	public ModelAndView weixinList(
			@RequestParam(value = "pageNo", required = false) String page) {
		this.getMav();
		int pageNo = 1;
		if (page != null)
			pageNo = Integer.parseInt(page);
		List<WeixinAccount> accounts = this.wxAccountService.getAll(pageNo - 1);
		this.mav.addObject("weiwinList", accounts);
		this.mav.setViewName("super/accountList");
		int itemCount = 0;
		if (accounts != null)
			itemCount = accounts.size();
		this.doPager(pageNo, itemCount);
		return this.mav;
	}

	@RequestMapping("/weixin/edit")
	public ModelAndView weixinEdit(
			@RequestParam(value = "wid", required = false) String id,
			@RequestParam(value = "wxName", required = true) String wxName,
			@RequestParam(value = "wxFromUserName", required = true) String wxFromUserName,
			@RequestParam(value = "wxAccount", required = true) String wxAccount,
			@RequestParam(value = "wxType", required = true) int wxType,
			@RequestParam(value = "appId", required = true) String appId,
			@RequestParam(value = "appSecret", required = true) String appSecret) {
		// 保存数据
		int wxAccountId = this.wxAccountService.saveWeixin(id, wxName,
				wxFromUserName, wxAccount, wxType, appId, appSecret);
		
		// 显示数据
		this.getMav();
		if(wxAccountId>0)
			this.mav.addObject("message", "数据写入操作成功。");
		WeixinAccount weixinAccount = this.wxAccountService
				.getWeixinAccount(wxAccountId);
		this.mav.addObject("weixinObj", weixinAccount);
		this.mav.setViewName("super/accountEdit");
		return this.mav;
	}

	@RequestMapping("/weixin/delete")
	@ResponseBody
	public String weixinDelete(
			@RequestParam(value = "wid", required = true) String id) {
		String.valueOf(this.wxAccountService.delete(id));
		return "0";
	}
	@RequestMapping("/weixin/add")
	public ModelAndView weixinAddUI(
			@RequestParam(value = "wid", required = false) String id) {
		this.getMav();
		if (id == null)
			this.mav.setViewName("super/accountAdd");
		else {
			WeixinAccount weixinAccount = this.wxAccountService
					.getWeixinAccount(Integer.parseInt(id));
			this.mav.addObject("weixinObj", weixinAccount);
			this.mav.setViewName("super/accountEdit");
		}
		return this.mav;
	}
	/*************** 微信帐号结束 **************/
}
