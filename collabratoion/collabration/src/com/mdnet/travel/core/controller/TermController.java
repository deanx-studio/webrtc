package com.mdnet.travel.core.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.pojo.basepojo.CallHistory;
import net.zhinet.travel.pojo.basepojo.TerminateInfo;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.asterisk.action.OriginateAction;
import com.mdnet.asterisk.ami.AMIBase;
import com.mdnet.travel.core.service.ICallService;

@Controller
@RequestMapping("/term")
public class TermController extends BaseController {
	@Resource(name = ICallService.SERVICE_NAME)
	private ICallService callService;

	@RequestMapping("/callHistory")
	@ResponseBody
	public String callHistory(
			@RequestParam(value = "peer", required = true) String peer) {
		List<CallHistory> his = this.callService.findHistory(
				"where localPeer='" + peer + "'", 0, 4);

		if (his != null && his.size() > 0) {
			Gson g = new Gson();
			return g.toJson(his);
		} else
			return "";
	}

	/*
	 * 列举所有终端
	 */
	@RequestMapping("/groupCall")
	@ResponseBody
	public String groupCall(
			@RequestParam(value = "peers", required = false) String peers) {
		List<TerminateInfo> terms = this.callService.listTerm(null, null,
				peers, null, 0, 20);
		String groupId = "00";
		for(TerminateInfo t:terms)
		{
			//逐个发送组呼AMI消息
			OriginateAction msg = new OriginateAction();
			msg.setCallerID("70"+groupId);
			msg.setChannel(t.getPeer());
			msg.setContext("from-sip");
			msg.setExten("70"+groupId);
			msg.setVariable("confNo="+"70"+groupId);
			AMIBase.instance().sendAction(msg);
		}
		return "success";
	}

	/*
	 * 列举所有终端
	 */
	@RequestMapping("/search")
	@ResponseBody
	public String searchTerm(
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "peer", required = false) String peer,
			@RequestParam(value = "peers", required = false) String peers,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "count", required = false) String count) {
		int pageNo = 0;
		int pageCount = 20;
		if (page != null)
			pageNo = Integer.parseInt(page);
		if (count != null)
			pageCount = Integer.parseInt(count);
		List<TerminateInfo> terms = this.callService.listTerm(status, peer,
				peers, name, pageNo, pageCount);
		Date now = new Date();
		for (TerminateInfo ti : terms) {
			ti.setDevicePassword("");
			// 超时设置为未注册.10分钟为超时
			// checkRegisterTimeout(now, ti);
		}

		if (terms != null && terms.size() > 0) {
			Gson g = new Gson();
			return g.toJson(terms);
		} else
			return "";
	}

	@RequestMapping("/list")
	public ModelAndView termList(
			@RequestParam(value = "pageNo", required = false) String page) {

		int pageNo = 0;
		int itemCount = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		this.createMav(null);
		this.mav.setViewName("admin/term/list");
		List<TerminateInfo> termList = this.callService.findTerm(pageNo);
		this.mav.addObject("termList", termList);
		if (termList != null)
			itemCount = termList.size();
		this.mav.addObject("menuInx", 2);
		this.doPager(pageNo, itemCount, 20);
		return this.mav;
	}
}
