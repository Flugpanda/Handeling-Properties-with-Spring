package com.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.tutorial.spring.properties.external.FakeDataSource;

/**
 * This class shows how to access environmental properties 
 * 
 * @author Bastian Bräunel
 *
 */
@Configuration
public class EnvironmentPropertyConfig {

	@Autowired
	public Environment env;
	
	private String user = "Bob";
	private String passwd = "1234";
	private String url = "/dev/nul";
	
	/**
	 * Create an FakeDataSource bean an initialize it with the external and environmental properties
	 * 
	 * @return	the FakeDataSource bean
	 */
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource source = new FakeDataSource();
		source.setUser(env.getProperty("SYSTEM_USERNAME"));
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
