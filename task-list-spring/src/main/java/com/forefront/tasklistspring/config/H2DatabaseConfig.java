package com.forefront.tasklistspring.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class H2DatabaseConfig {
	//Primary db connection string
	/*@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}*/

	//Secondary db connection string
//	@Bean
//	@ConfigurationProperties(prefix="datasource.flyway")
//	@FlywayDataSource
//	public DataSource flywayDataSource() {
//		return DataSourceBuilder.create().build();
//	}
	
	//NEED TO ADD THIS TO APPLICATION.PROPERTIES FILE FOR SECONDARY DB CONNECTION
//	datasource.flyway.url=jdbc:h2:file:~/tasklistspring
//	datasource.flyway.username=sa
//	datasource.flyway.password=
//	datasource.flyway.driver-class-name=org.h2.Driver
	
}