package com.mdnet.travel.core.controller;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.TicketInfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.model.WeixinProduct;
import com.mdnet.travel.core.weixin.pojo.AccessToken;
import com.mdnet.travel.core.weixin.shop.AddProduct;
import com.mdnet.travel.core.weixin.shop.Category;
import com.mdnet.travel.core.weixin.shop.ProductBase;
import com.mdnet.travel.core.weixin.utils.WeixinUtils;

@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {


	@RequestMapping("add/init")
	public String init(@RequestParam(value="ticketId" , required = false) int ticketId)
	{
		int pid = this.wxAccountService.addProductToWeixin(ticketId);
		//消息入库
		return this.REDIRECT+"/shop/category?pid="+pid;
	}
			
	@RequestMapping("add/search")
	public ModelAndView productSearch(
			@RequestParam(value="searchKey" , required = false) String searchKey,
			@RequestParam(value = "pageNo", required = false) String page) {
		if(searchKey==null) searchKey = "";
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
		this.mav.setViewName("shop/add/search");
		return this.mav;
	}

	/**
	 * 旅游出行ID=538372764
	 * 
	 * @param step
	 * @param cateId
	 * @return
	 */
	@RequestMapping("category")
	public ModelAndView getCategory(
			@RequestParam(value = "pid", required = true) int pid,
			@RequestParam(value = "step", required = false) String step,
			@RequestParam(value = "cateId", required = false) String cateId) {
		if(step == null)
			step = "1";
		else
			step = String.valueOf(Integer.parseInt(step)+1);
		if (cateId == null)
			cateId = "538372764";// 从路由出行类开始。默认获取根分类
		this.getMav();
		// 发送请求
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();
		String appSecret = acc.getAppSecret();

		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		List<Category> cates = WeixinUtils.getCategory(access_token.getToken(),
				cateId);
		this.getMav();
		this.mav.addObject("cate_list", cates);
		this.mav.addObject("step", step);
		this.mav.addObject("pid", pid);
		this.mav.setViewName("shop/category2");
		return this.mav;
	}

	@RequestMapping("upMainImg")
	public ModelAndView uploadMainImg(
			@RequestParam(value = "pid", required = true) int pid,
			@RequestParam(value = "cateId", required = false) String cateId)
	{
		WeixinProduct p = this.wxAccountService.WeixinProductInfo(pid);
		p.setCateId(cateId);
		this.wxAccountService.updateWeixinProduct(p);
		this.getMav();
		this.mav.addObject("pid", pid);
		this.mav.setViewName("shop/uploadMainImg");
		return this.mav;
	}
	@RequestMapping("upImg")
	public String upImage()
	{
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();
		String appSecret = acc.getAppSecret();

		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		return WeixinUtils.upImage(access_token.getToken(), "d:/591b85633ef3eebec85bb1f7ff544b6026608050.jpg");
	}
	@RequestMapping("add")
	@ResponseBody
	public String addProduct(
			@RequestParam(value = "pid", required = true) int pid) {
		AddProduct add = new AddProduct();
		// 设置产品数据
		add.setName("自动新增测试");
		add.setMain_img("https://mmbiz.qlogo.cn/mmbiz/ibAcOOL2WI2tso1jtHdbD8NWJkBtib4pxbpwKAmXsbw4lNOfW7aR6iat5CVZBBtKIOice78j9tsbcUScLEAy4RKXibA/0");
		// 设置基本信息

		ProductBase pBase = new ProductBase();
		// pBase.setCategory_id(category_id)
		add.setProduct_base(pBase);

		// 发送请求
		WeixinAccount acc = this.getWeixinAccount();
		String appId = acc.getAppId();
		String appSecret = acc.getAppSecret();

		AccessToken access_token = WeixinUtils.getAccessToken(appId, appSecret);
		String weixinProductId = WeixinUtils.addProduct(
				access_token.getToken(), add);
		// 更新数据库
		return weixinProductId;
	}
}
