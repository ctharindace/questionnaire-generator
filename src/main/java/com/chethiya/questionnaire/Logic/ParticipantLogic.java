package com.chethiya.questionnaire.Logic;

import org.springframework.stereotype.Component;

import com.chethiya.questionnaire.model.Participant;

@Component
public interface ParticipantLogic {

	void validateNewParticipant(Participant participant);

}
