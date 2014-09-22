package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.Media;

public interface MediaDAO extends BasicDAO<Media> {
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.MediaDAOImpl";

	List<Media> findAll(int page, int count, String t, String search, String weixinId);

}