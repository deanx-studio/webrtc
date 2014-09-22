package com.mdnet.travel.core.service;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.zhinet.travel.inf.impl.CommonToolsProxy;
import net.zhinet.travel.inf.impl.MarketActiveImplProxy;
import net.zhinet.travel.inf.impl.MediaResourcesImplProxy;
import net.zhinet.travel.inf.impl.OrderManageImplProxy;
import net.zhinet.travel.inf.impl.PersonedCentralImplProxy;
import net.zhinet.travel.inf.impl.ScenicTicketImplProxy;
import net.zhinet.travel.pojo.basepojo.CatalogDef;
import net.zhinet.travel.pojo.basepojo.Complaint;
import net.zhinet.travel.pojo.basepojo.OrderInfo;
import net.zhinet.travel.pojo.basepojo.RequestHead;
import net.zhinet.travel.pojo.basepojo.ScenicInfo;
import net.zhinet.travel.pojo.basepojo.TicketInfo;
import net.zhinet.travel.pojo.reqandrespojo.CatalogListReq;
import net.zhinet.travel.pojo.reqandrespojo.Catalog_InfoRes;
import net.zhinet.travel.pojo.reqandrespojo.ComplaintDetailReq;
import net.zhinet.travel.pojo.reqandrespojo.ComplaintDetailRes;
import net.zhinet.travel.pojo.reqandrespojo.ComplaintReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_CreateReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_CreateRes;
import net.zhinet.travel.pojo.reqandrespojo.Order_ListReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_ListRes;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmReq;
import net.zhinet.travel.pojo.reqandrespojo.Order_Pay_ConfirmRes;
import net.zhinet.travel.pojo.reqandrespojo.PriceCanledarReq;
import net.zhinet.travel.pojo.reqandrespojo.PriceCanledarRes;
import net.zhinet.travel.pojo.reqandrespojo.SMSReq;
import net.zhinet.travel.pojo.reqandrespojo.SMSResp;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_CatalogReq;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_DetailReq;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoReq;
import net.zhinet.travel.pojo.reqandrespojo.Ticket_InfoRes;
import net.zhinet.travel.pojo.reqandrespojo.ViewDetailReq;
import net.zhinet.travel.pojo.reqandrespojo.ViewDetailRes;
import net.zhinet.travel.pojo.reqandrespojo.View_CommentReq;
import net.zhinet.travel.pojo.reqandrespojo.View_CommentRes;
import net.zhinet.travel.pojo.reqandrespojo.View_InfoReq;
import net.zhinet.travel.pojo.reqandrespojo.View_InfoRes;

import org.apache.commons.lang3.StringUtils;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.utils.ProcessMessageUtil;
import com.mdnet.travel.core.utils.SimpleDateUtil;
import com.mdnet.travel.core.vo.ComplaintBean;

public class ProxyService {

	protected Constant myConstant;

	public Constant getMyConstant() {
		return myConstant;
	}

	public ProxyService(Constant myConstant) {
		this.myConstant = myConstant;
		init();
	}

	public void setMyConstant(Constant myConstant) {
		this.myConstant = myConstant;
		init();

	}

	public void init() {
		if (this.myConstant == null)
			return;
		msgSource = this.myConstant.getWX_MSGSOURCE();
		msgKey = this.myConstant.getWX_KEY();
		InterfaceEndPoint = this.myConstant.getEND_POINT();
	}

	protected ScenicTicketImplProxy getScenicTicket() {
		if (_scenicTicket == null) {
			_scenicTicket = new ScenicTicketImplProxy();
			_scenicTicket.setEndpoint(InterfaceEndPoint
					+ "ScenicTicketImpl?wsdl");
		}
		return this._scenicTicket;
	}

	protected OrderManageImplProxy getOrderManage() {
		if (_orderManage == null) {
			_orderManage = new OrderManageImplProxy();
			_orderManage
					.setEndpoint(InterfaceEndPoint + "OrderManageImpl?wsdl");
		}
		return this._orderManage;
	}

