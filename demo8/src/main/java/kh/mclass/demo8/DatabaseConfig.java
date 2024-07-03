package kh.mclass.demo8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@PropertySource("classpath:/keyfiles/apikeys.properties")
public class DatabaseConfig {
	
	@Value("${spring.datasource.hikari.jdbc-log4j2-driverClassName}")
	private String driverClassName;
	
	@Value("${spring.datasource.hikari.jdbc-log4j2-url}")
	private String dataSourceUrl;
	
	@Value("${spring.datasource.hikari.username}")
	private String dataSourceUserName;
	
	@Value("${spring.datasource.hikari.password}")
	private String dataSourcePassword;
	
	@Bean 
	HikariDataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setJdbcUrl(dataSourceUrl);
		hikariConfig.setUsername(dataSourceUserName);
		hikariConfig.setPassword(dataSourcePassword);

		return new HikariDataSource(hikariConfig);
	}
	
}
