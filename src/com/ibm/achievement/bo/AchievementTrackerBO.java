package com.ibm.achievement.bo;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.achievement.dao.manager.AchievementManager;
import com.ibm.achievement.dao.manager.EmployeeManager;
import com.ibm.achievement.dao.manager.ProjectManager;
import com.ibm.achievement.dao.model.Achievement;
import com.ibm.achievement.dao.model.AchievementCatg;
import com.ibm.achievement.dao.model.AchievementCount;
import com.ibm.achievement.dao.model.AchievementDoc;
import com.ibm.achievement.dao.model.AchievementType;
import com.ibm.achievement.dao.model.Employee;
import com.ibm.achievement.dao.model.Project;
import com.ibm.achievement.dao.util.AchievementListeners;
import com.ibm.achievement.entity.AchievementCatgryVO;
import com.ibm.achievement.entity.AchievementCountVO;
import com.ibm.achievement.entity.AchievementDocVO;
import com.ibm.achievement.entity.AchievementTypesVO;
import com.ibm.achievement.entity.AchievementVO;
import com.ibm.achievement.exception.AchievementTrackerException;
import com.ibm.achievement.util.AchievementConstants;

@Service
public class AchievementTrackerBO {

	@Autowired
	private AchievementListeners achievementListeners;

	private Logger logger = Logger.getLogger(AchievementTrackerBO.class);

	/**
	 * This method is used to retrieve types of achievement
	 * 
	 * @return List
	 */
	public List<AchievementTypesVO> findAchievementTypes() throws AchievementTrackerException {
		
		logger.info("START findAchievementTypes");
		List<AchievementTypesVO> achievementTypesVOs = new ArrayList<AchievementTypesVO>();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			List<AchievementType> achievementTypes = achievementManager.findAllAchievementType();

			for (AchievementType type : achievementTypes) {
				AchievementTypesVO typeVO = new AchievementTypesVO();
				BeanUtils.copyProperties(typeVO, type);
				achievementTypesVOs.add(typeVO);
			}
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		logger.info("END findAchievementTypes");
		
		return achievementTypesVOs;
	}

	/**
	 * This method is used to retrieve types of achievement for the ID
	 * 
	 * @return List
	 */
	public AchievementTypesVO findAchievementType(String typeId) throws AchievementTrackerException {
		
		logger.info("START findAchievementType");
		AchievementTypesVO achievementTypesVO = new AchievementTypesVO();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			AchievementType achievementType = achievementManager.findAchievementType(typeId);
			BeanUtils.copyProperties(achievementTypesVO, achievementType);
			
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}

