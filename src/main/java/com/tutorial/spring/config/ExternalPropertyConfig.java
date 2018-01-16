package com.tutorial.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.tutorial.spring.properties.external.FakeDataSource;
import com.tutorial.spring.properties.external.FakeJmsBroker;

/**
 * Java based configuration to tell spring how to load the properties from multiple files 
 * 
 * @author Bastian Bräunel
 *
 */
@Configuration
// a list of PropertySources
@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")
	})
public class ExternalPropertyConfig {

	// "${}" spring expression language
	// get the value out of the spring context
	@Value("${external.username}")
	private String user;
	
	@Value("${external.password}")
	private String passwd;
	
	@Value("${external.url}")
	private String url;
	
	@Value("${jms.username}")
	private String jmsUser;
	
	@Value("${jms.password}")
	private String jmsPasswd;
	
	@Value("${jms.url}")
	private String jmsUrl;
	
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
	 * Create an FakeJmsBroker bean an initialize it with the external properties
	 * 
	 * @return	the FakeDataSource bean
	 */
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker broker = new FakeJmsBroker();
		broker.setUser(jmsUser);
		broker.setPasswd(jmsPasswd);
		broker.setUrl(jmsUrl);
		
		return broker;
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
