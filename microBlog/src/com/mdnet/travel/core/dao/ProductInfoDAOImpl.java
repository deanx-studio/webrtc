package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.order.model.ProductInfo;

@Repository(IProductInfoDAO.DAO_NAME)
@Scope("prototype")
public class ProductInfoDAOImpl extends BasicDAOImpl<ProductInfo> implements
		IProductInfoDAO {

	@Override
	public List<ProductInfo> find(String where, int page) {

		final String queryString = "from ProductInfo " + where
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
