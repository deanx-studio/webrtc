package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.Traveler;

public interface TravelerDAO extends BasicDAO<Traveler>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.TravelerDAOImpl";

	Traveler findByUsername(String username);

	Traveler findUserByMobile(String mobile);
	
	Traveler findUserByWX(String fromUserName);
	
	Traveler findUserByOpenId(String openId);
	
	Traveler findObjectByHQL(String sql);
	
	Traveler findUserById(String travelerId);
	
	List<Traveler> findAdmin(String role, int pageNo);
	
	Traveler GetTraveler(String hql, String param);
}
