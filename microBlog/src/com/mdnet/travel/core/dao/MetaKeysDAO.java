package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.MetaKeys;

public interface MetaKeysDAO extends BasicDAO<MetaKeys> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.MetaKeysDAOImpl";

	String getKeys(String uri);
	MetaKeys getMetaKeys(String uri);
	String getGeneral();

	List<MetaKeys> getAllKeys(int page);
}
