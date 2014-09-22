package com.mdnet.travel.core.controller;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mdnet.travel.core.model.GroupDate;
import com.mdnet.travel.core.model.PersonalCustom;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.service.ICustomService;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.service.IOrderMgrService;
import com.mdnet.travel.core.utils.CommonUtils;
import com.mdnet.travel.core.vo.GroupListBean;
import com.mdnet.travel.core.vo.PersonalCustomBean;
import com.mdnet.travel.core.vo.ShowProductInfo;
import com.mdnet.travel.core.vo.SpecialBean;
import com.mdnet.travel.core.vo.SpecialInfo;
import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductDetail;

@Controller
@RequestMapping("/custom")
public class CustomController extends BaseController {
	@Resource(name = ICustomService.SERVICE_NAME)
	protected ICustomService customService;
	@Resource(name = IMessageService.SERVICE_NAME)
	private IMessageService messageService;
	@Resource(name = IOrderMgrService.SERVICE_NAME)
	private IOrderMgrService orderMgrService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		// return this.REDIRECT + "/" + this.preMobile(request) + "custom/book";
		this.getMav(request);
		this.mav.setViewName(this.preMobile(request) + "custom/home");
		return this.mav;
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
						"where productId=" + pid, 0);
				String gList = "<table calss='table'>";
				String tmpl = "<tr>";
				// <!-- <h5 style='font-size: 20px; margin-top: 10px;'></h5> -->
				
				tmpl += "<td>%s</td>";
				
				tmpl += "<td><a style='background-color: #f60; color: white;' class='btn btn-lg active' ";
				tmpl += " href='http://www.xdujia.com/custom/order?productID=%s&gDate=%s'>%s发团&nbsp;报名";
				tmpl += " </a></td></tr>";
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
				txt = txt.replace(code, gList+"</table>");
			} else {
				// txt = txt.replaceAll(code, "");
				break;
			}

		}
		return txt;
	}

	protected String preMobile(HttpServletRequest request) {
		if (CommonUtils.IsMobile(request))
			return "mobile/";
		else
			return "";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ModelAndView moreActicles(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 1);
		int length = 20;
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		List<SpecialBean> sb = this.messageService.findSpecial(
				" toUserName='mgzj' ", pageNo, length);
		Gson g = new Gson();
		for (SpecialBean s : sb) {
			SpecialInfo[] si = g.fromJson(s.getSpecialBody(),
					SpecialInfo[].class);
			// 检索json字符串）中的第一个图片
			for (SpecialInfo b : si) {
				if (b.getSmart().length() > 0) {
					s.setImg(b.getSmart());
					break;
				}
			}
		}
		this.mav.addObject("artileList", sb);
		int itemCount = (sb != null ? sb.size() : 0);
		this.doPager(pageNo, itemCount, length);
		this.mav.setViewName(this.preMobile(request) + "custom/articles");
		return this.mav;
	}

	@RequestMapping(value = "/robot", method = RequestMethod.GET)
	public ModelAndView robotActicle(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page
			) {
		this.getMav(request);
		int length = 200;
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);
		List<SpecialBean> sb = this.messageService.findSpecial(
				" toUserName='mgzj' ", pageNo, length);
		this.mav.addObject("artileList", sb);
		int itemCount = (sb != null ? sb.size() : 0);
		this.doPager(pageNo, itemCount, length);
		this.mav.setViewName("custom/robot");
		return this.mav;
	}
	
	@RequestMapping(value = "/sitemap", method = RequestMethod.GET)
	public ModelAndView robotActicle() {
		this.getMav();
		int length = 5000;
		int pageNo = 0;
		List<SpecialBean> sb = this.messageService.findSpecial(
				" toUserName='mgzj' ", pageNo, length);
		this.mav.addObject("artileList", sb);
		
		this.mav.setViewName("sitemap");
		return this.mav;
	}

	@RequestMapping(value = "/recommend", method = RequestMethod.GET)
	public ModelAndView recommend(HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 1);
		this.mav.setViewName(this.preMobile(request) + "custom/recommend");
		return this.mav;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView ProductDetail(HttpServletRequest request,
			@RequestParam(value = "id", required = false) String id) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 2);

		if (id == null)
			id = "115";
		SpecialBean sb = this.messageService.GetSpecial(Integer.parseInt(id));
		if (sb != null) {

			Gson g = new Gson();
			SpecialInfo[] si = g.fromJson(sb.getSpecialBody(),
					SpecialInfo[].class);
			for (int i = 0; i < si.length; i++) {
				String txt = si[i].getSmart_text();
				si[i].setSmart_text(txt.replaceAll("\n", "<br/>"));
				txt = this.searchGroupKey(txt);
				si[i].setSmart_text(txt);
			}
			this.mav.addObject("detailList", si);
			this.mav.addObject("mainTitle", sb.getTitle());
			this.mav.addObject("makeTime", sb.getSpecialMaketime());

			this.mav.setViewName(this.preMobile(request) + "custom/detail");
		} else
			this.mav.setViewName(this.preMobile(request) + "custom/detail" + id);
		WeixinAccount acc = this.wxAccountService
				.getWeixinAccountByFromuserName(sb.getToUserName());
		this.mav.addObject(
				"prevSpecial",
				this.messageService.getPrevSpecial(Integer.parseInt(id),
						acc.getWxFromUserName()));
		this.mav.addObject(
				"nextSpecial",
				this.messageService.getNextSpecial(Integer.parseInt(id),
						acc.getWxFromUserName()));
		String keys = this.travelerService.getMetaKeys(String.valueOf(id));
		keys = keys.replace("，", ",");
		this.mav.addObject("metaKeys", keys);
		return this.mav;
	}

	@RequestMapping(value = "/private", method = RequestMethod.GET)
	public ModelAndView PrivateCustom(HttpServletRequest request,
			@RequestParam(value = "step", required = false) String step) {
		this.getMav(request);
		this.mav.addObject("msg", "");
		this.mav.addObject("menuIndex", 3);
		if (step == null)
			step = "0";
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		this.mav.setViewName(this.preMobile(request) + "custom/private" + step);
		return this.mav;
	}

	@RequestMapping(value = "/private/show", method = RequestMethod.GET)
	public ModelAndView privateShow(
			@RequestParam(value = "step", required = false) String strStep,
			HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 3);
		int step = 0;
		if (strStep != null)
			step = Integer.parseInt(strStep);
		String sid = request.getSession().getId();
		switch (step) {
		case 0:
			// 获取存储信息
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		default:
			break;
		}
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		this.mav.setViewName(this.preMobile(request) + "custom/private" + step);
		return this.mav;
	}

	@RequestMapping(value = "/private/submit", method = RequestMethod.POST)
	public ModelAndView privateSubmit(
			@RequestParam(value = "step", required = false) String strStep,
			HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 3);
		int step = 0;
		if (strStep != null)
			step = Integer.parseInt(strStep);
		String sid = request.getSession().getId();
		// sid = "DC527D7EE88BC09839DDBFD96DE5B6E7";
		PersonalCustom personal = null;
		switch (step) {
		case 0:
			this.customService.savePrivate_Dest(sid,
					request.getParameterValues("radioNational"),
					request.getParameterValues("chkCity"),
					request.getParameterValues("goal"));
			step++;
			break;
		case 1:
			personal = this.customService.getPersonal(sid);
			if (personal != null) {
				personal.setStartDate(request.getParameter("startDate"));
				personal.setTripDays(Integer.parseInt(request
						.getParameter("number")));
				this.customService.updatePersonal(personal);
				step++;
			} else {
				this.mav.addObject("msg", "数据异常，请重新填写");
				step = 0;
			}
			break;
		case 2:
			personal = this.customService.getPersonal(sid);
			if (personal != null) {
				personal.setAdultPerson(Integer.parseInt(request
						.getParameter("adultNumber")));
				personal.setChildrenPerson(Integer.parseInt(request
						.getParameter("childrenNumber")));
				personal.setOldPerson(Integer.parseInt(request
						.getParameter("oldNumber")));
				personal.setHotelLevel(Integer.parseInt(request
						.getParameter("hotelLevel")));
				personal.setHotelGeogrophy(request.getParameter("geogrophy"));
				personal.setStandardNumber(Integer.parseInt(request
						.getParameter("standardNumber")));
				personal.setAdaptmentPerson(Integer.parseInt(request
						.getParameter("adaptmentNumber")));
				personal.setKingNumber(Integer.parseInt(request
						.getParameter("kingNumber")));
				this.customService.updatePersonal(personal);
				step++;
			} else {
				this.mav.addObject("msg", "数据异常，请重新填写");
				step = 0;
			}
			break;
		case 3:
			personal = this.customService.getPersonal(sid);
			if (personal != null) {
				String[] airCompany = request.getParameterValues("airCompany");
				String airCompanies = "";
				for (int i = 0; airCompany != null && i < airCompany.length; i++) {
					airCompanies += airCompany[i] + ",";
				}
				personal.setAirCompany(airCompanies);
				personal.setAirClass(Integer.parseInt(request
						.getParameter("radiosClassLevel")));
				personal.setTripMode(Integer.parseInt(request
						.getParameter("radiosTripMode")));
				personal.setAutoModel(request.getParameter("autoModelType"));
				this.customService.updatePersonal(personal);
				step++;
			} else {
				this.mav.addObject("msg", "数据异常，请重新填写");
				step = 0;
			}
			break;
		case 4:
			personal = this.customService.getPersonal(sid);
			if (personal != null) {
				personal.setMealProvider(Integer.parseInt(request
						.getParameter("meat_sel")));
				personal.setMealType(Integer.parseInt(request
						.getParameter("meat_type")));
				String[] elseService = request
						.getParameterValues("elseService");
				String strService = "";
				for (int i = 0; elseService != null && i < elseService.length; i++) {
					strService += elseService[i] + ",";
				}
				personal.setElseService(strService);
				personal.setMemo(request.getParameter("memo"));
				this.customService.updatePersonal(personal);
				step++;
			} else {
				this.mav.addObject("msg", "数据异常，请重新填写");
				step = 0;
			}
			break;
		case 5:
			personal = this.customService.getPersonal(sid);
			if (personal != null) {
				String userName = request.getParameter("userName");
				personal.setUserName(userName);
				String mobile = request.getParameter("userMobile");
				personal.setMobile(mobile);
				personal.setEmail(request.getParameter("userEmail"));
				this.customService.updatePersonal(personal);
				// 发送短信通知
				try {
					this.getProxy().sendSMS(
							"用户：" + userName + "，填写了境外自驾的定制资料,客户联系电话：" + mobile
									+ ",请登录http://xdujia.com/login查看客户详细资料"
							// + mobile
							, "13911531721");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				step++;
				this.mav.addObject("sid", sid);
			} else {
				this.mav.addObject("msg", "数据异常，请重新填写");
				step = 0;
			}
			break;
		default:
			break;
		}
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		this.mav.setViewName(this.preMobile(request) + "custom/private" + step);
		return this.mav;
	}

	/*
	 * 定制的详情
	 */
	@RequestMapping(value = "/mine", method = RequestMethod.GET)
	public ModelAndView mine(HttpServletRequest request,
			@RequestParam(value = "sid", required = true) String sid) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 4);

		PersonalCustom pc = this.customService.getPersonal(sid);
		this.mav.addObject("p", pc);
		this.mav.setViewName(this.preMobile(request) + "custom/mine");
		return this.mav;
	}

	@RequestMapping(value = "/mine_sel", method = RequestMethod.GET)
	public ModelAndView mine_sel(HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 4);
		this.mav.addObject("mineList", this.customService.getPersonals(request
				.getSession().getId(), 0));
		this.mav.setViewName(this.preMobile(request) + "custom/mine_sel");
		return this.mav;
	}

	/*
	 * js获取定制列表
	 */
	@RequestMapping(value = "/mine/list", method = RequestMethod.POST)
	@ResponseBody
	public String mineList(
			@RequestParam(value = "mobile", required = true) String mobile,
			@RequestParam(value = "page", required = true) int page) {

		List<PersonalCustom> pcs = this.customService.getPersonalByMobile(
				mobile, page);

		Gson g = new Gson();
		return g.toJson(pcs);
	}

	@RequestMapping(value = "/group/list", method = RequestMethod.POST)
	@ResponseBody
	public String groupList(HttpServletRequest request,
			@RequestParam(value = "productID", required = true) int pid) {
		List<GroupDate> gs = this.customService.getGroupList("where productId="
				+ pid, 0);
		if (gs != null) {
			for (int i = 0; i < gs.size(); i++) {
				try {
					gs.get(i).setProductName(
							java.net.URLEncoder.encode(gs.get(i)
									.getProductName(), "UTF-8"));
					String startDate = gs.get(i).getStartDate();
					String[] d = startDate.split("-");
					gs.get(i).setStartDate(startDate);
					/*
					 * d[0] + java.net.URLEncoder.encode("年", "UTF-8") + d[1] +
					 * java.net.URLEncoder.encode("月", "UTF-8") + d[2] +
					 * java.net.URLEncoder.encode("日", "UTF-8"));
					 */
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Gson g = new Gson();
			return g.toJson(gs);
		} else
			return "";
	}

	@RequestMapping(value = "/lines", method = RequestMethod.GET)
	public ModelAndView lines(HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 1);
		ShowProductInfo[] ps = this.orderMgrService.getProductList(3, 0);

		this.mav.addObject("productList", ps);
		this.mav.setViewName(this.preMobile(request) + "custom/lines");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		return this.mav;
	}

	@RequestMapping(value = "/group/list", method = RequestMethod.GET)
	public ModelAndView groupList(HttpServletRequest request,
			@RequestParam(value = "page", required = false) String page) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 6);
		int pageNo = 0;
		if (page != null)
			pageNo = Integer.parseInt(page);

		List<GroupDate> gd = this.customService.getGroupList("", pageNo);
		List<GroupListBean> gb = new ArrayList<GroupListBean>();
		for (int i = 0; gd != null && i < gd.size(); i++) {
			GroupListBean g = new GroupListBean();
			ProductDetail pd = this.orderMgrService.getProductInfo(gd.get(i)
					.getProductId());
			g.setImg(pd.getProductInfo().getImgURL());
			g.setProductName(gd.get(i).getProductName());
			g.setStartDate(gd.get(i).getStartDate());
			g.setProductId(gd.get(i).getProductId());
			g.setBookCount(gd.get(i).getBookCount());
			g.setTotalCount(gd.get(i).getTotalCount());
			gb.add(g);
		}
		this.mav.addObject("groupList", gb);
		this.mav.setViewName(this.preMobile(request) + "custom/groupList");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		return this.mav;
	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView book(HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 4);
		ShowProductInfo[] ps = this.orderMgrService.getProductList(3, 0);

		this.mav.addObject("productList", ps);
		this.mav.setViewName(this.preMobile(request) + "custom/book");
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		List<GroupDate> gs = this.customService.getGroupList("", 0);
		for (int i = 0; gs != null && i < gs.size(); i++) {
			String startDate = gs.get(i).getStartDate();
			String[] d = startDate.split("-");

			gs.get(i).setStartDate(
			/* d[0] + "年" + */d[1] + "月" + d[2] + "日");

			gs.get(i).setGroupDate(startDate);
		}
		this.mav.addObject("groupList", gs);
		return this.mav;
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView order(HttpServletRequest request,
			@RequestParam(value = "productID", required = false) int pid,
			@RequestParam(value = "orderId", required = false) String orderId,
			@RequestParam(value = "gdate", required = false) String gDate) {
		this.getMav(request);
		this.mav.setViewName(this.preMobile(request) + "custom/order");

		// this.mav.addObject("totalCount", 2);
		this.mav.addObject("childrenCount", 0);
		this.mav.addObject("childrenBedsCount", 0);
		this.mav.addObject("oldCount", 0);
		this.mav.addObject("adultCount", 2);
		this.mav.addObject("startDate", gDate);
		if (orderId != null) {
			OrderInfo oi = this.orderMgrService.getOrders(orderId);
			if (oi != null) {
				this.mav.addObject("startDate", oi.getArriveDate());
				this.mav.addObject("totalCount", oi.getAmount());
				this.mav.addObject("childrenCount", oi.getChildrenCount());
				this.mav.addObject("childrenBedsCount",
						oi.getChildrenBedsCount());
				this.mav.addObject("oldCount", oi.getOldCount());
				this.mav.addObject("adultCount", oi.getAdultCount());
				pid = oi.getProductId();
			}
		}
		this.mav.addObject("pid", pid);
		ProductDetail pd = this.orderMgrService.getProductInfo(pid);
		this.mav.addObject("productName", pd.getProductInfo().getProductName());
		this.mav.addObject("salePrice", pd.getPrice().getLowPrice() / 100);
		this.mav.addObject("offPrice", pd.getPrice().getOffPrice() / 100);
		this.mav.addObject("menuIndex", 4);
		return mav;
	}

	@RequestMapping(value = { "order/save" }, method = RequestMethod.POST)
	@ResponseBody
	public String orderSave(
			HttpServletRequest request,
			@RequestParam(value = "productID", required = true) int pid,
			@RequestParam(value = "orderId", required = true) String orderId,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "userMobile", required = true) String userMobile,
			@RequestParam(value = "oldCount", required = true) int oldCount,
			@RequestParam(value = "adultCount", required = true) int adultCount,
			@RequestParam(value = "childrenBedsCount", required = true) int childrenBedsCount,
			@RequestParam(value = "childrenCount", required = true) int childrenCount,
			@RequestParam(value = "startDate", required = true) String startDate) {

		String uname = "";
		// SecurityContextHolder.getContext().getAuthentication().getName();
		ProductDetail pd = this.orderMgrService.getProductInfo(pid);
		if (pd.getProductInfo() != null) {
			int totalCount = oldCount + adultCount + childrenCount;
			orderId = this.orderMgrService.saveOrder(orderId, pd, userName,
					userMobile, totalCount, childrenCount, oldCount,
					adultCount, childrenBedsCount, startDate, uname, "",
					"weixin");
			try {
				this.getProxy().sendSMS(
						"客户您好，您已经成功预订‘" + pd.getProductInfo().getProductName()
								+ "’，订单号:" + orderId + ",参团人数：" + totalCount
								+ "人，出发日期:" + startDate + "。", userMobile);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				orderId = "-1";
			}
		} else {
			orderId = "0";
		}
		return orderId;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request) {
		this.getMav(request);
		this.mav.addObject("menuIndex", 5);
		this.mav.addObject("isMobile", CommonUtils.IsMobile(request));
		this.mav.setViewName(this.preMobile(request) + "custom/about");
		return this.mav;
	}

}
