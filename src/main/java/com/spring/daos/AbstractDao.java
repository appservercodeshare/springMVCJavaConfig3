package com.spring.daos;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Serializable save(Object object) {
		return getSession().save(object);
	}
	
	public void update(Object object) {
		getSession().update(object);
	}
	
	public void saveOrUpdate(Object object) {
		getSession().saveOrUpdate(object);
	}
	
	public void delete(Object object) {
		getSession().delete(object);
	}
	
	
	@Override
	public String toString() {
		return "AbstractDao [sessionFactory=" + sessionFactory + "]";
	}
	
	
}