		logger.info("END findAchievementType");
		return achievementTypesVO;
	}

	/**
	 * This method is used to retrieve Achievement Categories
	 * 
	 * @return List
	 */
	public List<AchievementCatgryVO> findAchievementCategories() throws AchievementTrackerException {
		
		logger.info("START findAchievementCategories");
		List<AchievementCatgryVO> achievementCatgVOs = new ArrayList<AchievementCatgryVO>();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			List<AchievementCatg> achievementCatgss = achievementManager.findAllAchievementCatg();

			for (AchievementCatg catg : achievementCatgss) {
				AchievementCatgryVO catgVO = new AchievementCatgryVO();
				BeanUtils.copyProperties(catgVO, catg);
				achievementCatgVOs.add(catgVO);
			}
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}

		logger.info("END findAchievementCategories");
		return achievementCatgVOs;
	}

	/**
	 * This method is used to save the achievement for a employee
	 * 
	 * @param achievementVO
	 */
	@Transactional
	public boolean saveAchievement(AchievementVO achievementVO) throws AchievementTrackerException {
		
		logger.info("START saveAchievement");
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			achievementVO.setStatusCode("N");
			if(achievementVO.getAchievementTypeId() == null || achievementVO.getAchievementTypeId() == ""){
				throw new AchievementTrackerException(AchievementConstants.ACHIEVEMENT_TYPE_ID_IS_BLANK);
			}
			AchievementType achievementType = achievementManager.findAchievementType(achievementVO.getAchievementTypeId());
			if(achievementType.getDescription() == null || achievementType.getDescription() == ""){
				throw new AchievementTrackerException(AchievementConstants.INVALID_ACHIEVEMENT_TYPE_ID);
			}
			
			if("Project Achievement".equals(achievementType.getDescription())){
				ProjectManager projectManager = achievementListeners.getProjectManager();
				Project project = projectManager.findProjectById(achievementVO.getProjectId());
				if(project.getManagerID() == null || project.getManagerID() == ""){
					throw new AchievementTrackerException(AchievementConstants.INVALID_PROJECT_ID);
				}
				achievementVO.setApproverId(project.getManagerID());
				
			}else if("Organization Give Back".equals(achievementType.getDescription()) || "Sales/Business".equals(achievementType.getDescription())){
				EmployeeManager employeeManager = achievementListeners.getEmployeeManager();
				Employee employee = employeeManager.findEmployeeById(achievementVO.getEmployeeId());
				if(employee.getManagerId() == null || employee.getManagerId() == ""){
					throw new AchievementTrackerException(AchievementConstants.MANAGER_ID_IS_BLANK);
				}
				achievementVO.setApproverId(employee.getManagerId());
			}else {
				// It is for Helping Other Employee
				if(achievementVO.getApproverId() == null || achievementVO.getApproverId() == ""){
					throw new AchievementTrackerException(AchievementConstants.APPROVER_ID_IS_BLANK);
				}
			}
			
			Achievement achievement = new Achievement();
			BeanUtils.copyProperties(achievement, achievementVO);
			int achievementId = achievementManager.saveAchievement(achievement);

			List<AchievementDocVO> achievementDoc = achievementVO.getAchievementDoc();
			for (AchievementDocVO achievementDocVO : achievementDoc) {
				achievementDocVO.setAchievementId(achievementId);
				AchievementDoc doc = new AchievementDoc();
				BeanUtils.copyProperties(doc, achievementDocVO);
				achievementManager.saveAchievementDoc(doc);
			}

		} catch (Exception e) {
			logger.error(e);
			throw new AchievementTrackerException(e.getMessage());
		}
		
		logger.info("END saveAchievement");
		return true;
	}

	/**
	 * This method is used to retrieve achievements for a employee
	 * 
	 * @param employeeId
	 * @return List of AchievementVO
	 */
	public List<AchievementVO> findAchievementByEmpID(String employeeId) throws AchievementTrackerException {
		
		logger.info("START findAchievementByEmpID");
		if (employeeId == null || employeeId.equals("")) {
			throw new AchievementTrackerException(AchievementConstants.EMPLOYEE_ID_IS_BLANK);
		}

		List<AchievementVO> achievementVOs = new ArrayList<AchievementVO>();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			List<Achievement> achievements = achievementManager.findAchievementByEmpId(employeeId);
			logger.info("Got achievements:" + achievements);
			for (Achievement achievement : achievements) {
				AchievementVO achievementVO = new AchievementVO();
				BeanUtils.copyProperties(achievementVO, achievement);

				List<AchievementDocVO> achievementDocVOs = new ArrayList<AchievementDocVO>();
				List<AchievementDoc> achievementDocs = achievement.getAchievementDoc();
					for (AchievementDoc doc : achievementDocs) {
						AchievementDocVO achievementDocVO = new AchievementDocVO();
						BeanUtils.copyProperties(achievementDocVO, doc);
						achievementDocVOs.add(achievementDocVO);
					}
				
				achievementVO.setAchievementDoc(achievementDocVOs);
				achievementVOs.add(achievementVO);
			}
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		
		logger.info("END findAchievementByEmpID" + achievementVOs);
		return achievementVOs;
	}

	/**
	 * This method is used to retrieve achievements for a Approver
	 * 
	 * @param approverId
	 * @return List of AchievementVO
	 */
	public List<AchievementVO> findAchievementByApproverID(String approverId) throws AchievementTrackerException {
		
		logger.info("START findAchievementByApproverID");
		List<AchievementVO> achievementVOs = new ArrayList<AchievementVO>();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			List<Achievement> achievements = achievementManager.findAchievementByApproverId(approverId);
			
			for (Achievement achievement : achievements) {
				AchievementVO achievementVO = new AchievementVO();
				BeanUtils.copyProperties(achievementVO, achievement);

				List<AchievementDocVO> achievementDocVOs = new ArrayList<AchievementDocVO>();
				List<AchievementDoc> achievementDocs = achievement.getAchievementDoc();

				for (AchievementDoc doc : achievementDocs) {
					AchievementDocVO achievementDocVO = new AchievementDocVO();
					BeanUtils.copyProperties(achievementDocVO, doc);
					achievementDocVOs.add(achievementDocVO);
				}
				achievementVO.setAchievementDoc(achievementDocVOs);
				achievementVOs.add(achievementVO);
			}
		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		
		logger.info("END findAchievementByApproverID");
		return achievementVOs;
	}

	/**
	 * This method is used to retrieve achievements for a ID
	 * 
	 * @param approverId
	 * @return AchievementVO
	 */
	public AchievementVO findAchievementByID(int achievementId) throws AchievementTrackerException {
		
		logger.info("START findAchievementByID");
		AchievementVO achievementVO = new AchievementVO();
		try {
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			Achievement achievement = achievementManager.findAchievementById(achievementId);

			BeanUtils.copyProperties(achievementVO, achievement);

			List<AchievementDocVO> achievementDocVOs = new ArrayList<AchievementDocVO>();
			List<AchievementDoc> achievementDocs = achievement.getAchievementDoc();

			for (AchievementDoc doc : achievementDocs) {
				AchievementDocVO achievementDocVO = new AchievementDocVO();
				BeanUtils.copyProperties(achievementDocVO, doc);
				achievementDocVOs.add(achievementDocVO);
			}
			achievementVO.setAchievementDoc(achievementDocVOs);

		} catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (InvocationTargetException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		} catch (IllegalAccessException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
		
		logger.info("END findAchievementByID");
		return achievementVO;
	}

	/**
	 * This method is used to approve or reject one achievement
	 * 
	 * @param achievementId
	 * @param status
	 * @param category
	 * @param pointValue
	 * @param approverComment
	 */
	public boolean approveAchievement(String achievementId, String status, String categoryId, int pointValue, String approverComment) throws AchievementTrackerException {
		
		logger.info("START approveAchievement");
		try {
			Achievement achievement = new Achievement();
			achievement.setAchievementId(Integer.parseInt(achievementId));
			achievement.setStatusCode(status);
			achievement.setCategoryId(categoryId);
			achievement.setApproverPointVal(pointValue);
			achievement.setApproverComment(approverComment);

			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			int updFlag = achievementManager.updateAchievement(achievement);
			
			if (updFlag == 1) {
				return true;
			} else {
				return false;
			}
		}catch (SQLException ex) {
			throw new AchievementTrackerException(ex.getMessage());
		}
	}
	
	public AchievementCountVO findAchievementSummery(String employeeId) throws AchievementTrackerException{
		
		logger.info("START approveAchievement");
		try{
			AchievementCountVO achievementCountVO = new AchievementCountVO();
			AchievementManager achievementManager = achievementListeners.getAchievementManager();
			AchievementCount achievementCount = achievementManager.findAchievementCountById(employeeId);
			BeanUtils.copyProperties(achievementCountVO, achievementCount);
			
			return achievementCountVO;
		}catch(Exception ex){
			throw new AchievementTrackerException(ex.getMessage());
		}
	}
}