package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.WeixinAccount;
@Repository(WeixinAccountDAO.DAO_NAME)
@Scope("prototype")
public class WeixinAccountDAOImpl extends BasicDAOImpl<WeixinAccount> implements
		WeixinAccountDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<WeixinAccount> findAll(int pageNo) {
		
		final String queryString = "from WeixinAccount order by accountId desc ";
		final int length = 20;
		final int offset = pageNo*length;
		
		List<WeixinAccount> list = getHibernateTemplate().executeFind(new HibernateCallback() {
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

	@SuppressWarnings("unchecked")
	@Override
	public WeixinAccount find(String fromUserName) {
		List<WeixinAccount> accounts = getHibernateTemplate().find(
				"from WeixinAccount where wxFromUserName = ? ", fromUserName);

		if (accounts != null && accounts.size() >= 1) {
			return accounts.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public WeixinAccount findById(int id) {
		
		List<WeixinAccount> accounts = getHibernateTemplate().find(
				"from WeixinAccount where accountId  = ? ", id);

		if (accounts != null && accounts.size() >= 1) {
			return accounts.get(0);
		}
		return null;
	}

}
