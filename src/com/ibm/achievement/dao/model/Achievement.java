package com.ibm.achievement.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Achievement extends java.lang.Object{
    
	private List <AchievementDoc> achievementDoc = new ArrayList<AchievementDoc>();
	private int achievementId;
	private String	achievementText;
	private String	achievementTypeId;
	private String	approverComment;
	private String	approverId;
	private int approverPointVal;
	private String categoryId;
	private String	employeeId;
	private Date endDate;
	private String projectId;
	private Date startDate;
	private String statusCode;
	
	public Achievement(){
	}

	public List<AchievementDoc> getAchievementDoc() {
		return achievementDoc;
	}

	public void setAchievementDoc(List<AchievementDoc> achievementDoc) {
		this.achievementDoc = achievementDoc;
	}

	public int getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(int achievementId) {
		this.achievementId = achievementId;
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

	public void setApproverId(String getApproverId) {
		this.approverId = getApproverId;
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

	public void setEmployeeId(String getEmployeeId) {
		this.employeeId = getEmployeeId;
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

	@Override
	public String toString() {
		return "Achievement [AchievementDoc=" + achievementDoc + ", AchievementId=" + achievementId
				+ ", AchievementText=" + achievementText + ", AchievementTypeId=" + achievementTypeId
				+ ", ApproverComment=" + approverComment + ", getApproverId=" + approverId + ", ApproverPointVal="
				+ approverPointVal + ", CategoryId=" + categoryId + ", getEmployeeId=" + employeeId + ", EndDate="
				+ endDate + ", ProjectId=" + projectId + ", StartDate=" + startDate + ", StatusCode=" + statusCode
				+ "]";
	}

	
}
