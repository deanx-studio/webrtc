package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.Article;
import com.mdnet.travel.core.model.Special;

@Repository(SpecialDAO.DAO_NAME)
@Scope("prototype")
public class SpecialDAOImpl extends BasicDAOImpl<Special> implements SpecialDAO {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.SpecialDAOImpl";

	@Override
	public Special getNext(int id, String wxAccount) {
		String where = "toUserName='" + wxAccount + "' and  id>" + id;
		List<Special> list = this.findAll(where, 0, 1);
		if (list != null && list.size() > 0)
			return (Special) list.get(0);
		else
			return null;
	}

	@Override
	public Special getPrev(int id, String wxAccount) {
		String where = "toUserName='" + wxAccount + "' and id<" + id;
		List<Special> list = this.findAll(where, 0, 1);
		if (list != null && list.size() > 0)
			return (Special) list.get(0);
		else
			return null;
	}

	@Override
	public List<Special> findAll(String where, /* String toUserName, */
			final int offset, final int length) {
		if (where.length() > 0)
			where = " where " + where;
		final String queryString = "from Special "// where toUserName='"
				/* + toUserName + "'" */
				+ where + " order by id desc ";
		// return getHibernateTemplate().find(queryString);

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

	@Override
	public Special findById(int id) {
		List<Special> specials = this.findAll(" id=" + id, 0, 1);
		if (specials != null && specials.size() > 0)
			return specials.get(0);
		else
			return null;
	}

	@Override
	public Special findByPid(int id) {
		String where = "productIds='" + id+"'";
		List<Special> list = this.findAll(where, 0, 1);
		if (list != null && list.size() > 0)
			return (Special) list.get(0);
		else
			return null;
	}

}
