package com.mdnet.travel.core.vo;

public class TicketInfoBean extends BasicBean{
	private static final long serialVersionUID = 8347L;
	private Integer ticketId; //景区ID
	private int scenicId; //景区编码,所属的景区ID
	private String ticketName; //价格名称
	private int marketPrice; //窗口价
	private int salePrice; //销售价
	private int rate; //折扣
	private String crowdAsked; //人群要求
	private String proReserve; //产品预订
	private String proDeclare; //产品说明
	private String startValidate; //有效期起始日期
	private String endValidate; //有效期截止日期
	private String ticketMemo; //门票备注说明
	private int cancelFee; //退票费用
	private int changeFee; //改期费用
	private int PreOrderDays; //预订提前天数
	private short isCancel; //是否可退，0:不可退；1：可退
	private short isChange; //是否可退，0，不可改；1：可改
	private String lelekuProductNo; //乐乐酷产品编码，调用乐乐酷接口使用
	private String imgUrl; //图片URL
	private String providerUrl; //供应商URL
	private String distributionPrice; //分销商价格
	private int shelvesState; //是否可卖 0：可卖；1：不可卖
	private String stockPrice; //进货价
	public TicketInfoBean() {
	}
	public TicketInfoBean(Integer ticketId, int scenicId, String ticketName,
			int marketPrice, int salePrice, int rate, String crowdAsked,
			String proReserve, String proDeclare, String startValidate,
			String endValidate, String ticketMemo, int cancelFee,
			int changeFee, int preOrderDays, short isCancel, short isChange,
			String lelekuProductNo, String imgUrl, String providerUrl,
			String distributionPrice, int shelvesState, String stockPrice) {
		super();
		this.ticketId = ticketId;
		this.scenicId = scenicId;
		this.ticketName = ticketName;
		this.marketPrice = marketPrice;
		this.salePrice = salePrice;
		this.rate = rate;
		this.crowdAsked = crowdAsked;
		this.proReserve = proReserve;
		this.proDeclare = proDeclare;
		this.startValidate = startValidate;
		this.endValidate = endValidate;
		this.ticketMemo = ticketMemo;
		this.cancelFee = cancelFee;
		this.changeFee = changeFee;
		PreOrderDays = preOrderDays;
		this.isCancel = isCancel;
		this.isChange = isChange;
		this.lelekuProductNo = lelekuProductNo;
		this.imgUrl = imgUrl;
		this.providerUrl = providerUrl;
		this.distributionPrice = distributionPrice;
		this.shelvesState = shelvesState;
		this.stockPrice = stockPrice;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public int getScenicId() {
		return scenicId;
	}
	public void setScenicId(int scenicId) {
		this.scenicId = scenicId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public int getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getCrowdAsked() {
		return crowdAsked;
	}
	public void setCrowdAsked(String crowdAsked) {
		this.crowdAsked = crowdAsked;
	}
	public String getProReserve() {
		return proReserve;
	}
	public void setProReserve(String proReserve) {
		this.proReserve = proReserve;
	}
	public String getProDeclare() {
		return proDeclare;
	}
	public void setProDeclare(String proDeclare) {
		this.proDeclare = proDeclare;
	}
	public String getStartValidate() {
		return startValidate;
	}
	public void setStartValidate(String startValidate) {
		this.startValidate = startValidate;
	}
	public String getEndValidate() {
		return endValidate;
	}
	public void setEndValidate(String endValidate) {
		this.endValidate = endValidate;
	}
	public String getTicketMemo() {
		return ticketMemo;
	}
	public void setTicketMemo(String ticketMemo) {
		this.ticketMemo = ticketMemo;
	}
	public int getCancelFee() {
		return cancelFee;
	}
	public void setCancelFee(int cancelFee) {
		this.cancelFee = cancelFee;
	}
	public int getChangeFee() {
		return changeFee;
	}
	public void setChangeFee(int changeFee) {
		this.changeFee = changeFee;
	}
	public int getPreOrderDays() {
		return PreOrderDays;
	}
	public void setPreOrderDays(int preOrderDays) {
		PreOrderDays = preOrderDays;
	}
	public short getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(short isCancel) {
		this.isCancel = isCancel;
	}
	public short getIsChange() {
		return isChange;
	}
	public void setIsChange(short isChange) {
		this.isChange = isChange;
	}
	public String getLelekuProductNo() {
		return lelekuProductNo;
	}
	public void setLelekuProductNo(String lelekuProductNo) {
		this.lelekuProductNo = lelekuProductNo;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getProviderUrl() {
		return providerUrl;
	}
	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}
	public String getDistributionPrice() {
		return distributionPrice;
	}
	public void setDistributionPrice(String distributionPrice) {
		this.distributionPrice = distributionPrice;
	}
	public int getShelvesState() {
		return shelvesState;
	}
	public void setShelvesState(int shelvesState) {
		this.shelvesState = shelvesState;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
}