	protected MarketActiveImplProxy getMarketActive() {
		if (_marketActive == null) {
			_marketActive = new MarketActiveImplProxy();
			_marketActive.setEndpoint(InterfaceEndPoint
					+ "MarketActiveImpl?wsdl");
		}
		return this._marketActive;
	}

	protected PersonedCentralImplProxy getPersonedCentral() {
		if (_personedCentral == null) {
			_personedCentral = new PersonedCentralImplProxy();
			_personedCentral.setEndpoint(InterfaceEndPoint
					+ "PersonedCentralImpl?wsdl");
		}
		return this._personedCentral;
	}

	protected MediaResourcesImplProxy getMediaResourcesImplProxy() {
		if (_mediaResourcesImplProxy == null) {
			_mediaResourcesImplProxy = new MediaResourcesImplProxy();
			_mediaResourcesImplProxy.setEndpoint(InterfaceEndPoint
					+ "MediaResourcesImpl?wsdl");
		}
		return this._mediaResourcesImplProxy;
	}

	protected CommonToolsProxy getCommonTools() {
		if (this._commonTools == null) {
			this._commonTools = new CommonToolsProxy();
			this._commonTools
					.setEndpoint(InterfaceEndPoint
							+ "CommonTools?wsdl");
		}
		return this._commonTools;
	}

	protected ScenicTicketImplProxy _scenicTicket = null;
	protected OrderManageImplProxy _orderManage = null;
	protected MarketActiveImplProxy _marketActive = null;
	protected PersonedCentralImplProxy _personedCentral = null;
	protected CommonToolsProxy _commonTools = null;
	protected MediaResourcesImplProxy _mediaResourcesImplProxy = null;

	protected String msgSource = "";
	protected String msgKey = "";
	protected String InterfaceEndPoint = "";

	// static {
	// msgSource = ProxyService.myConstant.getWX_MSGSOURCE();
	// msgKey = ProxyService.myConstant.getWX_KEY();
	// String InterfaceEndPoint = ProxyService.myConstant.getEND_POINT();
	// scenicTicket.setEndpoint(InterfaceEndPoint + "ScenicTicketImpl?wsdl");
	// orderManage.setEndpoint(InterfaceEndPoint + "OrderManageImpl?wsdl");
	// marketActive.setEndpoint(InterfaceEndPoint + "MarketActiveImpl?wsdl");
	// personedCentral.setEndpoint(InterfaceEndPoint
	// + "PersonedCentralImpl?wsdl");
	// mediaResourcesImplProxy.setEndpoint(InterfaceEndPoint
	// + "MediaResourcesImpl?wsdl");
	//
	// // http://192.168.1.101:8080/travel-interface/services/CommonTools?wsdl
	// // Constant.END_POINT + "CommonTools?wsdl"bob8.cn
	// commonTools
	// .setEndpoint("http://bob8.cn:8080/travel-interface/services/CommonTools?wsdl");
	// // commonTools.setEndpoint(tempURL);
	// }

	/**
	 * 获取门票列表
	 * 
	 * @param cityName
	 * @param proviceName
	 *            现在被用作关键字搜索的关键字，关键字可以包含在景区名称中，也可以包含在产品名称中
	 * @param pageNo
	 * @return
	 * @throws RemoteException
	 */
	public TicketInfo[] listProducts(String cityName, String proviceName,
			int pageNo) throws RemoteException {
		Ticket_InfoReq ticket_InfoReq = new Ticket_InfoReq(cityName, 20,
				pageNo, proviceName, getReqHead());
		Ticket_InfoRes tis = getScenicTicket().ticket_info(ticket_InfoReq);
		return tis.getScenicTickets();
	}

