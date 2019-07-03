package com.chethiya.questionnaire.dao.common.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chethiya.questionnaire.dao.common.BaseCacheDAOSupport;

@Transactional
public abstract class BaseHibernateCacheDAO<T> implements BaseCacheDAOSupport<T> {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<T> getRecordsList(Class<T> t) {
		Session currentSession = getSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(t);
		Root<T> root = criteriaQuery.from(t);
		setOrderByExpression(criteriaBuilder, criteriaQuery, root);
		criteriaQuery.select(root);
		Query query = currentSession.createQuery(criteriaQuery);
		List<T> list = query.getResultList();
		return list;
	}

	protected void setOrderByExpression(CriteriaBuilder criteriaBuilder, CriteriaQuery criteriaQuery, Root<T> root) {
	}

}
