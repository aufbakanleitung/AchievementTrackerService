package com.ibm.achievement.dao.model;

import java.util.Date;
import java.util.List;

public class Achievement extends java.lang.Object{
    
	private List AchievementDoc;
	private int AchievementId;
	private String	AchievementText;
	private String	AchievementTypeId;
	private String	ApproverComment;
	private String	getApproverId;
	private int ApproverPointVal;
	private String CategoryId;
	private String	getEmployeeId;
	private Date EndDate;
	private String ProjectId;
	private Date StartDate;
	private String StatusCode;
	
	public Achievement(){
	}

	public List getAchievementDoc() {
		return AchievementDoc;
	}

	public void setAchievementDoc(List achievementDoc) {
		AchievementDoc = achievementDoc;
	}

	public int getAchievementId() {
		return AchievementId;
	}

	public void setAchievementId(int achievementId) {
		AchievementId = achievementId;
	}

	public String getAchievementText() {
		return AchievementText;
	}

	public void setAchievementText(String achievementText) {
		AchievementText = achievementText;
	}

	public String getAchievementTypeId() {
		return AchievementTypeId;
	}

	public void setAchievementTypeId(String achievementTypeId) {
		AchievementTypeId = achievementTypeId;
	}

	public String getApproverComment() {
		return ApproverComment;
	}

	public void setApproverComment(String approverComment) {
		ApproverComment = approverComment;
	}

	public String getGetApproverId() {
		return getApproverId;
	}

	public void setGetApproverId(String getApproverId) {
		this.getApproverId = getApproverId;
	}

	public int getApproverPointVal() {
		return ApproverPointVal;
	}

	public void setApproverPointVal(int approverPointVal) {
		ApproverPointVal = approverPointVal;
	}

	public String getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}

	public String getGetEmployeeId() {
		return getEmployeeId;
	}

	public void setGetEmployeeId(String getEmployeeId) {
		this.getEmployeeId = getEmployeeId;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getProjectId() {
		return ProjectId;
	}

	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
	
	
}