	public Ticket_InfoRes productDetail(String pid) {
		Ticket_DetailReq req = new Ticket_DetailReq();
		req.setRequestHead(getReqHead());
		req.setTicketId(pid);
		try {
			return getScenicTicket().ticket_detail(req);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public View_InfoRes ScenicInfo(int scenicId) {
		View_InfoReq view_InfoReq = new View_InfoReq(getReqHead(), scenicId);
		try {
			return getScenicTicket().view_info(view_InfoReq);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取产品分类列表
	 * 
	 * @return
	 */
	public CatalogDef[] catalogList() {
		CatalogListReq catalogListReq = new CatalogListReq();
		try {

			catalogListReq.setRequestHead(getReqHead());

			Catalog_InfoRes resp = getScenicTicket().catalog_info(
					catalogListReq);
			return resp.getCataloglist();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public TicketInfo[] getTicketsByCatalog(int catalogId, int pageNo) {
		Ticket_CatalogReq ticket_catalogReq = new Ticket_CatalogReq();
		ticket_catalogReq.setRequestHead(getReqHead());
		ticket_catalogReq.setPageCount(20);
		ticket_catalogReq.setPageNo(pageNo);
		ticket_catalogReq.setCatalogId(catalogId);

		try {
			Ticket_InfoRes resp = getScenicTicket().ticket_catalog(
					ticket_catalogReq);
			return resp.getScenicTickets();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 发送验证码
	 * 
	 * @param validCode
	 * @param mobile
	 * @throws RemoteException
	 */
	public Boolean sendSMS(String validCode, String mobile)
			throws RemoteException {
		// new SMSReq(content, destMobile, requestHead, smsType)
		Boolean flag = false;
		// TODO smsType 具体待定
		SMSReq smsReq = new SMSReq(validCode, mobile, getReqHead(), 0);
		SMSResp smsResp = getCommonTools().sendSMS(smsReq);// SMSResp
		// smsResp.get//0:成功
		if (0 == smsResp.getResponseHead().getResultCode()) {
			flag = true;
		}
		return flag;
	}

	public TicketInfo[] list(String cityName) throws RemoteException {
		Ticket_InfoReq ticket_InfoReq = new Ticket_InfoReq(cityName, 3, 1,
				null, getReqHead());
		Ticket_InfoRes tis = getScenicTicket().ticket_info(ticket_InfoReq);
		return tis.getScenicTickets();
	}

	protected RequestHead getReqHead() {
		return ProcessMessageUtil.getHead(msgSource, msgKey);
	}

	/**
	 * 根据一个景区id找到下面的门票
	 * 
	 * TODO 留意一个问题，这儿根据景区id返回的是一个数组，这在目前并没处理这问题，后期有可能的bug
	 * 
	 * @param scenicId
	 * @return
	 * @throws RemoteException
	 */
	public TicketInfo[] getTicketsByScenicId(Integer scenicId,
			StringBuilder scenicName) throws RemoteException {
		TicketInfo[] ticketList = null;
		View_InfoReq view_InfoReq = new View_InfoReq(getReqHead(), scenicId);
		View_InfoRes view_InfoRes = getScenicTicket().view_info(view_InfoReq);

		ScenicInfo[] scenicList = null;
		if (null != view_InfoRes) {
			scenicList = view_InfoRes.getScenicDetail();
			if (null != scenicList) {
				scenicName.append(view_InfoRes.getScenicDetail()[0]
						.getScenicName());
				for (ScenicInfo scenic : scenicList) {
					ticketList = scenic.getScenicTickets();
				}
			}
		}
		return ticketList;
	}

	/***
	 * 
	 * 根据景区ID查询该景区详情
	 * 
	 * @param scenicId
	 * @return
	 * @throws RemoteException
	 */

	public ViewDetailRes getViewDetail(String scenicId) throws RemoteException {

		ViewDetailReq viewDetailReq = new ViewDetailReq();
		viewDetailReq.setRequestHead(getReqHead());
		viewDetailReq.setTicketId("");
		viewDetailReq.setViewId(scenicId);

		ViewDetailRes viewDetailRes = null;

		viewDetailRes = getMediaResourcesImplProxy().get_view_detail(
				viewDetailReq);

		return viewDetailRes;
	}

	/**
	 * 
	 * 
	 * 根据日期查询价格
	 * 
	 * @param startDate
	 * @param endDate
	 * @param productNo
	 * @return
	 * @throws RemoteException
	 */
	public PriceCanledarRes getPriceByDate(String startDate, String endDate,
			int productNo) throws RemoteException {

		PriceCanledarReq priceCaledarReq = new PriceCanledarReq();

		priceCaledarReq.setRequestHead(getReqHead());
		priceCaledarReq.setTravelDate(startDate);
		priceCaledarReq.setEndTravelDate(endDate);
		priceCaledarReq.setProductNo(productNo);

		PriceCanledarRes priceCanledarRes = null;

		priceCanledarRes = getScenicTicket().priceCanledar(priceCaledarReq);
		// this.scenicTicketImplProxy.priceCanledar
		//
		return priceCanledarRes;
	}

	/**
	 * 
	 * 
	 * 根据票ID查询具体产品信息
	 * 
	 * @param ticketId
	 * @return
	 * @throws RemoteException
	 */
	public Ticket_InfoRes getTicketDetail(String ticketId)
			throws RemoteException {

		Ticket_DetailReq ticket_DetailReq = new Ticket_DetailReq();

		ticket_DetailReq.setRequestHead(getReqHead());
		ticket_DetailReq.setTicketId(ticketId);

		Ticket_InfoRes ticket_InfoRes = null;

		ticket_InfoRes = getScenicTicket().ticket_detail(ticket_DetailReq);

		return ticket_InfoRes;
	}

	public List<TicketInfo> getTicketByVTID(Integer ticketId, Integer scenicId)
			throws RemoteException {
		List<TicketInfo> targetTicketList = null;
		View_InfoReq view_InfoReq = new View_InfoReq(getReqHead(), scenicId);
		View_InfoRes view_InfoRes = getScenicTicket().view_info(view_InfoReq);
		ScenicInfo[] scenicList = null;
		if (null != view_InfoRes) {
			scenicList = view_InfoRes.getScenicDetail();
			if (null != scenicList) {
				for (ScenicInfo scenic : scenicList) {
					TicketInfo[] ticketList = scenic.getScenicTickets();
					for (TicketInfo ticket : ticketList) {
						if (ticketId.equals(ticket.getTicketId())) {
							targetTicketList = new ArrayList<TicketInfo>();
							targetTicketList.add(ticket);
						}
					}
				}
			}

		}

		return targetTicketList;
	}

	/**
	 * 
	 * @param loginName
	 *            应应用要求，此处应传入手机号
	 * @param orderId
	 * @param pageNo
	 * @return
	 * @throws RemoteException
	 */
	public OrderInfo[] findOrder(String loginName, String orderId,
			Integer pageNo) throws RemoteException {
		Order_ListReq orderListReq = new Order_ListReq(loginName, orderId,
				pageNo, getReqHead());
		Order_ListRes orderListRes = getOrderManage().order_list(orderListReq);
		return orderListRes.getOrderList();
	}

	public Order_ListRes findOrderByOrderId(String orderId) {

		Order_ListReq order_ListReq = new Order_ListReq();

		order_ListReq.setLoginName("");
		order_ListReq.setOrderId(orderId);
		order_ListReq.setPageNo(0);
		order_ListReq.setRequestHead(getReqHead());

		Order_ListRes order_ListRes = null;

		try {
			order_ListRes = getOrderManage().order_list(order_ListReq);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order_ListRes;
	}

	public Order_CreateRes orderCreateRes(String mobile, String startDate,
			String endDate, String userName, String orderNum, String ticketId,
			Integer gatType, Integer linkCreditType, String ticketName)
			throws RemoteException {
		RequestHead head = getReqHead();

		// new Order_CreateReq(channelType, endTravelDate, gatType, linkAddress,
		// linkCreditNo, linkCreditType, linkEmail, linkMan, linkPhone,
		// linkPostCode, msgSerail, orderMemo, orderNum, platformId,
		// requestHead, startTravelDate, ticketId, ticketName)

		Order_CreateReq order_CreateReq = new Order_CreateReq(0, endDate,
				gatType, null, null, linkCreditType, null, userName, mobile,
				null, head.getMsgSerail(), null, Integer.parseInt(orderNum),
				null, head, startDate, ticketId, ticketName);
		return getOrderManage().order_create(order_CreateReq);
	}

	/**
	 * 查找推荐的景区
	 * 
	 * @param cityName
	 *            城市名
	 * @param commentDate
	 *            推荐日期
	 * @param provinceName
	 *            省名
	 * @return
	 * @throws RemoteException
	 */
	public List<ScenicInfo> getRecommendViews(String cityName,
			String commentDate, String provinceName) throws RemoteException {
		View_CommentReq view_req = new View_CommentReq(cityName, commentDate,
				provinceName, getReqHead());
		List<ScenicInfo> viewList = new ArrayList<ScenicInfo>();
		View_CommentRes view_res = getMarketActive().view_comment(view_req);
		if (null != view_res.getScenicInfos()) {
			ScenicInfo[] views = view_res.getScenicInfos();
			for (ScenicInfo view : views) {
				viewList.add(view);
			}
		}
		return viewList;
	}

	/**
	 * 根据指定客户的信息保存投诉信息
	 * 
	 * @param complaint
	 * @throws RemoteException
	 */
	public void saveComplaint(ComplaintBean complaint) throws RemoteException {
		ComplaintReq complaintReq = new ComplaintReq();
		RequestHead requestHead = getReqHead();
		complaintReq.setRequestHead(requestHead);
		complaintReq.setContent(complaint.getContent());
		complaintReq.setCusId(Integer.parseInt(complaint.getPrimaryKey()));
		complaintReq.setOrderNo(complaint.getOrder_no());
		complaintReq.setReply(null);
		complaintReq.setState(StringUtils.isNotBlank(complaint
				.getComplaint_state()) ? Integer.parseInt(complaint
				.getComplaint_state()) : null);
		complaintReq.setSubmitDate(SimpleDateUtil.convert2String(
				SimpleDateUtil.curTimeMillis(), SimpleDateUtil.TIME_FORMAT));
		complaintReq.setType(Integer.parseInt(complaint.getType()));
		getPersonedCentral().saveComplaint(complaintReq);
	}

	/**
	 * 根据客户标识查找投诉信息
	 * 
	 * @param primaryKey
	 * @throws RemoteException
	 */
	public List<Complaint> listComplaint(Integer primaryKey)
			throws RemoteException {
		List<Complaint> complaintList = new ArrayList<Complaint>();

		ComplaintDetailReq complaintDetailReq = new ComplaintDetailReq();
		RequestHead requestHead = getReqHead();
		complaintDetailReq.setPrimaryKey(primaryKey + "");
		complaintDetailReq.setRequestHead(requestHead);
		ComplaintDetailRes complaintDetailRes = getPersonedCentral()
				.listComplaint(complaintDetailReq);
		Complaint[] complaints = complaintDetailRes.getComplaints();
		for (Complaint complaint : complaints) {
			complaintList.add(complaint);
		}

		return complaintList;
	}

	//支付确认
	public Order_Pay_ConfirmRes OrderPayConfirm(
			Order_Pay_ConfirmReq order_Pay_ConfirmReq) throws RemoteException {
		return this.getOrderManage().order_pay_confirm(order_Pay_ConfirmReq);
	}

}
