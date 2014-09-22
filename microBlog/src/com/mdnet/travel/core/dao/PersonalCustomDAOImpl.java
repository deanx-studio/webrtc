package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.Media;
import com.mdnet.travel.core.model.PersonalCustom;

@Repository(PersonalCustomDAO.DAO_NAME)
@Scope("prototype")
public class PersonalCustomDAOImpl extends BasicDAOImpl<PersonalCustom>
		implements PersonalCustomDAO {

	@Override
	public PersonalCustom getPersonalBySession(String sid) {
		String hql = "from PersonalCustom where sessionID=?";
		List<PersonalCustom> pcs = this.getHibernateTemplate().find(hql, sid);
		if (pcs != null && pcs.size() > 0)
			return pcs.get(0);
		else
			return null;
	}

	@Override
	public List<PersonalCustom> findAll(int page, int count, int sType,
			String context) {

		final int length = count;
		final int offset = page * length;

		String where = "";
		if (sType == 0) {// 手机号
			where = " where mobile='" + context + "'";
		} else if (sType == 1) {// 客户姓名

			where = " where userName like'%" + context + "%'";

		} else if (sType == 2) {// session id

			where = " where sessionID ='" + context + "'";

		}

		final String hql = "from PersonalCustom " + where + " order by id desc";
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
