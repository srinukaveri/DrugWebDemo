package com.vir.demo.main.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Embeddable
@Entity
@Table(name="USER_LOGIN_DETAILS")
public class UserLoginDetails  {
	

	//private static final long serialVersionUID = 1L;
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
