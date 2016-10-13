package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.AchievementType;

public class AchievementManagerMapper implements RowMapper<AchievementType>{

	@Override
	public AchievementType mapRow(ResultSet rs, int num) throws SQLException {
		AchievementType achievementType = new AchievementType();
		achievementType.setTypeId(rs.getString("TYPE_ID"));
		achievementType.setDescription(rs.getString("DESCRIPTION"));
	

		return achievementType;
	}

}
