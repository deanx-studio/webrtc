package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.KeyDefine;

@Repository(KeysDAO.DAO_NAME)
@Scope("prototype")
public class KeysDAOImpl extends BasicDAOImpl<KeyDefine> implements KeysDAO {
	@Override
	public List<KeyDefine> findAll(String et, String weixinId) {
		String hql = "from KeyDefine where toUserName='" + weixinId + "'";
		if (et != null && et.equals("0"))
			hql += " and keyValue<100";// 系统事件
		else if (et != null && et.equals("1"))
			hql += " and keyValue>100";// 菜单事件

		return getHibernateTemplate().find(hql + " order by keyValue desc");
	}

	@Override
	public List<KeyDefine> findByKeyValue(int key_id, String weixinId) {
		String query = "from KeyDefine where keyValue=?";
		if (weixinId != null)
			query += " and toUserName='" + weixinId + "'";
		return getHibernateTemplate().find(query, key_id);
	}

	@Override
	public int getMaxValue() {
		String query = "from KeyDefine order by key_value DESC limit 0, 1";
		List<KeyDefine> keys = getHibernateTemplate().find(query);
		if (keys != null && keys.size() > 0)
			return keys.get(0).getKeyValue();
		else
			return 0;
	}
}