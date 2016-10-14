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
		return achievementDAO.findAllAchievementType();
	}
	
	public AchievementType findAchievementType(String typeId) throws SQLException{
		return achievementDAO.findAchievementType(typeId);
	}
	public List<AchievementCatg> findAllAchievementCatg() throws SQLException{
		return achievementDAO.findAllAchievementCatg();
	}
	public List<Achievement> findAchievementByEmpId(String empId) throws SQLException{
		return achievementDAO.findAchievementByEmpId(empId);
	}
	public int saveAchievement(Achievement achievement) throws SQLException{
		return achievementDAO.saveAchievement(achievement);
	}
	public int updateAchievement(Achievement achievement) throws SQLException{
		return achievementDAO.updateAchievement(achievement);
	}
	public List<Achievement> findAchievementByApproverId(String approverId) throws SQLException{
		return achievementDAO.findAchievementByApproverId(approverId);
	}
	public Achievement findAchievementById(int achievementId) throws SQLException{
		return achievementDAO.findAchievementById(achievementId);
	}
	public int saveAchievementDoc(AchievementDoc achievementDoc) throws SQLException{
		return achievementDAO.saveAchievementDoc(achievementDoc);
	}
	public AchievementCount findAchievementCountById(String employeeId) throws SQLException{
		return achievementDAO.findAchievementCountById(employeeId);
	}
}