package com.vir.demo.drug.model;

import java.io.Serializable;

/**
 * @author C-PN16
 *
 */
public class UserLogin implements Serializable {

	private static final long serialVersionUID = -1311920156428302557L;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
