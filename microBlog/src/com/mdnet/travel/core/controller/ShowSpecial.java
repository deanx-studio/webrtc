package com.mdnet.travel.core.controller;

import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.inf.impl.ScenicTicketImplProxy;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes;
import net.zhinet.travel.pojo.reqandrespojo.View_InfoRes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.GroupDate;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.ICustomService;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.service.IOrderMgrService;
import com.mdnet.travel.core.vo.SpecialBean;
import com.mdnet.travel.core.vo.SpecialInfo;

@Controller
@RequestMapping("/show")
public class ShowSpecial extends BaseController {
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;
	@Resource(name = ICustomService.SERVICE_NAME)
	protected ICustomService customService;

	/**
	 * 编辑标题作者
	 * 
	 * @return
	 */
	@RequestMapping(value = "/spec", method = RequestMethod.GET)
	public ModelAndView showSpecial(
			@RequestParam(value = "id", required = true) int id) {
		SpecialBean sb = this.messageService.GetSpecial(id);
		this.mav = new ModelAndView();
		String msg = "";
		if (sb != null) {
			this.mav.addObject("makeTime", sb.getSpecialMaketime());
			this.mav.addObject("title", sb.getTitle());
			this.mav.addObject("writer", sb.getSpecialWriter());
			this.mav.addObject("align", sb.getAlign());
			SpecialInfo[] sps = this.messageService.GetContentList(sb);
			for (int i = 0; sps != null && i < sps.length; i++) {
				sps[i].setSmart_text(sps[i].getSmart_text().replaceAll("\n",
						"<br/>"));
				// 标签替换
				String txt = sps[i].getSmart_text();
				if (txt.length() > 0) {
					txt = this.searchProductKey(txt);
					txt = this.searchScenicKey(txt);
					txt = this.searchSpecialcKey(txt);
					txt = this.searchGroupKey(txt);
				}

				sps[i].setSmart_text(txt);

			}
			this.mav.addObject("content_list", sps);
		} else// 未找到相关数据
		{
			msg = "未找到相关数据。";
		}

		this.mav.addObject("id", id);
		this.mav.addObject("weixinId", sb.getToUserName());
		WeixinAccount acc = this.wxAccountService
				.getWeixinAccountByFromuserName(sb.getToUserName());
		this.mav.addObject("weixinName", acc.getWxName());
		this.mav.addObject("msg", msg);
		this.mav.addObject("prevSpecial",
				this.messageService.getPrevSpecial(id, acc.getWxFromUserName()));
		this.mav.addObject("nextSpecial",
				this.messageService.getNextSpecial(id, acc.getWxFromUserName()));

		String keys = this.travelerService.getMetaKeys(String.valueOf(id));
		keys = keys.replace("，", ",");
		this.mav.addObject("metaKeys", keys);

		this.mav.setViewName("display/special");
		return mav;// 回到页面编辑
	}

	private String searchGroupKey(String txt) {
		while (true) {
			int inx0 = txt.indexOf("#G");
			if (inx0 < 0)
				break;
			int inx1 = txt.substring(inx0 + 1).indexOf('#');
			if (inx0 >= 0 && inx1 > 0) {
				inx1++;
				// 替换
				String code = txt.substring(inx0, inx0 + inx1 + 1);
				// 获取团期
				String pid = code.substring(2, inx1);
				List<GroupDate> gs = customService.getGroupList(
						" where productId=" + pid, 0);
				String gList = "";
				String tmpl = "<div class='span12'>";
				// <!-- <h5 style='font-size: 20px; margin-top: 10px;'></h5> -->
				tmpl = "<div style='height: 28px;'>";
				tmpl += "<span style='font-size: 14px; float: left;'>%s</span>";
				tmpl += "<span style='float: right;'>";
				tmpl += "<a style='background-color: #f60; color: white;' class='btn btn-lg active' ";
				tmpl += " href='http://www.xdujia.com/custom/order?productID=%s&gDate=%s'>%s发团&nbsp;报名";
				tmpl += " </a></span></div></div><br/>";
				for (int i = 0; gs != null && i < gs.size(); i++) {
					GroupDate gd = gs.get(i);
					String d[] = gd.getStartDate().split("-");
					gList += String
							.format(tmpl,
									gd.getProductName()
											+ (gd.getBookCount() == gd
													.getTotalCount() ? "（已满）"
													: ""), pid, gd
											.getStartDate(), d[1] + "月" + d[2]
											+ "日");
				}
				txt = txt.replace(code, gList);
			} else {
				// txt = txt.replaceAll(code, "");
				break;
			}

		}
		return txt;
	}

