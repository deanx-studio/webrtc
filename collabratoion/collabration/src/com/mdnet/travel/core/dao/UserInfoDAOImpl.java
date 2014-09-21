package com.mdnet.travel.core.dao;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository(IUserInfoDAO.DAO_NAME)
@Scope("singleton")
public class UserInfoDAOImpl extends BasicDAOImpl<UserInfo> implements
		IUserInfoDAO {

	@Override
	public List<UserInfo> findByHQL(String where, int pageNo) {
		String query = "from UserInfo ";
		query += where;

		final String queryString = query;
		final int length = 20;
		final int offset = pageNo * length;

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
