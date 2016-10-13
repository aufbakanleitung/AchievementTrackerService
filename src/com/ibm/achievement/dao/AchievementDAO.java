package com.ibm.achievement.dao;

import java.util.List;

import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;
		
public interface AchievementDAO{

	List<AchievementType> findAllAchievementType()
			throws java.sql.SQLException;

	AchievementType findAchievementType(java.lang.String typeId)
			throws java.sql.SQLException;

	List<AchievementCatg> findAllAchievementCatg()
			throws java.sql.SQLException;

	List<Achievement> findAchievementByEmpId(java.lang.String empId)
			throws java.sql.SQLException;

	List<Achievement> findAchievementByApproverId(java.lang.String approverId)
			throws java.sql.SQLException;

	Achievement findAchievementById(int achievementId)
			throws java.sql.SQLException;

	List<AchievementDoc> findAchievementDocById(java.lang.String achievementId)
			throws java.sql.SQLException;

	AchievementCount findAchievementCountById(java.lang.String employeeId)
			throws java.sql.SQLException;

	int saveAchievement(Achievement achievement)
			throws java.sql.SQLException;
	
	int saveAchievementDoc(AchievementDoc achievementDoc)
			throws java.sql.SQLException;

	int updateAchievement(Achievement achievement)
			throws java.sql.SQLException;



}
