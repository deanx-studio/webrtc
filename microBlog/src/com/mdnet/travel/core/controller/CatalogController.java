package com.mdnet.travel.core.controller;

import javax.servlet.http.HttpServletRequest;

import net.zhinet.travel.pojo.basepojo.CatalogDef;
import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/catalog")
public class CatalogController extends BaseController {

	@RequestMapping("/list")
	public ModelAndView lisAll(
			@RequestParam(value = "openid", required = false) String openId,
			HttpServletRequest request) {
		this.mav = new ModelAndView();
		openId = this.getOpenId(request, openId);
		this.mav.addObject("openId", openId);
		CatalogDef[] defs = getProxy().catalogList();

		this.mav.addObject("catalogList", defs);
		this.mav.setViewName("search/catalog");
		return this.mav;
	}

	@RequestMapping("/ticket")
	public ModelAndView lisTickets(
			@RequestParam(value = "catalogId", required = true) int catalogId,
			@RequestParam(value = "pageNo", required = false) String page) {
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		this.mav = new ModelAndView();
		TicketInfo[] tickets = getProxy().getTicketsByCatalog(catalogId,
				pageNo);
		int itemCount = 0;
		if (tickets != null)
			itemCount = tickets.length;
		this.mav.addObject("ticketInfoList", tickets);
		this.doPager(pageNo + 1, itemCount);
		CatalogDef[] defs = getProxy().catalogList();
		for (CatalogDef def : defs) {
			if (def.getId() == catalogId)
				this.mav.addObject("catalogName", def.getCatalogName());
		}
		this.mav.setViewName("ticket/list");
		return this.mav;
	}
}
