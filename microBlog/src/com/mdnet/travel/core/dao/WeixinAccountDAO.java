package com.mdnet.travel.core.dao;

import com.mdnet.travel.core.model.WeixinAccount;
import java.util.*;

public interface WeixinAccountDAO extends BasicDAO<WeixinAccount>{
	public final static String DAO_NAME = "com.mdnet.travel.core.dao.WeixinAccountDAOImpl";
	//每次提供20条记录
	List<WeixinAccount> findAll(int pageNo);
	
	//查找有关记录,fromUserName是微信的ID，是创建微信帐号时微信平台分配的
	WeixinAccount find(String fromUserName);
	
	WeixinAccount findById(int id);
}
