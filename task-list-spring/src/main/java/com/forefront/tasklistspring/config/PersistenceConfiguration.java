package com.forefront.tasklistspring.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {
	//Primary db connection string
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	//Secondary db connection string
//	@Bean
//	@ConfigurationProperties(prefix="datasource.flyway")
//	@FlywayDataSource
//	public DataSource flywayDataSource() {
//		return DataSourceBuilder.create().build();
//	}
	
	//NEED TO ADD THIS TO APPLICATION.PROPERTIES FILE
//	datasource.flyway.url=jdbc:h2:file:~/tasklistspring
//			datasource.flyway.username=sa
//			datasource.flyway.password=
//			datasource.flyway.driver-class-name=org.h2.Driver
	
}