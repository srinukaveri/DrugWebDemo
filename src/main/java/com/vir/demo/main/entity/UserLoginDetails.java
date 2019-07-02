package com.vir.demo.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_LOGIN_DETAILS")
public class UserLoginDetails  {
	
	@Id
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return userPassword;
	}
	public void setPassWord(String passWord) {
		this.userPassword = passWord;
	}
	
	
	 

}
