package com.mdnet.travel.core.dao;

import com.mdnet.travel.core.model.Customer;

public interface CustomerDAO extends BasicDAO<Customer> {

	public final static String DAO_NAME = "com.mdnet.travel.core.dao.CustomerDAOImpl";

	/**
	 * 根据用户名查询员工
	 * 
	 * @param name
	 *            员工的用户名
	 * @return 符合用户名的员工
	 */
	Customer findByName(String openId);
	void persist(Customer customer);

}
