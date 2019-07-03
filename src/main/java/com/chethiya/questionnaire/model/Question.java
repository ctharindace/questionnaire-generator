package com.chethiya.questionnaire.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_question")
	@SequenceGenerator(name = "s_question", sequenceName = "s_question", allocationSize = 1)
	@Column(name = "question_id")
	private Integer questionId;

	@Column(name = "questionnaire_section_id", insertable = false, updatable = false)
	private Integer questionnaireSectionId;

	@Column(name = "question_text")
	private Integer questionText;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = QuestionColumn.class, orphanRemoval = true)
	@JoinColumn(name = "question_id", nullable = false)
	private Set<QuestionColumn> questionColumns;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = QuestionRow.class, orphanRemoval = true)
	@JoinColumn(name = "question_id", nullable = false)
	private Set<QuestionRow> questionRows;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = QuestionField.class, orphanRemoval = true)
	@JoinColumn(name = "question_id", nullable = false)
	private Set<QuestionField> questionFields;
}
