package com.mdnet.travel.core.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.zhinet.travel.pojo.basepojo.ScenicInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/recommend")
public class RecommendController extends BaseController {

	@RequestMapping("/view")
	public ModelAndView view() {
		String cityName = "";
		String commentDate = "";
		String provinceName = "";
		List<ScenicInfo> viewList = new ArrayList<ScenicInfo>();
		try {
			viewList = getProxy().getRecommendViews(cityName, commentDate,
					provinceName);
		} catch (RemoteException e) {
			viewList = null;
		}
		// if (null != viewList) {
		// for (ScenicInfo view : viewList) {
		// TicketInfo[] ticketList = null;
		// ticketList = view.getScenicTickets();
		// }
		// }
		this.mav = new ModelAndView();
		this.mav.setViewName("recommend/view");
		this.mav.addObject("view_list", viewList);
		return this.mav;
	}
}
