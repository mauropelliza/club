package com.clubproject.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {
"com.clubproject.repository" }, entityManagerFactoryRef = "clubEntityManager", transactionManagerRef = "clubTransactionManager")
@ComponentScan("com.clubproject.model")
@EnableTransactionManagement
public class DataSourceConfiguration {

	@Autowired
	private Environment env;
	
	@Bean(name = "dataSourceClub")
	public DataSource getDataSourceClub() {
		CustomDriverManagerDataSource dataSource = new CustomDriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("club.jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("club.jdbc.url"));
		dataSource.setUsername(env.getProperty("club.jdbc.username"));
		dataSource.setPassword(env.getProperty("club.jdbc.password"));
		return dataSource;
	}
	
	class CustomDriverManagerDataSource extends DriverManagerDataSource {
		@Override
		protected Connection getConnectionFromDriverManager(String url, Properties props) throws SQLException {
			Connection connection = super.getConnectionFromDriverManager(url, props);
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			return connection;
		}
	}
	
	@Bean(name = "clubEntityManager")
	public LocalContainerEntityManagerFactoryBean clubEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSourceClub") DataSource dataSource) {

		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
				.dataSource(this.getDataSourceClub()).packages("com.clubproject.model")
				.persistenceUnit("clubEntityManager").build();

		return localContainerEntityManagerFactoryBean;
	}

	@Bean(name = "clubTransactionManager")
	public PlatformTransactionManager aterTransactionManager(
			@Qualifier("clubEntityManager") EntityManagerFactory dbAterEntityManager) {

		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(dbAterEntityManager);

		return jpaTransactionManager;
	}
}