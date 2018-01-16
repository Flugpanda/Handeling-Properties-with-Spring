package com.tutorial.spring.properties.external;

/**
 * A pojo to fake a data source
 * 
 * @author Bastian Bräunel
 *
 */
public class FakeDataSource {

	private String user;
	private String passwd;
	private String url;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "FakeDataSource [user=" + user + ", passwd=" + passwd + ", url=" + url + "]";
	}
	
	
}
