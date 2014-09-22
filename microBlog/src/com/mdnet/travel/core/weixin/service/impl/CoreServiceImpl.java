package com.mdnet.travel.core.weixin.service.impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.zhinet.travel.pojo.reqandrespojo.Order_CreateRes;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmRes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.Customer;
import com.mdnet.travel.core.model.Traveler;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.model.WeixinOrder;
import com.mdnet.travel.core.service.IMessageService;
import com.mdnet.travel.core.service.ITravelerService;
import com.mdnet.travel.core.service.IWeixinAccountService;
import com.mdnet.travel.core.service.ProxyService;
import com.mdnet.travel.core.service.WeixinReplyProxy;
import com.mdnet.travel.core.service.impl.MessageServiceImpl;
import com.mdnet.travel.core.utils.FileOperationUtil;
import com.mdnet.travel.core.utils.ProcessMessageUtil;
import com.mdnet.travel.core.weixin.message.resp.NewsMessage;
import com.mdnet.travel.core.weixin.message.resp.OrderInfoMessage;
import com.mdnet.travel.core.weixin.message.resp.TextMessage;
import com.mdnet.travel.core.weixin.pojo.AccessToken;
import com.mdnet.travel.core.weixin.pojo.Article;
import com.mdnet.travel.core.weixin.service.CoreService;
import com.mdnet.travel.core.weixin.service.TodayInHistoryService;
import com.mdnet.travel.core.weixin.utils.MessageUtil;
import com.mdnet.travel.core.weixin.utils.WeixinUtils;

/**
 * 核心服务类
 * 
 * @author ldy
 */
@Service(CoreService.SERVICE_NAME)
@Scope("prototype")
public class CoreServiceImpl implements CoreService {

	private static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

	@Resource(name = TodayInHistoryService.SERVICE_NAME)
	protected TodayInHistoryService todayInHistoryService;

	@Resource(name = IMessageService.SERVICE_NAME)
	protected IMessageService messageService;

	@Resource(name = ITravelerService.SERVICE_NAME)
	protected ITravelerService travelerService;

	@Resource(name = WeixinReplyProxy.SERVICE_NAME)
	protected WeixinReplyProxy proxy;

	@Resource(name = IWeixinAccountService.SERVICE_NAME)
	protected IWeixinAccountService wxAccountService;

	@Resource(name = "constant")
	protected Constant myConstant;

	private ProxyService proxyService = null;

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {

		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			log.info("发送方账号为：" + fromUserName + ",发送内容:"
					+ requestMap.get("Content") + ",MsgType:"
					+ requestMap.get("MsgType"));

			// 保存数据
			this.saveMessage(requestMap);

			// 处理消息
			return this.handleMessage(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "消息解析异常";

	}

	protected ProxyService getProxy() {
		if (proxyService == null)
			proxyService = new ProxyService(myConstant);
		return proxyService;
	}

	private String handleMessage(Map<String, String> requestMap) {

		String fromUserName = requestMap.get("FromUserName");
		String toUserName = requestMap.get("ToUserName");
		String msgType = requestMap.get("MsgType");
		String createTime = requestMap.get("CreateTime");
		String content = "";
		String msgId = requestMap.get("MsgId");
		String mobile = this.getMobile(fromUserName);
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
			content = requestMap.get("Content");
			log.info("用户：" + fromUserName + ",发送文本消息:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, content);

		}
		// 图片消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			content = requestMap.get("PicUrl");
			log.info("用户：" + fromUserName + ",发送图片:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, content);
		}
		// 地理位置消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			content = "Location_X:" + requestMap.get("Location_X")
					+ ";Location_Y:" + requestMap.get("Location_Y");
			// http://api.map.baidu.com/geocoder?output=json&location=39.983424,%20116.322987&key=6N9HU22PSi8RorCrFlVolhsX
			log.info("用户：" + fromUserName + ",发送地理位置:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, content);
		}
		// 链接消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			content = requestMap.get("PicUrl");
			log.info("用户：" + fromUserName + ",发送链接:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, content);
		}
		// 音频消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
			content = requestMap.get("Recognition");
			log.info("用户：" + fromUserName + ",发送语音:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, content);
		}
		// 事件推送
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			return handleEvent(requestMap, fromUserName, toUserName, msgType,
					createTime, msgId, mobile, eventType);
		} else {
			log.info("用户：" + fromUserName + ",发送语音:" + content);
			return handleTextMessage(fromUserName, toUserName, msgType,
					createTime, msgId, mobile, "未知消息类型错误。");
		}
	}

