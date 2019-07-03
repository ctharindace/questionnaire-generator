package com.chethiya.questionnaire.dao.impl;

import org.springframework.stereotype.Repository;

import com.chethiya.questionnaire.dao.QuestionnaireDAO;
import com.chethiya.questionnaire.dao.common.impl.BaseHibernateDAO;
import com.chethiya.questionnaire.model.Questionnaire;

@Repository
public class QuestionnaireDAOImpl extends BaseHibernateDAO<Questionnaire> implements QuestionnaireDAO {

}
