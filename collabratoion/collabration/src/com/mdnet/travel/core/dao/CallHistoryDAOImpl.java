package com.mdnet.travel.core.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import net.zhinet.travel.pojo.basepojo.CallHistory;

@Repository(ICallHistoryDAO.DAO_NAME)
@Scope("singleton")
public class CallHistoryDAOImpl extends BasicDAOImpl<CallHistory> implements
		ICallHistoryDAO {

	@Override
	public void updateHistory(String channel, int channelState) {
		List<CallHistory> ch = this.findByHQL("where channel='" + channel
				+ "' ", 0, 20);
		if (ch != null && ch.size() > 0) {
			CallHistory callHis = ch.get(0);
			if (channelState > 0) {
				callHis.setStatus(channelState);
			}
			callHis.setEndTime(sdf.format(new Date()));
			this.update(ch.get(0));
		}
	}

	@Override
	public List<CallHistory> findByHQL(String where, int pageNo, int count) {
		String query = "from CallHistory ";
		query += where;

		final String queryString = query;
		final int length = count;
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