	private String handleEvent(Map<String, String> requestMap,
			String fromUserName, String toUserName, String msgType,
			String createTime, String msgId, String mobile, String eventType) {

		log.info("用户：" + fromUserName + ",事件类型:" + eventType);
		// 订阅
		if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			this.messageService.subscribe(requestMap);
			// String respContent = "亲，您咋才来呢。小旅想你了...";
			return handleEvent(fromUserName, toUserName, msgType, createTime,
					msgId, "1");
		}
		// 取消订阅
		else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			this.messageService.unSubscribe(requestMap);
			// String respContent = "亲，您咋才来呢。小旅想你了...";
			return handleEvent(fromUserName, toUserName, msgType, createTime,
					msgId, "2");

		} else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
			// this.messageService.unSubscribe(requestMap);
			return this.handleLocation(fromUserName, toUserName, createTime,
					msgId, requestMap.get("Latitude"),
					requestMap.get("Longitude"), requestMap.get("Precision"));
		}
		// 自定义菜单点击事件
		else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
			// 事件KEY值，与创建自定义菜单时指定的KEY值对应
			String eventKey = requestMap.get("EventKey");

			return handleEvent(fromUserName, toUserName, msgType, createTime,
					msgId, eventKey);

		} else if (eventType.equals(MessageUtil.EVENT_TYPE_MERCHANT_ORDER)) {
			return this.handleOrder(fromUserName, toUserName, createTime,
					msgId, requestMap.get("OrderId"),
					requestMap.get("OrderStatus"), requestMap.get("ProductId"),
					requestMap.get("SkuInfo"));
		} else {
			return this.textMessage(fromUserName, toUserName, msgType,
					createTime, msgId, "未知的事件类型");
		}

	}

	private String handleOrder(String fromUserName, String toUserName,
			String createTime, String msgId, String orderId,
			String orderStatus, String productId, String skuInfo) {
		log.info(String
				.format("handleOrder, fromUserName=%s, toUserName=%s, createTime=%s, msgId=%s, orderId=%s, orderStatus=%s, productId=%s, skuInfo=%s",
						fromUserName, toUserName, createTime, msgId, orderId,
						orderStatus, productId, skuInfo));
		// 获取订单详情
		OrderInfoMessage orderDetail = GetOrderDetail(toUserName, orderId);
		if (orderDetail.getErrcode() != 0) {
			log.error("order id:" + orderId
					+ " detail infomation got fail, errorcode:"
					+ orderDetail.getErrcode() + ",errmsg:"
					+ orderDetail.getErrmsg());
		}
		// 保存订单详细数据
		saveWeixinOrder(orderDetail);
		// 下单并支付
		try {
			if (CreateOrderAndPay(orderDetail) == 0) {
				// 发送通知消息
				// Weixin
				// 改为已经发货
			}
		} catch (RemoteException e) {
			log.error("下单、支付时发生异常，" + e.getMessage());
			e.printStackTrace();
		}

		return "success";
	}

	public OrderInfoMessage GetOrderDetail(String toUserName, String orderId) {
		WeixinAccount acc = this.wxAccountService
				.getWeixinAccountByFromuserName(toUserName);
		String appId = acc.getAppId();
		String appSecret = acc.getAppSecret();
		OrderInfoMessage orderDetail = null;
		for (int i = 0; i < 2; i++) {
			AccessToken access_token = WeixinUtils.getAccessToken(appId,
					appSecret);
			orderDetail = WeixinUtils.getOrderInfo(access_token.getToken(),
					orderId);
			if (orderDetail != null && orderDetail.getErrcode() == 0)
				break;
		}
		return orderDetail;
	}

	protected int CreateOrderAndPay(OrderInfoMessage orderInfo)
			throws RemoteException {

		// 获得对应的产品编码
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String mobile = orderInfo.getReceiver_mobile();
		// 当前时间加一天
		Long wxTime = (long) orderInfo.getOrder_create_time() * 1000;
		Date createDate = new Date(wxTime + 1 * 24 * 60 * 60 * 1000);
		String startDate = sdf.format(createDate);

		String userName = orderInfo.getReceiver_name();
		int orderNum = orderInfo.getProduct_count();
		// 获取产品信息
		int ticketId = this.wxAccountService.getLocalProductId(orderInfo
				.getProduct_id());
		if (ticketId <= 0) {
			log.error(String.format("未找到微信产品：%s对应的产品编码",
					orderInfo.getProduct_id()));
			return -1;
		}
		Date defaultEndDate = new Date(wxTime + 15 * 24 * 60 * 60 * 1000);
		String endDate = sdf.format(defaultEndDate);
		String ticketName = orderInfo.getProduct_name() + "[微信]";

		int gatType = 0;
		int linkCreditType = 0;

		Order_CreateRes resp = null;

		resp = getProxy().orderCreateRes(mobile, startDate, endDate, userName,
				String.valueOf(orderNum), String.valueOf(ticketId), gatType,
				linkCreditType, ticketName);

		if (resp == null || resp.getOrderId().length() == 0) {
			log.error(String
					.format("下单失败，手机号：%s，开始日期：%s,截止日期：%s,用户名称:%s,订单数：%d,产品ID：%d，产品名称:%s",
							mobile, startDate, endDate, userName, orderNum,
							ticketId, ticketName));
			return -2;
		}
		this.wxAccountService.updateWeixinOrder(orderInfo.getOrder_id(),
				(resp == null ? "" : resp.getOrderId()));
		// 支付
		Order_Pay_ConfirmReq orderPayConfirmReq = new Order_Pay_ConfirmReq();

		orderPayConfirmReq.setOrderId((resp == null ? "" : resp.getOrderId()));
		orderPayConfirmReq.setPayDate(startDate);
		orderPayConfirmReq.setPayMoney((resp == null ? "" : resp
				.getCustomerPayMoney()));
		orderPayConfirmReq.setPayOrderId(orderInfo.getTrans_id());
		orderPayConfirmReq.setPayType(0);
		orderPayConfirmReq
				.setRequestHead(ProcessMessageUtil.getHead(
						this.myConstant.getWX_MSGSOURCE(),
						this.myConstant.getWX_KEY()));

		Order_Pay_ConfirmRes confirm = getProxy().OrderPayConfirm(
				orderPayConfirmReq);
		if (confirm != null && confirm.getResponseHead().getResultCode() == 0) {
			log.info("支付成功，订单号:" + resp.getOrderId());
		} else {
			log.error(String.format("订单%s支付失败，错误原因：%s", resp.getOrderId(),
					(confirm == null ? "支付接口返回空" : confirm.getResponseHead()
							.getResultMsg())));
			return -3;//支付失败
		}

		return 0;

	}

	private void saveWeixinOrder(OrderInfoMessage orderInfo) {
		WeixinOrder wOrder = new WeixinOrder();
		wOrder.setBuyerNick(orderInfo.getBuyer_nick());
		wOrder.setBuyerOpenid(orderInfo.getBuyer_openid());
		wOrder.setDeliveryCompany(orderInfo.getDelivery_company());
		wOrder.setDeliveryId(orderInfo.getDelivery_id());
		wOrder.setOrderCreateTime(orderInfo.getOrder_create_time());
		wOrder.setOrderExpressPrice(orderInfo.getOrder_express_price());
		wOrder.setLocalOrderId("0");
		wOrder.setOrderStatus(orderInfo.getOrder_status());
		wOrder.setOrderTotalPrice(orderInfo.getOrder_total_price());
		wOrder.setProductCount(orderInfo.getProduct_count());
		wOrder.setProductId(orderInfo.getProduct_id());
		wOrder.setProductImg(orderInfo.getProduct_img());
		wOrder.setProductName(orderInfo.getProduct_name());
		wOrder.setProductPrice(orderInfo.getProduct_price());
		wOrder.setProductSku(orderInfo.getProduct_sku());
		wOrder.setReceiverAddress(orderInfo.getReceiver_address());
		wOrder.setReceiverCity(orderInfo.getReceiver_city());
		wOrder.setReceiverMobile(orderInfo.getReceiver_mobile());
		wOrder.setReceiverName(orderInfo.getReceiver_name());
		wOrder.setReceiverPhone(orderInfo.getReceiver_phone());
		wOrder.setReceiverProvince(orderInfo.getReceiver_province());
		wOrder.setTransId(orderInfo.getTrans_id());
		wOrder.setWeixinOrderId(orderInfo.getOrder_id());

		this.wxAccountService.saveWeixinOrder(wOrder);

	}

	private String handleLocation(String fromUserName, String toUserName,
			String createTime, String msgId, String latitude, String longitude,
			String precision) {
		log.info(String.format(
				"fromUserName=%s, toUserName=%s, latitude=%s,longitude=%s",
				fromUserName, toUserName, latitude, longitude));
		this.messageService.updateLocation(fromUserName, toUserName, latitude,
				longitude);
		return "";

	}

	// 处理微信事件
	public String handleEvent(String fromUserName, String toUserName,
			String msgType, String createTime, String msgId, String eventKey) {
		List<Article> articleList = this.proxy
				.getArticles(eventKey, toUserName);
		log.info("用户：" + fromUserName + ",查询相关数据:" + eventKey);
		if (articleList != null && articleList.size() > 0) {
			if (articleList.get(0).getPicUrl().length() > 0) {
				log.info("用户：" + fromUserName + ",查询到文字消息,Key:" + eventKey
						+ ",图文消息数量:" + articleList.size());
				return this.newsMessage(fromUserName, toUserName, msgType,
						createTime, msgId, articleList);
			} else {
				log.info("用户：" + fromUserName + ",查询到文字消息,Key:" + eventKey
						+ ",文本消息内容:" + articleList.get(0).getDescription());
				return this.textMessage(fromUserName, toUserName, msgType,
						createTime, msgId, articleList.get(0).getDescription());
			}
		} else {
			log.info("用户：" + fromUserName + ",查询数据为空,Key:" + eventKey);
			return textMessage(fromUserName, toUserName, msgType, createTime,
					msgId, "系统忙，请稍候再试！");
		}
	}

	private String textMessage(String fromUserName, String toUserName,
			String msgType, String createTime, String msgId, String content) {
		// 回复文本消息
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		log.info("用户：" + fromUserName + ",生成文本消息:" + content);
		textMessage.setContent(content);
		return MessageUtil.textMessageToXml(textMessage);
	}

	private String newsMessage(String fromUserName, String toUserName,
			String msgType, String createTime, String msgId,
			List<Article> articleList) {
		// 回复图文消息 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		NewsMessage newsMessage = new NewsMessage();
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessage.setFuncFlag(0);

		// 将客户的openID带到图文消息里，客户点击时页面带回到请求页面
		for (int i = 0; i < articleList.size(); i++) {
			String url = articleList.get(i).getUrl();
			if (url.indexOf('?') < 0)
				articleList.get(i).setUrl(
						url + "?openid=" + fromUserName + "&wid="
								+ articleList.get(i).getWid());
			else
				articleList.get(i).setUrl(
						url + "&openid=" + fromUserName + "&wid="
								+ articleList.get(i).getWid());
		}
		// 设置图文消息个数
		newsMessage.setArticleCount(articleList.size());
		// 设置图文消息包含的图文集合
		newsMessage.setArticles(articleList);
		// 将图文消息对象转换成xml字符串
		return MessageUtil.newsMessageToXml(newsMessage);
	}

	private String newsMessage(String fromUserName, String toUserName,
			String msgType, String createTime, String msgId, String keys) {

		List<Article> articleList = this.proxy.getArticles(keys, toUserName);

		return this.newsMessage(fromUserName, toUserName, msgType, createTime,
				msgId, articleList);
	}

	private String handleTextMessage(String fromUserName, String toUserName,
			String msgType, String createTime, String msgId, String mobile,
			String content) {

		WeixinAccount acc = this.wxAccountService
				.getWeixinAccountByFromuserName(toUserName);
		if (acc.getWxType() == 1) {// 服务号
			// 交给客服处理
			return transferCustomer(fromUserName, toUserName, createTime);
		} else {
			return this.newsMessage(fromUserName, toUserName, msgType,
					createTime, msgId, "6");
		}

	}

	public String transferCustomer(String fromUserName, String toUserName,
			String createTime) {
		String kefu = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName>"
				+ "<CreateTime>%s</CreateTime><MsgType><![CDATA[transfer_customer_service]]></MsgType></xml>";
		return String.format(kefu, toUserName, fromUserName, createTime);
	}

	private String getMobile(String fromUserName) {
		Traveler traveler = this.travelerService.findFromUserName(fromUserName);
		if (traveler != null)
			return traveler.getMobile();
		else
			return "";
	}

	/**
	 * 处理请求
	 * 
	 * @param requestMap
	 */
	public void saveMessage(Map<String, String> requestMap) {
		String account = requestMap.get(MessageUtil.REQ_MESSAGE_ACCOUNT);
		Customer cus = this.messageService.findByAccount(account);
		if (null != cus) {
			this.messageService.saveMessage(requestMap, cus);
			this.messageService.updateCustomer(cus, requestMap);
		} else {
			this.messageService.addCustomer(requestMap);
			Customer cusN = this.messageService.findByAccount(account);
			this.messageService.saveMessage(requestMap, cusN);
			this.messageService.updateCustomer(cusN, requestMap);
		}
	}
}