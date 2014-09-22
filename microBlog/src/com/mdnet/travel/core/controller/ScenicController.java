package com.mdnet.travel.core.controller;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;

import net.zhinet.travel.pojo.basepojo.TicketInfo;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes;
import net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.Traveler;

@RequestMapping("/scenic")
@Controller
public class ScenicController extends BaseController {
	/**
	 * 景区导览
	 * 
	 * @return
	 */
	@RequestMapping("/guide")
	public String guide() {
		return "scenic/guide";
	}

	/**
	 * 景区详情
	 * 
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("scenic_id") String scenicId) {

		// 详情逻辑
		this.logger.info("查询景区详情开始,景区id为" + scenicId);

		ViewDetailRes viewDetailRes = null;
		TicketInfo[] ticketInfos = null;

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

		String openId = request.getParameter("openId");

		if (openId != null && !openId.equals("")) {

			Traveler traveler = this.travelerService.findTravelByOpenId(openId);

			if (traveler != null) {

				this.mav = new ModelAndView();
				mav.addObject("traveler", traveler);
				mav.addObject("scenic_id", scenicId);
				mav.addObject("detail", "scenic/detail?scenic_id=" + scenicId);
				mav.setViewName("common/login");
				return mav;

			}

		}

		StringBuilder scenicName = new StringBuilder();
		try {
			viewDetailRes = getProxy().getViewDetail(scenicId);
			ticketInfos = getProxy().getTicketsByScenicId(
					Integer.parseInt(scenicId), scenicName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (true /* this.IsMobile(request) */) {

			if (viewDetailRes != null
					&& viewDetailRes.getViewDetailInfo() != null) {
				// 将地址从配置文件中读出来
				for (int i = 0; i < viewDetailRes.getViewDetailInfo().length; i++) {

					viewDetailRes.getViewDetailInfo()[i].setPCUrl(viewDetailRes
							.getViewDetailInfo()[i].getSmartDeviceUrl());
					viewDetailRes.getViewDetailInfo()[i]
							.setPc_text(viewDetailRes.getViewDetailInfo()[i]
									.getSmart_text());
				}
			}
		} /*
		 * else { if (viewDetailRes != null && viewDetailRes.getViewDetailInfo()
		 * != null) { // 将地址从配置文件中读出来 for (int i = 0; i <
		 * viewDetailRes.getViewDetailInfo().length; i++) {
		 * 
		 * viewDetailRes.getViewDetailInfo()[i].setPCUrl(viewDetailRes
		 * .getViewDetailInfo()[i].getSmartDeviceUrl());
		 * viewDetailRes.getViewDetailInfo()[i]
		 * .setPc_text(viewDetailRes.getViewDetailInfo()[i] .getSmart_text()); }
		 * } }
		 */

		this.mav = new ModelAndView();
		mav.addObject("scenicInfo", ticketInfos);
		mav.addObject("viewDetails", viewDetailRes.getViewDetailInfo());
		mav.addObject("scenicName", scenicName.toString());
		mav.setViewName("scenic/detail");
		return mav;
	}

	/**
	 * 产品详情
	 * 
	 * 
	 */
	@RequestMapping("/ticketDetail")
	public ModelAndView ticketDetail(@RequestParam("ticketId") String ticketId) {
		// 产品详情
		this.logger.info("产品详情查询开始，查询的产品ID为" + ticketId);

		Ticket_InfoRes ticket_InfoRes = null;

		try {
			ticket_InfoRes = getProxy().getTicketDetail(ticketId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.mav = new ModelAndView();
		mav.addObject("ticketDetail", ticket_InfoRes.getScenicTickets());
		mav.setViewName("scenic/ticketdetail");
		return mav;
	}
}
