package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.order.model.ProductPriceLine;

@Repository(PriceDAO.DAO_NAME)
@Scope("prototype")
public class PriceDAOImpl extends BasicDAOImpl<ProductPriceLine> implements
		PriceDAO {

	@Override
	public List<ProductPriceLine> findPrice(String where, int page) {
		final int length = 20;
		final int offset = page * length;
		where = "where " + where;
		final String hql = "from ProductPriceLine " + where + " order by id desc";
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

}
