package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.User;

public class AchievementMapper implements RowMapper<Achievement> {
	
	@Override
	public Achievement mapRow(ResultSet rs, int num) throws SQLException {
		Achievement achievement = new Achievement();
		achievement.setAchievementId(rs.getInt("ACHIEVEMENT_ID"));
		achievement.setAchievementText(rs.getString("ACHIEVEMENT_TEXT"));
		achievement.setAchievementTypeId(rs.getString("TYPE_ID"));
		achievement.setApproverComment(rs.getString("APPROVER_COMMENT_TEXT"));
		achievement.setApproverPointVal(rs.getInt("APPROVER_POINT_VAL"));
		achievement.setCategoryId(rs.getString("CATEGORY_ID"));
		achievement.setEndDate(rs.getDate("END_DATE"));
		achievement.setApproverId(rs.getString("APPROVER_ID"));
		achievement.setEmployeeId(rs.getString("EMPLOYEE_ID"));
		achievement.setProjectId(rs.getString("PROJECT_ID"));
		achievement.setStartDate(rs.getDate("START_DATE"));
		achievement.setStatusCode(rs.getString("STATUS_CODE"));
	
		return achievement;
	}

}
