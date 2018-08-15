package com.chinasoft.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chinasoft.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void save(T t) {
		this.getCurrentSession().save(t);
	}

	public void delete(Serializable id) {
		T t = this.getById(id);
		if (t != null) {
			this.getCurrentSession().delete(t);
		}
	}

	public void update(T t) {
		this.getCurrentSession().update(t);
	}

	public T getById(Serializable id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	public List<T> findAll() {

		Query query = this.getCurrentSession().createQuery(
				"from " + this.clazz.getSimpleName());
		return query.list();
	}

}
