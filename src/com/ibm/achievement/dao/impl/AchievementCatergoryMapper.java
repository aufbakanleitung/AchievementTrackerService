package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.AchievementCatg;

public class AchievementCatergoryMapper implements RowMapper<AchievementCatg>{
	@Override
	public AchievementCatg mapRow(ResultSet rs, int num) throws SQLException {
		AchievementCatg achievementCatg = new AchievementCatg();
		achievementCatg.setDescription(rs.getString("DESCRIPTION"));
		achievementCatg.setCategoryId(rs.getString("CATERGORY_ID"));
		
		return achievementCatg;
	}
}
