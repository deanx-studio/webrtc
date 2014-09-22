package com.mdnet.travel.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.ValidateCode;
@Repository(ValidCodeDAO.DAO_NAME)
@Scope("prototype")
public class ValidCodeDAOImpl extends BasicDAOImpl<ValidateCode> implements ValidCodeDAO {

	@Override
	public ValidateCode getCodeByUser(String username) {
		List<ValidateCode> codeList=new ArrayList<ValidateCode>();
 
		ValidateCode code = null;
		String hql = "from ValidCode t where t.traveler=?";
		codeList = this.getHibernateTemplate().find(hql, username);
		if(codeList.size()>0){
			code = codeList.get(0);
		}
		return code;
	}

	@Override
	public ValidateCode getCodeByMobile(String mobile) {
		List<ValidateCode> codeList=new ArrayList<ValidateCode>();

		ValidateCode code = null;
		String hql = "from ValidCode t where t.mobile=? order by t.vcId desc";
		codeList = this.getHibernateTemplate().find(hql,mobile);
		if(codeList.size()>0){
			code = codeList.get(0);
		}
		return code;
	}

	@Override
	public ValidateCode getCodeByUserAndMobile(String username, String mobile) {
		// TODO Auto-generated method stub
		List<ValidateCode> codeList=new ArrayList<ValidateCode>();

		ValidateCode code = null;
		String hql = "from ValidCode t where t.mobile='"+mobile+"' and t.traveler='"+username+"'";
		codeList = this.getHibernateTemplate().find(hql);

		if(codeList.size()>0){
			code = codeList.get(0);
		}
		return code;
	}

}
