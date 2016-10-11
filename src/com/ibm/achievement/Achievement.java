package com.ibm.achievement;

import java.util.Date;

public class Achievement {

	
int achievementId;

List<AchievementDoc> achievementDoc;

String achievementText;
String achievementTypeId;
String approverComment;
String approverId;

int approverPointVal;

String categoryId;
String employeeId;

Date endDate;

String projectId;

Date startDate;

String statusCode;

public int getAchievementId() {
	return achievementId;
}

public void setAchievementId(int achievementId) {
	this.achievementId = achievementId;
}

public List<AchievementDoc> getAchievementDoc() {
	return achievementDoc;
}

public void setAchievementDoc(List<AchievementDoc> achievementDoc) {
	this.achievementDoc = achievementDoc;
}

public String getAchievementText() {
	return achievementText;
}

public void setAchievementText(String achievementText) {
	this.achievementText = achievementText;
}

public String getAchievementTypeId() {
	return achievementTypeId;
}

public void setAchievementTypeId(String achievementTypeId) {
	this.achievementTypeId = achievementTypeId;
}

public String getApproverComment() {
	return approverComment;
}

public void setApproverComment(String approverComment) {
	this.approverComment = approverComment;
}

public String getApproverId() {
	return approverId;
}

public void setApproverId(String approverId) {
	this.approverId = approverId;
}

public int getApproverPointVal() {
	return approverPointVal;
}

public void setApproverPointVal(int approverPointVal) {
	this.approverPointVal = approverPointVal;
}

public String getCategoryId() {
	return categoryId;
}

public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}

public String getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public String getProjectId() {
	return projectId;
}

public void setProjectId(String projectId) {
	this.projectId = projectId;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public String getStatusCode() {
	return statusCode;
}

public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}


}
