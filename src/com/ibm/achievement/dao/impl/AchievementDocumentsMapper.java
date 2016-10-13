package com.ibm.achievement.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.achievement.dao.model.AchievementDoc;

public class AchievementDocumentsMapper implements RowMapper<AchievementDoc>{
	@Override
	public AchievementDoc mapRow(ResultSet rs, int num) throws SQLException {
		AchievementDoc achievementDoc = new AchievementDoc();
		achievementDoc.setAchievementId(rs.getInt("ACHIEVEMENT_ID"));
		achievementDoc.setDocumentContent(rs.getBytes("DOCUMENT_CONTENT"));
		achievementDoc.setDocumentId(rs.getInt("DOCUMENT_ID"));
		achievementDoc.setDocumentName(rs.getString("DOCUMENT_NAME"));
		
		return achievementDoc;
	}

}
