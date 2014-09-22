package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.Media;

@Repository(MediaDAO.DAO_NAME)
@Scope("prototype")
public class MediaDAOImpl extends BasicDAOImpl<Media> implements MediaDAO {

	@Override
	public List<Media> findAll(int page, int count, String t, String search,
			String weixinId) {

		final int length = count;
		final int offset = page * length;

		String where = "";
		if (search.length() > 0 && t.length() >= 0) {
			if (t.equals("id"))
				where = " where id=" + search;
			else
				where = " where title like '%" + search + "%'";
		}
		if (weixinId != null)
			if (where.length() > 0)
				where += " and toUserName='" + weixinId + "'";
			else
				where += " where toUserName='" + weixinId + "'";
		final String hql = "from Media " + where + " order by id desc";
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
