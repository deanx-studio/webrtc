package com.mdnet.travel.core.dao;

import java.util.List;

public interface BasicDAO<T> {

	/**
	 * 根据标识属性来加载T实例
	 * @param id 需要加载的T实例的标识属性值
	 * @return 指定标识属性对应的T实例
	 */
	T get(Integer id);

	/**
	 * 持久化指定的T实例
	 * @param T 需要被持久化的T实例
	 * @return T实例被持久化后的标识属性值
	 */
	Integer save(T entity);

	/**
	 * 修改指定的T实例
	 * @param T 需要被修改的T实例
	 */
	void update(T entity);

	/**
	 * 删除指定的T实例
	 * @param T 需要被删除的T实例
	 */
	void delete(T entity);

	/**
	 * 根据标识属性删除T实例
	 * @param id 需要被删除的T实例的标识属性值
	 */
	void delete(Integer id);

	/**
	 * 查询全部的T实例
	 * @return 数据库中全部的T实例
	 */
	List<T> findAll();
}
