package com.ibm.achievement.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
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
            throws java.sql.SQLException{
		return template.query("select * from TA_ACHIEVEMENT_TYPE", new AchievementTypeMapper());
	}
	
	public java.util.List<Achievement> findAchievementByEmpId(java.lang.String empId)
            throws java.sql.SQLException{
		return template.query("select * from TA_ACHIEVEMENT where EMPLOYEE_ID = ?",
				new AchievementMapper(), empId);
	}
	
	public int saveAchievement(Achievement achievement)
            throws java.sql.SQLException{return 0;}
	
	public int updateAchievement(Achievement achievement)
            throws java.sql.SQLException{return 0;}
	
	public java.util.List<Achievement> findAchievementByApproverId(java.lang.String approverId)
            throws java.sql.SQLException{
		return template.query("select * from TA_ACHIEVEMENT where APPROVER_ID = ?",
				new AchievementMapper(), approverId);
	}
	
	public int saveAchievementDoc(AchievementDoc achievementDoc){return 0;}
	
	public Achievement findAchievementById(int achievementId)
            throws java.sql.SQLException{
		try{
	
		return template.queryForObject("select * from TA_ACHIEVEMENT where ACHIEVEMENT_ID = ?",
				new AchievementMapper(),
				achievementId);
	}catch (IncorrectResultSizeDataAccessException e) {
		return null;
	}
	}
	
	public AchievementType findAchievementType(java.lang.String typeId)
            throws java.sql.SQLException{return null;}
	
	public AchievementCount findAchievementCountById(java.lang.String employeeId)
         throws java.sql.SQLException{return null;}
       /* return template.queryForObject("sum * from TA_ACHIEVEMENT where EMPLOYEE_ID = ?",
    				new AchievementMapper(),
    				employeeId); */

	@Override
	public List<AchievementCatg> findAllAchievementCatg()
			throws java.sql.SQLException{
		return template.query("select * from TA_ACHIEVEMENT_CATERGORY", new AchievementCatergoryMapper());
		
	}

	@Override
	public List<AchievementDoc> findAchievementDocById(String achievementId) 
			throws SQLException {
		return template.query("select * from TA_ACHIEVEMENT_DOCUMENT where ACHIEVEMENT_ID = ?",
				new AchievementDocumentsMapper(),
				achievementId);
	}

}
