package com.chethiya.questionnaire.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_answer")
	@SequenceGenerator(name = "s_answer", sequenceName = "s_answer", allocationSize = 1)
	@Column(name = "answer_id")
	private Long answerId;

	@Column(name = "question_field_id", insertable = false, updatable = false)
	private Integer answerFieldId;

	@Column(name = "answer")
	private String answerText;

	@Column(name = "participant_id", insertable = false, updatable = false)
	private Integer participantId;
}
