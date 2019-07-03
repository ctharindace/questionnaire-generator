package com.chethiya.questionnaire.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "t_question_column")
public class QuestionColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_question_column")
	@SequenceGenerator(name = "s_question_column", sequenceName = "s_question_column", allocationSize = 1)
	@Column(name = "question_column_id")
	private Integer questionColumnId;

	@Column(name = "question_id", insertable = false, updatable = false)
	private Integer questionId;

	@Column(name = "column_heading_text")
	private String columnHeadingText;

	@Column(name = "answer_field_type")
	private String answerFieldType;

}
