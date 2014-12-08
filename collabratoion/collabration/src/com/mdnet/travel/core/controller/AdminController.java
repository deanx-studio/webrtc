package com.mdnet.travel.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.ParamConfig;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.service.IAdminService;
import com.mdnet.travel.core.vo.UserListBean;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@RequestMapping(value = { "/", "home" }, method = RequestMethod.GET)
	public ModelAndView adminPage() {
		this.mav = new ModelAndView();
		this.mav.setViewName("admin/home");

		return mav;

	}

	/******** 用户管理 开始 *************/
	@RequestMapping("/user/delete")
	@ResponseBody
	public String deleteUser(
			@RequestParam(value = "uid", required = true) int id) {
		int ret = this.adminService.deleteUser(id);
		return String.valueOf(ret);
	}


	@RequestMapping("param/ami")
	public ModelAndView paramAmi(
			@RequestParam(value = "amiServer", required = false) String amiServer,
			@RequestParam(value = "amiPort", required = false) String amiPort,
			@RequestParam(value = "amiUsername", required = false) String amiUsername,
			@RequestParam(value = "amiSecrect", required = false) String amiSecrect) {
		this.createMav(null);
		// 保存数据
		if (amiServer != null && amiUsername != null && amiSecrect != null) {
			this.adminService.setParam("amiServer", amiServer, "AMI服务器地址或者域名");
			this.adminService.setParam("amiPort", amiPort, "AMI服务的访问端口号");
			this.adminService.setParam("amiUsername", amiUsername,
					"AMI服务的访问用户名");
			this.adminService.setParam("amiSecrect", amiSecrect, "AMI服务的访问密码");
			//更新所有数据
			this.adminService.reloadParam();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.mav.addObject("message", sdf.format(new Date()) + "保存成功!");
		}
		// 显示数据

		this.mav.setViewName("admin/param/ami");
		List<ParamConfig> params = adminService.getParams();
		this.mav.addObject("params", params);
		return this.mav;
	}

	@RequestMapping("param/websocket")
	public ModelAndView paramWebsocket(
			@RequestParam(value = "domain", required = false) String domain,
			@RequestParam(value = "websocket_proxy_url", required = false) String websocket_proxy_url,
			@RequestParam(value = "outbound_proxy_url", required = false) String outbound_proxy_url,
			@RequestParam(value = "ICE", required = false) String ICE,
			@RequestParam(value = "realm", required = false) String realm) {
		this.createMav(null);
		// 保存数据
		if (domain != null && websocket_proxy_url != null
				&& outbound_proxy_url != null && ICE != null && realm != null) {
			this.adminService.setParam("domain", domain, "SIP域(domain)");
			this.adminService.setParam("websocket_proxy_url",
					websocket_proxy_url, " web socket服务器地址和端口号");
			this.adminService.setParam("outbound_proxy_url",
					outbound_proxy_url, " sip服务器地址和端口");
			this.adminService.setParam("ICE", ICE, "穿越防火墙的ICE、STUN或者TURN服务器");
			this.adminService.setParam("realm", realm, "realm：sip领域名称");
			//更新所有数据
			this.adminService.reloadParam();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.mav.addObject("message", sdf.format(new Date()) + "保存成功!");
		}
		// 显示数据

		this.mav.setViewName("admin/param/websocket");
		List<ParamConfig> params = adminService.getParams();
		this.mav.addObject("params", params);
		return this.mav;
	}

	@RequestMapping("/user/edit")
	@ResponseBody
	public String userEdit(
			@RequestParam(value = "uid", required = false) String userId,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "userPwd", required = false) String passWd,
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "role", required = true) String role,
			@RequestParam(value = "terminateNumber", required = true) String terminateNumber) {
		int uid = 0;
		if (userId == null)
			uid = this.adminService.checkUsename(username);
		else
			uid = Integer.parseInt(userId);
		if (uid > 0)// 找到了
		{
			this.adminService.updateUserInfo(uid, username, passWd, mobile,
					role, terminateNumber);
		} else {
			// 新增
			uid = this.adminService.insertUserInfo(username, passWd, mobile,
					role, terminateNumber);
		}
		return String.valueOf(uid);
	}

	@RequestMapping("/user/list")
	public ModelAndView userList(
			@RequestParam(value = "pageNo", required = false) String page,
			@RequestParam(value = "role", required = false) String role) {

		int pageNo = 0;
		int itemCount = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		this.createMav(null);
		this.mav.setViewName("admin/userList");
		List<UserInfo> userList = this.adminService.findAdmin(pageNo);
		this.mav.addObject("userList", userList);
		if (userList != null)
			itemCount = userList.size();
		this.mav.addObject("menuInx", 1);
		this.doPager(pageNo, itemCount, 20);
		return this.mav;
	}

	/******** 用户管理 结束 *************/
}
