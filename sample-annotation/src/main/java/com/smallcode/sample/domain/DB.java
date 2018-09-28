package com.smallcode.sample.domain;

/**
 *
 * @author niele
 * @date 2018/9/28
 */
public class DB {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public DB() {
	}

	public DB(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
