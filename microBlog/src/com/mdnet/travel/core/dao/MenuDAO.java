package com.mdnet.travel.core.dao;

import java.util.List;

import com.mdnet.travel.core.model.MenuDefine;
import com.mdnet.travel.core.vo.MenusBean;

public interface MenuDAO extends BasicDAO<MenuDefine>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.MenuDAOImpl";
	                                                                

	List<MenuDefine> findMenus(String where, String weixinId);
}
