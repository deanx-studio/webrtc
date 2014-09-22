package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.Article;
import com.mdnet.travel.core.model.Special;

public interface SpecialDAO extends BasicDAO<Special>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.SpecialDAOImpl";

	public List<Special> findAll(String where, /*String toUserName,*/
			final int offset, final int length);
	public Special findById(int id);
	Special getNext(int id, String wxAccount);
	Special getPrev(int id, String wxAccount);
	public Special findByPid(int id);

}