	private String searchProductKey(String txt) {
		while (true) {
			int inx0 = txt.indexOf("#C");
			if (inx0 < 0)
				break;
			int inx1 = txt.substring(inx0 + 1).indexOf('#');
			if (inx0 >= 0 && inx1 > 0) {
				inx1++;
				// 替换
				String code = txt.substring(inx0, inx0 + inx1 + 1);
				// 找到=
				int pinx = code.indexOf('=');
				String pid = "";
				String pname = "";
				if (pinx > 0)// 带有额外参数的
				{
					pid = code.substring(2, pinx);
					pname = code.substring(pinx + 1, code.length() - 1);
				} else {
					// 只有编号的
					pid = code.substring(2, inx1);

				}
				// 获取产品信息
				Ticket_InfoRes pinfo = getProxy().productDetail(pid);
				if (pinfo != null && pinfo.getScenicTickets() != null
						&& pinfo.getScenicTickets().length > 0) {
					int price = pinfo.getScenicTickets()[0].getSalePrice();
					int mPrice = pinfo.getScenicTickets()[0].getMarketPrice();
					String fmt = "%.0f";
					if (mPrice < 2000)
						fmt = "%.2f";
					if (pname.length() <= 0)
						pname = pinfo.getScenicTickets()[0].getTicketName();
					int viewId = pinfo.getScenicTickets()[0].getScenicId();
					String order_url = String.format(
							"%sorder/go_pay.do?ticketId=%s&scenicId=%d",
							this.myConstant.getWeixin_web(), pid, viewId);
					String p_str = "<div class='span12'>";
					p_str += "<h5 style='font-size:20px;margin-top:10px;'>%s</h5>";
					p_str += "<div><span style='font-size:14px;float:left;'>";
					p_str += "市场价<del>￥" + fmt + "</del></a>";
					p_str += "</span><span style='float:right;'>";
					p_str += "<a style='background-color:#f60;color:white;' class='btn btn-lg active' href='%s'>￥"
							+ fmt + "&nbsp;预订</a></span></div></div>";
					String dstCode = String
					// .format("%s&nbsp;&nbsp;<a href=\"%sorder/go_pay.do?ticketId=%s&scenicId=%d\"  style=\"background-color:#f60;color:white;\" class=\"btn btn-lg active\">￥%.2f元  订购</a>",
					// pname, Constant.weixin_web, pid, viewId,
					// price / 100.0);
							.format(p_str, pname, mPrice / 100.0, order_url,
									price / 100.0);
					txt = txt.replaceAll(code, dstCode);

				} else {
					txt = txt.replaceAll(code, "产品代码:" + pid
							+ "产品信息未找到，请确认产品编号正确，产品状态为上架状态。");
					// break;
				}
			} else
				break;
		}
		return txt;

	}

	private String searchSpecialcKey(String txt) {
		while (true) {
			int inx0 = txt.indexOf("#Z");
			if (inx0 < 0)
				break;
			int inx1 = txt.substring(inx0 + 1).indexOf('#');
			if (inx0 >= 0 && inx1 > 0) {
				inx1++;
				// 替换
				String code = txt.substring(inx0, inx0 + inx1 + 1);
				// 找到=
				int pinx = code.indexOf('=');
				String specialId = "";
				String pname = "";
				if (pinx > 0)// 带有额外参数的
				{
					specialId = code.substring(2, pinx);
					pname = code.substring(pinx + 1, code.length() - 1);
				} else {
					// 只有编号的
					specialId = code.substring(2, inx1);

				}
				// 获取专题信息
				SpecialBean sb = this.messageService.GetSpecial(Integer
						.parseInt(specialId));

				if (sb != null) {

					if (pname.length() <= 0)
						pname = sb.getTitle();

					String dstCode = String.format(
							"<a href=\"spec?id=%s\">%s</a>", specialId, pname);
					txt = txt.replaceAll(code, dstCode);

				} else {
					txt = txt.replaceAll(code, "专题代码:" + specialId
							+ "产品信息未找到，请确认产品编号正确，产品状态为上架状态。");
					// break;
				}
			} else
				break;
		}
		return txt;

	}

	private String searchScenicKey(String txt) {
		while (true) {
			int inx0 = txt.indexOf("#J");
			if (inx0 < 0)
				break;
			int inx1 = txt.substring(inx0 + 1).indexOf('#');
			if (inx0 >= 0 && inx1 > 0) {
				inx1++;
				// 替换
				String code = txt.substring(inx0, inx0 + inx1 + 1);
				// 找到=
				int pinx = code.indexOf('=');
				String viewId = "";
				String pname = "";
				if (pinx > 0)// 带有额外参数的
				{
					viewId = code.substring(2, pinx);
					pname = code.substring(pinx + 1, code.length() - 1);
				} else {
					// 只有编号的
					viewId = code.substring(2, inx1);

				}
				// 获取景区信息
				View_InfoRes view_info = getProxy().ScenicInfo(
						Integer.parseInt(viewId));
				if (view_info != null && view_info.getScenicDetail() != null
						&& view_info.getScenicDetail().length > 0) {

					if (pname.length() <= 0)
						pname = view_info.getScenicDetail()[0].getScenicName();

					String dstCode = String.format(
							"<a href=\"%sscenic/detail?scenic_id=%s\">%s</a>",
							this.myConstant.getWeixin_web(), viewId, pname);
					txt = txt.replaceAll(code, dstCode);

				} else {
					txt = txt.replaceAll(code, "景区代码:" + viewId
							+ "产品信息未找到，请确认产品编号正确，产品状态为上架状态。");
					// break;
				}
			} else
				break;
		}
		return txt;

	}

}
