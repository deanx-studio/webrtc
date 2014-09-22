package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.Traveler;

@Repository(TravelerDAO.DAO_NAME)
@Scope("prototype")
public class TravelerDAOImpl extends BasicDAOImpl<Traveler> implements
		TravelerDAO {

	public Traveler findByUsername(String username) {
		String hql = "from Traveler t where t.username=?";
		return this.GetTraveler(hql, username);
	}

	public Traveler findUserByMobile(String mobile) {
		String hql = "from Traveler t where t.mobile=?";
		return this.GetTraveler(hql, mobile);
	}

	public Traveler findUserById(String travelerId) {
		String hql = "from Traveler t where t.travelerId=?";
		// return this.GetTraveler(hql, travelerId);
		@SuppressWarnings("unchecked")
		List<Traveler> travelerList = this.getHibernateTemplate().find(hql,
				travelerId);
		if (travelerList.size() > 0) {
			return travelerList.get(0);
		} else
			return null;
	}

	@Override
	public Traveler GetTraveler(String hql, String param) {
		@SuppressWarnings("unchecked")
		List<Traveler> travelerList = this.getHibernateTemplate().find(hql,
				param);
		if (travelerList.size() > 0) {
			return travelerList.get(0);
		} else
			return null;
	}

	@Override
	public Traveler findUserByWX(String fromUserName) {
		String hql = "from Traveler t where t.wxFromUserName=?";
		return this.GetTraveler(hql, fromUserName);
	}

	@Override
	public Traveler findUserByOpenId(String openId) {
		// TODO Auto-generated method stub
		String hql = "from Traveler t where t.wxOpenId = ?";
		return this.GetTraveler(hql, openId);

	}

	@Override
	public Traveler findObjectByHQL(String sql) {
		// TODO Auto-generated method stub

		return this.GetTraveler(sql, null);
	}

	@Override
	public List<Traveler> findAdmin(String role, int pageNo) {
		String query = "from Traveler ";
		if (role != null)
			query += " where authority='" + role + "'";
		else
			query += " where authority='ROLE_ADMIN' or authority='ROLE_SUPER'";
		query += " order by traveler_id desc ";
		
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
