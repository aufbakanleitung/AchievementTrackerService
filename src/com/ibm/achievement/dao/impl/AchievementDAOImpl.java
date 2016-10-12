package com.ibm.achievement.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.AchievementDAO;
import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

@Component
public class AchievementDAOImpl implements AchievementDAO {
	
	@Autowired JdbcTemplate template;
	
	public java.util.List<AchievementType> findAllAchievementType()
            throws java.sql.SQLException{return null;}
	
	public java.util.List<Achievement> findAchievementByEmpId(java.lang.String empId)
            throws java.sql.SQLException{return null;}
	
	public int saveAchievement(Achievement achievement)
            throws java.sql.SQLException{return 0;}
	
	public int updateAchievement(Achievement achievement)
            throws java.sql.SQLException{return 0;}
	
	public java.util.List<Achievement> findAchievementByApproverId(java.lang.String approverId)
            throws java.sql.SQLException{return null;}
	
	public int saveAchievementDoc(AchievementDoc achievementDoc){return 0;}
	
	public Achievement findAchievementById(int achievementId)
            throws java.sql.SQLException{return null;}
	
	public AchievementType findAchievementType(java.lang.String typeId)
            throws java.sql.SQLException{return null;}
	
	public AchievementCount findAchievementCountById(java.lang.String employeeId)
            throws java.sql.SQLException{return null;}

	@Override
	public List<AchievementCatg> findAllAchievementCatg() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AchievementDoc> findAchievementDocById(String achievementId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
