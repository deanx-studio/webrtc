package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.GroupDate;

public interface GroupDateDAO extends BasicDAO<GroupDate> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.GroupDateDAOImpl";

	List<GroupDate> getList(String string, int i);

}
