package com.ibm.achievement.dao.model;

public class AchievementCount extends java.lang.Object{

	private String CurrentMonthCount;
	private String	CurrentYearCount;
	private String	EmployeeId;

	public AchievementCount(){
		
	}

	public String getCurrentMonthCount() {
		return CurrentMonthCount;
	}

	public void setCurrentMonthCount(String currentMonthCount) {
		CurrentMonthCount = currentMonthCount;
	}

	public String getCurrentYearCount() {
		return CurrentYearCount;
	}

	public void setCurrentYearCount(String currentYearCount) {
		CurrentYearCount = currentYearCount;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	
	
	
	
	
	
	
}
