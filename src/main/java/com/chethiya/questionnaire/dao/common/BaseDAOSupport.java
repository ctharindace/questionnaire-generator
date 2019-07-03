package com.chethiya.questionnaire.dao.common;

import java.io.Serializable;

public interface BaseDAOSupport<T> {

	public T save(T t);

	public T get(Class<T> t, Serializable id);

	public void delete(T t);

	public void merge(T t);

	public void update(T t);
}
