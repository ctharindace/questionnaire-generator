package com.chethiya.questionnaire.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_question_field")
public class QuestionField {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_question_field")
	@SequenceGenerator(name = "s_question_field", sequenceName = "s_question_field", allocationSize = 1)
	@Column(name = "question_field_id")
	private Long answerFieldId;

	@Column(name = "question_id", insertable = false, updatable = false)
	private Integer questionId;

	@Column(name = "question_column_id")
	private Integer questionColumnId;

	@Column(name = "question_row_id")
	private Integer questionRowId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Answer.class, orphanRemoval = true)
	@JoinColumn(name = "question_field_id")
	private Set<Answer> answers;
}
