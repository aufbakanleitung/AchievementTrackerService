package com.ibm.achievement.dao.model;

public class User {
	
	private String activFlg;
	private String emailId;
	private String passwd;
	private String role;
	
	public User(){
		
	}

	public String getActivFlg() {
		return activFlg;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getRole() {
		return role;
	}

	public void setActivFlg(String activFlg) {
		this.activFlg = activFlg;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
