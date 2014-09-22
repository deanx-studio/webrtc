package com.mdnet.travel.core.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.mdnet.travel.core.model.Customer;
@Repository(CustomerDAO.DAO_NAME)
@Scope("prototype")
public class CustomerDAOImpl extends BasicDAOImpl<Customer> implements CustomerDAO {

	/**
	 * 根据用户名查询员工
	 * 
	 * @param name
	 *            员工的用户名
	 * @return 符合用户名的员工
	 */
	@Override
	public Customer findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Customer> cuts = getHibernateTemplate().find(
				"from Customer where fromUserName = ? ", name);
		if (cuts != null && cuts.size() >= 1) {
			return cuts.get(0);
		}
		return null;
	}
	public void persist(Customer customer){
		this.getHibernateTemplate().persist(customer);
	}
}
