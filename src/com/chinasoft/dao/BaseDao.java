package com.chinasoft.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	void save(T t);
	
	void delete(Serializable id);
	
	void update(T t);
	
	T getById(Serializable id);
	
	List<T> findAll();
	
}
