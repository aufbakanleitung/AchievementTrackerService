package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.AchievementType;

public class AchievementTypeMapper implements RowMapper<AchievementType>{
	@Override
	public AchievementType mapRow(ResultSet rs, int num) throws SQLException {
		AchievementType achievementType = new AchievementType();
		achievementType.setDescription(rs.getString("DESCRIPTION"));
		achievementType.setTypeId(rs.getString("TYPE_ID"));
		
		return achievementType;
	}
}
