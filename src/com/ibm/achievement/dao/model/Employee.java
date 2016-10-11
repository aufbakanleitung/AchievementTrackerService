package com.ibm.achievement.dao.model;

public class Employee extends java.lang.Object{
	
	private String EmailID;
	private String EmployeeId;
	private String FirstName;
	private String LastName;
	private String ManagerFlag;
	private String ManagerId;
	
	public Employee(){
		
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

	public void setManagerId(String ManagerId) {
		this.ManagerId = ManagerId;
	}
	
	
	
}
