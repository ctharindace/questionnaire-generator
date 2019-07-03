package com.chethiya.questionnaire.dao.impl;

import org.springframework.stereotype.Repository;

import com.chethiya.questionnaire.dao.ParticipantDAO;
import com.chethiya.questionnaire.dao.common.impl.BaseHibernateDAO;
import com.chethiya.questionnaire.model.Participant;

@Repository
public class ParticipantDAOImpl extends BaseHibernateDAO<Participant> implements ParticipantDAO {

}
