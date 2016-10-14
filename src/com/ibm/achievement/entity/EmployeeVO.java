package com.ibm.achievement.entity;

import java.util.List;

public class EmployeeVO {

	private String employeeId;
	private String emailID;
	private String firstName;
	private String lastName;
	private String managerId;
	private String managerFlag;
	private String userRoll;
	private String activeFlag;
	private List<ProjectVO> projects;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerFlag() {
		return managerFlag;
	}

	public void setManagerFlag(String managerFlag) {
		this.managerFlag = managerFlag;
	}

	public String getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public List<ProjectVO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectVO> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "EmployeeVO [employeeId=" + employeeId + ", emailID=" + emailID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", managerId=" + managerId + ", managerFlag=" + managerFlag + ", userRoll="
				+ userRoll + ", activeFlag=" + activeFlag + ", projects=" + projects + "]";
	}
	
}
