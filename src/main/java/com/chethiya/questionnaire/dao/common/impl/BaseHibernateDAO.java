package com.chethiya.questionnaire.dao.common.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chethiya.questionnaire.dao.common.BaseDAOSupport;

@Transactional
public abstract class BaseHibernateDAO<T> implements BaseDAOSupport<T> {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T save(T t) {
		Session session = getSession();
		session.save(t);
		return t;
	}

	public T get(Class<T> t, Serializable id) {
		Session session = getSession();
		T t1 = session.get(t, id);
		return t.cast(t1);
	}

	public void delete(T t) {
		Session session = getSession();
		session.delete(t);
	}

	public void merge(T t) {
		Session session = getSession();
		session.merge(t);
	}

	public void update(T t) {
		Session session = getSession();
		session.update(t);
	}

}