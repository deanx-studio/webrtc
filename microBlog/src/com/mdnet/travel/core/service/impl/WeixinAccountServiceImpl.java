package com.mdnet.travel.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.mdnet.travel.core.dao.WeixinAccountDAO;
import com.mdnet.travel.core.dao.WeixinOrderDAO;
import com.mdnet.travel.core.dao.WeixinProductDAO;
import com.mdnet.travel.core.model.WeixinAccount;
import com.mdnet.travel.core.model.WeixinOrder;
import com.mdnet.travel.core.model.WeixinProduct;
import com.mdnet.travel.core.service.IWeixinAccountService;

@Service(IWeixinAccountService.SERVICE_NAME)
@Scope("prototype")
@Transactional(readOnly = true)
public class WeixinAccountServiceImpl implements IWeixinAccountService {

	@Resource(name = WeixinAccountDAO.DAO_NAME)
	protected WeixinAccountDAO wxAccountDAO;

	@Resource(name = WeixinOrderDAO.DAO_NAME)
	protected WeixinOrderDAO wxOrderDAO;
	
	@Resource(name = WeixinProductDAO.DAO_NAME)
	protected WeixinProductDAO wxProductDAO;

	@Override
	public WeixinAccount getWeixinAccount(int wxAccountId) {
		return this.wxAccountDAO.findById(wxAccountId);
	}

	@Override
	public List<WeixinAccount> getWexinAccounts(int pageNo) {
		return this.wxAccountDAO.findAll(pageNo);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int saveWeixin(String id, String wxName, String wxFromUserName,
			String wxAccount, int wxType, String appId, String appSecret) {
		WeixinAccount weixinAccount = null;
		if (id != null && id.length() > 0 && Integer.parseInt(id) > 0)
			weixinAccount = this.wxAccountDAO.findById(Integer.parseInt(id));
		else
			weixinAccount = new WeixinAccount();
		// 设置属性值
		if (weixinAccount != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			weixinAccount.setMakeTime(sdf.format(new Date()));
			weixinAccount.setWxAccount(wxAccount);
			weixinAccount.setWxFromUserName(wxFromUserName);
			weixinAccount.setWxName(wxName);
			weixinAccount.setWxType(wxType);
			weixinAccount.setAppId(appId);
			weixinAccount.setAppSecret(appSecret);
		}
		// 更新或者创建数据
		if (id != null && id.length() > 0 && Integer.parseInt(id) > 0)
			this.wxAccountDAO.update(weixinAccount);
		else {
			int newId = this.wxAccountDAO.save(weixinAccount);
			weixinAccount.setAccountId(newId);
		}
		return weixinAccount.getAccountId();
	}

	@Override
	public List<WeixinAccount> getAll(int pageNo) {
		return this.wxAccountDAO.findAll(pageNo);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int delete(String id) {
		WeixinAccount wxEntity = this.wxAccountDAO.findById(Integer
				.parseInt(id));
		if (wxEntity != null)
			this.wxAccountDAO.delete(wxEntity);
		return 0;
	}

	@Override
	public List<WeixinAccount> findWXAccounts(int pageNo) {
		if (pageNo < 0)
			return this.wxAccountDAO.findAll();
		else
			return null;
	}

	@Override
	public WeixinAccount getWeixinAccountByFromuserName(String wxFromUserName) {
		return this.wxAccountDAO.find(wxFromUserName);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int saveWeixinOrder(WeixinOrder wOrder) {
		return wxOrderDAO.save(wOrder);

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateWeixinOrder(String wxOrderId, String localOrderId) {
		WeixinOrder wxOrder = this.wxOrderDAO.findBywxOrderId(wxOrderId);
		wxOrder.setLocalOrderId(localOrderId);
		wxOrderDAO.update(wxOrder);
	}

	@Override
	public int getLocalProductId(String wxProductId) {
		WeixinProduct p = this.wxProductDAO.getProductInfo(wxProductId);
		if(p != null)
			return p.getLocalProductId();
		else
			return 0;
	}
	
	@Override
	public WeixinProduct WeixinProductInfo(int pid) {
		 return this.wxProductDAO.get(pid);
	}
	
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public int addProductToWeixin(int localProductId) {
		WeixinProduct p = new WeixinProduct();
		p.setLocalProductId(localProductId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		p.setMakeTime(sdf.format(new Date()));
		p.setProductPrice(0);
		p.setSku("");
		p.setWeixinProductId("");
		return this.wxProductDAO.save(p);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateWeixinProduct(WeixinProduct p) {
		this.wxProductDAO.update(p);
	}
	

}
