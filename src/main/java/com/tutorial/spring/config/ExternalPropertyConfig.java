package com.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.tutorial.spring.properties.external.FakeDataSource;

/**
 * Java based configuration to tell spring to load the properties from
 * the default application.properties
 * 
 * @author Bastian Bräunel
 *
 */
@Configuration
public class ExternalPropertyConfig {

	// "${}" spring expression language
	// get the value out of the spring context
	@Value("${external.username}")
	private String user;
	
	@Value("${external.password}")
	private String passwd;
	
	@Value("${external.url}")
	private String url;
	
	/**
	 * Create an FakeDataSource bean an initialize it with the external properties
	 * 
	 * @return	the FakeDataSource bean
	 */
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource source = new FakeDataSource();
		source.setUser(user);
		source.setPasswd(passwd);
		source.setUrl(url);
		
		return source;
	}
	
	/**
	 * 
	 * @return	PropertySourcesPlaceholderConfigurer allows to wire up the properties by value
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
