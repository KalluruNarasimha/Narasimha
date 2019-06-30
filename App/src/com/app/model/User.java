package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="u_tab")
public class User implements Comparable<User>{
	@Id
	@Column(name="u_id")
	private int userId;
	
	@Column(name="u_nam")
	private String userName;

	@Column(name="u_email")
	private String userEmail;
	
	@Column(name="u_cnt")
	private String userContact;
	
	@Column(name="u_pwd")
	private String userPwd;
	
	@Column(name="u_addr")
	private String userAddr;
	
	public User() {
		super();
	}
	public User(int userId) {
		super();
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userContact=" + userContact
				+ ", userPwd=" + userPwd + ", userAddr=" + userAddr + "]";
	}
	public int compareTo(User u) {
		return this.getUserId()-u.getUserId();
	}

}
