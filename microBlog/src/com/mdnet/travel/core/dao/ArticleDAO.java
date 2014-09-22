package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.Article;

public interface ArticleDAO extends BasicDAO<Article> {

	public final static String DAO_NAME = "com.mdnet.travel.core.dao.ArticleDAOImpl";

	List<Article> findByIds(String ids, String toUserName);
	public List<Article> findById(int id);
	/**
	 * 查询全部的T实例
	 * @param search 
	 * @return 数据库中全部的T实例
	 */
	List<Article> findAll(int pageNo, String search, String weixinId);
}
