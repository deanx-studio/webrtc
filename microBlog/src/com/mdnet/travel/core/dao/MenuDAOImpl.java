package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.common.Constant;
import com.mdnet.travel.core.model.MenuDefine;
import com.mdnet.travel.core.vo.MenusBean;

@Repository(MenuDAO.DAO_NAME)
@Scope("prototype")
public class MenuDAOImpl extends BasicDAOImpl<MenuDefine> implements MenuDAO {

	@Override
	public List<MenuDefine> findMenus(String where, String weixinId) {
		String query = "from MenuDefine ";

		if (weixinId != null)
			query += " where toUserName=?";

		if (where != null && where.length() > 0)
			query += where;

		if (weixinId != null)
			return getHibernateTemplate().find(query, weixinId);
		else
			return getHibernateTemplate().find(query);
	}

}
