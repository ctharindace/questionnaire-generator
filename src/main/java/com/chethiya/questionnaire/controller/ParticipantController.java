package com.chethiya.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chethiya.questionnaire.Service.ParticipantService;
import com.chethiya.questionnaire.model.Participant;

@Controller
@RequestMapping(path = "/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	private @ResponseBody Participant createParticipant(@RequestBody Participant participant) {
		participantService.createParticipant(participant);
		return participant;
	}

	@PostMapping(path = "/get", consumes = "application/json", produces = "application/json")
	private @ResponseBody Participant getParticipant(@RequestBody Participant participant) {
		participantService.createParticipant(participant);
		return participant;
	}

}
