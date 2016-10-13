package com.ibm.achievement.dao.model;

import java.util.List;

public class EmployeeUserProject extends java.lang.Object{
	
	private String ActiveFlag;
	private String EmailID;
	private String EmployeeId;
	private String FirstName;
	private String LastName;
	private String ManagerFlag;
	private String ManagerId;
	private List<Project> Projects;
	private String UserRoll;
	
	
	public EmployeeUserProject(){
		
	}

	public String getActiveFlag() {
		return ActiveFlag;
	}

	public void setActiveFlag(String activeFlag) {
		ActiveFlag = activeFlag;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getManagerFlag() {
		return ManagerFlag;
	}

	public void setManagerFlag(String managerFlag) {
		ManagerFlag = managerFlag;
	}

	public String getManagerId() {
		return ManagerId;
	}

	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}

	public List<Project> getProjects() {
		return Projects;
	}

	public void setProjects(List<Project> projects) {
		Projects = projects;
	}

	public String getUserRoll() {
		return UserRoll;
	}

	public void setUserRoll(String userRoll) {
		UserRoll = userRoll;
	}
	
}
