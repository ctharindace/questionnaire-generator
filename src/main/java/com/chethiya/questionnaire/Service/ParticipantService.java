package com.chethiya.questionnaire.Service;

import org.springframework.stereotype.Service;

import com.chethiya.questionnaire.dto.CommonResponse;
import com.chethiya.questionnaire.dto.ServiceResponse;
import com.chethiya.questionnaire.model.Participant;

@Service
public interface ParticipantService {

	ServiceResponse<CommonResponse> createParticipant(Participant participant);

}
