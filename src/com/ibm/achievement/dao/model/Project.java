package com.ibm.achievement.dao.model;

public class Project extends java.lang.Object{

	private String ManagerID;
	private String ProjectID;
	private String ProjectName;
	
	public Project() {
		
	}

	public String getManagerID() {
		return ManagerID;
	}

	public void setManagerID(String managerID) {
		ManagerID = managerID;
	}

	public String getProjectID() {
		return ProjectID;
	}

	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	
	
}
