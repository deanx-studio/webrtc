package com.mdnet.travel.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.MetaKeys;

@Repository(MetaKeysDAO.DAO_NAME)
@Scope("prototype")
public class MetaKeysDAOImpl extends BasicDAOImpl<MetaKeys> implements
		MetaKeysDAO {

	@Override
	public String getKeys(String uri) {
		String hql = "from MetaKeys where pageUri=?";
		List<MetaKeys> keys = getHibernateTemplate().find(hql, uri);
		if (keys != null && keys.size() > 0)
			return keys.get(0).getKeywords();
		else
			return "";
	}
	
	@Override
	public MetaKeys getMetaKeys(String uri) {
		String hql = "from MetaKeys where pageUri=?";
		List<MetaKeys> keys = getHibernateTemplate().find(hql, uri);
		if (keys != null && keys.size() > 0)
			return keys.get(0);
		else
			return null;
	}

	@Override
	public String getGeneral() {
		String hql = "from MetaKeys where pageUri=null";
		List<MetaKeys> keys = getHibernateTemplate().find(hql);
		if (keys != null && keys.size() > 0)
			return keys.get(0).getKeywords();
		else
			return "";
	}

	@Override
	public List<MetaKeys> getAllKeys(int page) {
		final String queryString = "from MetaKeys ";
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
