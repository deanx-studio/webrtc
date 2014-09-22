package com.mdnet.travel.core.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.Article;

@Repository(ArticleDAO.DAO_NAME)
@Scope("prototype")
public class ArticleDAOImpl extends BasicDAOImpl<Article> implements ArticleDAO {

	/**
	 * 根据多个id查询
	 * 
	 * 事件ID可以重复，要求事件ID和微信原始ID组合不重复
	 * 
	 * @param ids
	 *            多个id以逗号隔开
	 * @return
	 */
	public List<Article> findByIds(String ids, String toUserName) {
		if (StringUtils.isNotBlank(ids)) {
			String queryString = "from Article o where o.articleId in (" + ids
					+ ") and o.aticleState=1 ";
			if (toUserName != null) {

				queryString += " and o.toUserName='" + toUserName + "'";
			}
			queryString += " order by seq desc ";
			return getHibernateTemplate().find(queryString);
		}
		return null;
	}

	public List<Article> findById(int id) {

		String queryString = "from Article o where o.id =" + id;
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * 查询全部的T实例
	 * 
	 * @return 数据库中全部的T实例
	 */
	public List<Article> findAll(int pageNo, String search, String weixinId) {

		String where = " where toUserName='" + weixinId + "'";
		if (search.length() > 0) {
			where = " and title like '%" + search + "%' ";
		}
		final int length = 50;
		final int offset = pageNo * length;
		final String hql = "from Article " + where
				+ " order by article_id desc, seq desc";
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
