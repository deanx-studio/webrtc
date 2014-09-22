package com.mdnet.travel.core.dao;

import com.mdnet.travel.core.model.ValidateCode;

public interface ValidCodeDAO extends BasicDAO<ValidateCode> {

	public final static String DAO_NAME = "com.mdnet.travel.core.dao.ValidCodeDAOImpl";

	ValidateCode getCodeByUser(String username);
	ValidateCode getCodeByMobile(String mobile);
	ValidateCode getCodeByUserAndMobile(String username,String mobile);
}
