package com.mdnet.travel.core.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.order.model.OrderInfo;
import com.mdnet.travel.order.model.ProductInfo;
@Repository(IOrderInfoDAO.DAO_NAME)
@Scope("prototype")
public class OrderInfoDAOImpl extends BasicDAOImpl<OrderInfo> implements IOrderInfoDAO {

	@Override
	public List<OrderInfo> find(String where, int page) {

		final String queryString = "from OrderInfo " + where
				+ " order by id desc ";
		final int length = 20;
		final int offset = page * length;
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(queryString);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

}
