package com.mdnet.travel.core.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.GroupDate;

@Repository(GroupDateDAO.DAO_NAME)
@Scope("prototype")
public class GroupDateDAOImpl extends BasicDAOImpl<GroupDate> implements
		GroupDateDAO {

	@Override
	public List<GroupDate> getList(String where, int page) {
		
		final String queryString = "from GroupDate " + where
				+ " order by startDate ASC ";
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
