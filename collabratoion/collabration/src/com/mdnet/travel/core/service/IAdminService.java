package com.mdnet.travel.core.service;

import java.util.List;

import net.zhinet.travel.pojo.basepojo.ParamConfig;
import net.zhinet.travel.pojo.basepojo.UserInfo;

import com.mdnet.travel.core.vo.UserListBean;

public interface IAdminService {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.AdminServiceImpl";

	int deleteUser(int id);

	List<UserInfo> findAdmin(int pageNo);

	int insertUserInfo(String username, String passWd, String mobile, String role, String terminateNumber);

	int checkUsename(String username);

	int updateUserInfo(int uid, String username, String passWd, String mobile, String role, String terminateNumber);

	UserInfo getUserInfo(String name);

	List<ParamConfig> getParams();

	String getParam(String paramKey);
	
	void setParam(String paramKey, String keyValue, String keyDesc);

	void setParam(String paramKey, int keyValue, String keyDesc);
	
	 
}
