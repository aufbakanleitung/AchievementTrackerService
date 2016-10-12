package com.ibm.achievement.dao.manager;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.achievement.dao.AchievementDAO;
import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

@Component
public class AchievementManager {
	
@Autowired AchievementDAO achievementDAO;
	
	public String approverId;
	public String empId;
	public int achievementId;
	public String employeeId;
	public String typeId;
	
	public List<AchievementType> findAllAchievementType() throws SQLException{
		return null;
	}
	public AchievementType findAchievementType(String typeId) throws SQLException{
		return null;
	}
	public List<AchievementCatg> findAllAchievementCatg() throws SQLException{
		return null;
	}
	public List<Achievement> findAchievementByEmpId(String empId) throws SQLException{
		return null;
	}
	public int saveAchievement(Achievement achievement) throws SQLException{
		return 0;
	}
	public int updateAchievement(Achievement achievement) throws SQLException{
		return 0;
	}
	public List<Achievement> findAchievementByApproverId(String approverId) throws SQLException{
		return null;
	}
	public Achievement findAchievementById(int achievementId) throws SQLException{
		return null;
	}
	public int saveAchievementDoc(AchievementDoc achievementDoc) throws SQLException{
		return 0;
	}
	public AchievementCount findAchievementCountById(String employeeId) throws SQLException{
		return null;
	}
}