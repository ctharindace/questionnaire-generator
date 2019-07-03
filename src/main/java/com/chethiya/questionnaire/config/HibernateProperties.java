package com.chethiya.questionnaire.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {

	private String dialect;
	private String serverName;
	private String databaseName;
	private String connectionUsername;
	private String connectionPassword;
	private String currentSessionContextClass;
}
