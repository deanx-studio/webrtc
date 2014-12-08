package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import net.zhinet.travel.pojo.basepojo.ParamConfig;

@Repository(IParamConfigDAO.DAO_NAME)
@Scope("singleton")
public class ParamConfigDAOImpl extends BasicDAOImpl<ParamConfig> implements
		IParamConfigDAO {

	@Override
	public void setParam(String paramKey, String keyValue, String keyDesc) {
		ParamConfig p = this.getObj(paramKey);
		if(p != null){
			p.setKeyDesc(keyDesc);
			p.setKeyName(paramKey);
			p.setKeyValue(keyValue);
			this.update(p);
		}
		else
		{
			p = new ParamConfig();
			p.setKeyDesc(keyDesc);
			p.setKeyName(paramKey);
			p.setKeyValue(keyValue);
			this.save(p);
		}

	}

	
	protected ParamConfig getObj(String paramKey) {

		@SuppressWarnings("unchecked")
		List<ParamConfig> ps = getHibernateTemplate().find(
				"from ParamConfig where keyName=?", paramKey);
		if (ps != null && ps.size() > 0)
			return ps.get(0);
		else
			return null;
	}
	
	@Override
	public String getValue(String paramKey) {

		ParamConfig p = this.getObj(paramKey);
		if (p != null)
			return p.getKeyValue();
		else
			return null;
	}

}
