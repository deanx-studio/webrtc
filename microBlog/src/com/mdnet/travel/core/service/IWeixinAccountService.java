package com.mdnet.travel.core.service;

import java.util.List;

import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.model.WeixinOrder;
import com.mdnet.travel.core.model.WeixinProduct;

public interface IWeixinAccountService {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.WeixinAccountServiceImpl";

	WeixinAccount getWeixinAccount(int wxAccountId);

	List<WeixinAccount> getWexinAccounts(int pageNo);

	int saveWeixin(String id, String wxName, String wxFromUserName,
			String wxAccount, int wxType, String appId, String appSecret);

	List<WeixinAccount> getAll(int pageNo);

	int delete(String id);

	List<WeixinAccount> findWXAccounts(int pageNo);

	WeixinAccount getWeixinAccountByFromuserName(String wxFromUserName);

	int saveWeixinOrder(WeixinOrder wOrder);

	void updateWeixinOrder(String wxOrderId, String localOrderId);

	int getLocalProductId(String wxProductId);

	int addProductToWeixin(int localProductId);

	WeixinProduct WeixinProductInfo(int pid);

	void updateWeixinProduct(WeixinProduct p);
}
