package com.chethiya.questionnaire.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties({ HibernateProperties.class })
@EnableTransactionManagement
public class PersistenceConfig {

	@Autowired
	private HibernateProperties hibernateProperties;

	@Bean
	public DataSource masterDataSource() {
		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		dataSource.setServerName(hibernateProperties.getServerName());
		dataSource.setDatabaseName(hibernateProperties.getDatabaseName());
		dataSource.setUser(hibernateProperties.getConnectionUsername());
		dataSource.setPassword(hibernateProperties.getConnectionPassword());
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource());
		sessionFactory.setPackagesToScan("com.chethiya.questionnaire.model");
		sessionFactory.setHibernateProperties(getHibernateProperties());
		try {
			sessionFactory.afterPropertiesSet();
			log.info("##############################");
		} catch (Exception e) {
			log.error("", e);
		}
		return sessionFactory.getObject();
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		txManager.setDataSource(masterDataSource());
		return txManager;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", hibernateProperties.getDialect());
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		return properties;
	}
}
