package com.chethiya.questionnaire.dao.common;

import java.util.List;

public interface BaseCacheDAOSupport<T> {

	public List<T> getRecordsList(Class<T> t);

}
