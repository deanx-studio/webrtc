package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.WeixinOrder;
import com.mdnet.travel.core.model.WeixinProduct;
@Repository(WeixinOrderDAO.DAO_NAME)
@Scope("prototype")
public class WeixinOrderDAOImpl extends BasicDAOImpl<WeixinOrder> implements
		WeixinOrderDAO {

	@Override
	public WeixinOrder findBywxOrderId(String wxOrderId) {
		String queryString = "from WeixinOrder where weixinOrderId=?";

		List<WeixinOrder> ps = getHibernateTemplate().find(queryString,
				wxOrderId);
		if (ps != null && ps.size() > 0)
			return ps.get(0);
		else
			return null;
	}

}
