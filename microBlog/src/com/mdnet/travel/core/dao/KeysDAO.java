package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.Article;
import com.mdnet.travel.core.model.KeyDefine;

public interface KeysDAO extends BasicDAO<KeyDefine>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.KeysDAOImpl";

	List<KeyDefine> findAll(String et, String weixinId);

	List<KeyDefine> findByKeyValue(int key_id, String weixinId);

	int getMaxValue();
}
