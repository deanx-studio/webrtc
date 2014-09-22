package com.mdnet.travel.core.controller;

import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.vo.SearchBean;

@Controller
@RequestMapping("/search") 
public class SearchController extends BaseController {
	@RequestMapping("/view")
	public String viewSearchUI() {
		return "search/view";
	}

	@RequestMapping("/do_view")
	public ModelAndView viewSearch(SearchBean search) {
		this.mav = new ModelAndView();
		// this.mav.setViewName(this.FORWARD+"/search/view");
		return this.mav;
	} 

	@RequestMapping("/product")
	public ModelAndView productSearch(
			@RequestParam("searchKey") String searchKey,
			@RequestParam(value = "pageNo", required = false) String page) {
		this.logger.info("搜索关键字："+searchKey);
		int pageNo = 1;
		if (page != null)
			pageNo = Integer.parseInt(page);
		this.mav = new ModelAndView();
		this.mav.addObject("searchKey", searchKey);

		TicketInfo[] ticketInfoList = null;
		try {
			ticketInfoList = getProxy().listProducts(null, searchKey, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			ticketInfoList = null;
		}
		int itemCount = 0;
		if (ticketInfoList != null)
			itemCount = ticketInfoList.length;
		
		this.doPager(pageNo, itemCount);
		this.mav.addObject("ticketInfoList", ticketInfoList);
		this.mav.setViewName("search/product");
		return this.mav;
	}

}
