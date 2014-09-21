package com.mdnet.travel.core.dao;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.UserInfo;

public interface IUserInfoDAO extends BasicDAO<UserInfo> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.UserInfoDAOImpl";

	List<UserInfo> findByHQL(String where, int pageNo);

}
