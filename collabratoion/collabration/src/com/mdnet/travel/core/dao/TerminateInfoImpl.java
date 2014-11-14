package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import net.zhinet.travel.pojo.basepojo.TerminateInfo;

@Repository(ITerminateInfo.DAO_NAME)
@Scope("singleton")
public class TerminateInfoImpl extends BasicDAOImpl<TerminateInfo> implements
		ITerminateInfo {

	@Override
	public void update(TerminateInfo entity) {
		if(entity.getChannelState() == -2)
		{
			System.out.println("find out it!");
		}
		System.out.println("*******************Channel:" + entity.getChannel()
				+ "channelState:" + entity.getChannelState() + ",ChannelDesc:"
				+ entity.getChannelStateDesc());
		super.update(entity);
	}

	@Override
	public List<TerminateInfo> find(String where, int pageNo) {
		final String queryString = "from TerminateInfo " + where;
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
