package com.ibm.achievement.dao.impl;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;

public class AchievementDAOImpl {
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

}
