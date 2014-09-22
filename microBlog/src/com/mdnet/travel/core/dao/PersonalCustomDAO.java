package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.PersonalCustom;

public interface PersonalCustomDAO extends BasicDAO<PersonalCustom>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.PersonalCustomDAOImpl";

	PersonalCustom getPersonalBySession(String sid);

	List<PersonalCustom> findAll(int page, int count, int sType, String context);

}
