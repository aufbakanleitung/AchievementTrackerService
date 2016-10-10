package com.ibm.achievement.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ibm.achievement.bo.AchievementTrackerBO;
import com.ibm.achievement.entity.AchievementCatgryVO;
import com.ibm.achievement.entity.AchievementCountVO;
import com.ibm.achievement.entity.AchievementTypesVO;
import com.ibm.achievement.entity.AchievementVO;
import com.ibm.achievement.exception.AchievementTrackerException;

/**
 * AchievementTracker class provide operations like find all achievement type,
 * find achievement category, save new achievement or update existing achievement. 
 * All methods are exposed as web services
 * 
 * @author use@in.ibm.com
 * @version 1.0
 * @since   2015-03-31 
 */
@WebService(name = "AchievementTracker", targetNamespace = "http://service.achievement.ibm.com/")
public class AchievementTracker extends SpringBeanAutowiringSupport{
	
	@Autowired
	private AchievementTrackerBO achievementTrackerBO;
	private Logger logger = Logger.getLogger(AchievementTracker.class);

	/**
	 * Return list of all achievement types
	 * 
	 * @return List achievement type value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<AchievementTypesVO> findAchievementTypes()
			throws AchievementTrackerException {
		logger.info("START findAchievementTypes");
		List<AchievementTypesVO> achievementTypesVOs = new ArrayList<AchievementTypesVO>();
		try {
			achievementTypesVOs = achievementTrackerBO.findAchievementTypes();
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementTypes");
		return achievementTypesVOs;
	}

	/**
	 * Return achievement type value object matching with a type id
	 * 
	 * @param achievement type
	 * @return List Achievement type value object
	 */
	@WebMethod
	public AchievementTypesVO findAchievementType(
			@WebParam(name = "typeId") String typeId)
			throws AchievementTrackerException {
		logger.info("START findAchievementType");

		AchievementTypesVO achievementTypesVO = new AchievementTypesVO();
		try {
			achievementTypesVO = achievementTrackerBO
					.findAchievementType(typeId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}

		logger.info("END findAchievementType");
		return achievementTypesVO;
	}

	/**
	 * Return list of all achievement categories
	 * 
	 * @return List Achievement category value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<AchievementCatgryVO> findAchievementCategories()
			throws AchievementTrackerException {
		logger.info("START findAchievementCategories");
		List<AchievementCatgryVO> achievementCatgryVOs = new ArrayList<AchievementCatgryVO>();
		try {
			achievementCatgryVOs = achievementTrackerBO
					.findAchievementCategories();
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementCategories");
		return achievementCatgryVOs;
	}

	/**
	 * Return true if achievement save into database successfully else return false
	 * 
	 * @param achievementVO achievement value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public boolean saveAchievement(
			@WebParam(name = "achievementVO") AchievementVO achievementVO)
			throws AchievementTrackerException {
		logger.info("START saveAchievement");
		boolean status = false;
		try {
			status = achievementTrackerBO.saveAchievement(achievementVO);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END saveAchievement");
		return status;

	}

	/**
	 * Return list of achievement matching with a employee id
	 * 
	 * @param employeeId employee id
	 * @return List of AchievementVO achievement value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<AchievementVO> findAchievementByEmpID(
			@WebParam(name = "employeeId") String employeeId)
			throws AchievementTrackerException {
		logger.info("START findAchievementByEmpID");
		List<AchievementVO> achievementVOs = new ArrayList<AchievementVO>();
		try {
			achievementVOs = achievementTrackerBO
					.findAchievementByEmpID(employeeId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementByEmpID");
		return achievementVOs;
	}

	/**
	 * Return list of achievement matching with a approver id
	 * 
	 * @param approverId approver employee id
	 * @return List of AchievementVO achievement value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public List<AchievementVO> findAchievementByApproverID(
			@WebParam(name = "approverId") String approverId)
			throws AchievementTrackerException {
		logger.info("START findAchievementByApproverID");
		List<AchievementVO> achievementVOs = new ArrayList<AchievementVO>();
		try {
			achievementVOs = achievementTrackerBO
					.findAchievementByApproverID(approverId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementByApproverID");
		return achievementVOs;
	}

	/**
	 * Return achievement value object matching with a achievement id
	 * 
	 * @param approverId achievement id
	 * @return AchievementVO achievement value object
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public AchievementVO findAchievementById(
			@WebParam(name = "achievementId") int achievementId)
			throws AchievementTrackerException {
		logger.info("START findAchievementById");
		AchievementVO achievementVO = new AchievementVO();
		try {
			achievementVO = achievementTrackerBO
					.findAchievementByID(achievementId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementById");
		return achievementVO;
	}

	/**
	 * Return true if approval successful or return false
	 * 
	 * @param achievementId
	 * @param status
	 * @param category
	 * @param pointValue
	 * @param approverComment
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public boolean approveAchievement(
			@WebParam(name = "achievementId") String achievementId,
			@WebParam(name = "status") String status,
			@WebParam(name = "category") String categoryId,
			@WebParam(name = "pointValue") int pointValue,
			@WebParam(name = "approverComment") String approverComment)
			throws AchievementTrackerException {
		logger.info("START approveAchievement");
		boolean approveStatus = false;
		try {
			approveStatus = achievementTrackerBO.approveAchievement(
					achievementId, status, categoryId, pointValue,
					approverComment);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}

		logger.info("END approveAchievement");
		return approveStatus;
	}
	
	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws AchievementTrackerException
	 */
	@WebMethod
	public AchievementCountVO findAchievementSummery(
			@WebParam(name = "employeeId") String employeeId)
			throws AchievementTrackerException {
		logger.info("START findAchievementById");
		AchievementCountVO achievementCountVO = new AchievementCountVO();
		try {
			achievementCountVO = achievementTrackerBO
					.findAchievementSummery(employeeId);
		} catch (AchievementTrackerException e) {
			throw e;
		} catch (Exception e) {
			throw new AchievementTrackerException(e.getMessage(), e);
		}
		logger.info("END findAchievementById");
		return achievementCountVO;
	}
}
