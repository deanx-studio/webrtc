package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.WeixinProduct;
@Repository(WeixinProductDAO.DAO_NAME)
@Scope("prototype")
public class WeixinProductDAOImpl extends BasicDAOImpl<WeixinProduct> implements
WeixinProductDAO{

	@Override
	public WeixinProduct getProductInfo(String wxProductId) {
		String queryString="from WeixinProduct where weixinProductId=?";
		
		List<WeixinProduct> ps = getHibernateTemplate().find(queryString, wxProductId);
		if(ps != null && ps.size()>0)
			return ps.get(0);
		else
			return null;
	}

}
