package com.mdnet.travel.core.service;

import java.util.List;

import com.mdnet.travel.core.model.GroupDate;
import com.mdnet.travel.core.model.PersonalCustom;

public interface ICustomService {
	public final static String SERVICE_NAME = "com.mdnet.travel.core.service.impl.CustomServiceImpl";
 
	void savePrivate_Dest(String sid, String[] strings, String[] cities, String[] goal);

	PersonalCustom getPersonal(String sid);
	List<PersonalCustom> getPersonals(String sid, int page);

	void updatePersonal(PersonalCustom personal);
	
	List<PersonalCustom> findall(int page, int count, int sType, String context);

	List<GroupDate> getGroupList(String where, int page);

	List<PersonalCustom> getPersonalByMobile(String mobile, int page);

	int AddGroup(String groupName, String productName, String startDate, int productId, int bookCount,
			int totalCount);

	int UpdateGroup(int groupId, String groupName, String productName,
			String startDate, int productId, int bookCount, int totalCount);

	int deleteGroup(int groupId);

	String markGroupFull(int groupId);
}
