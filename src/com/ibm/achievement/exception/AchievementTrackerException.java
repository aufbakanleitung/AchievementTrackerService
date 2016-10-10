package com.ibm.achievement.exception;

import org.apache.log4j.Logger;

public class AchievementTrackerException extends Exception {
	private Logger logger = Logger.getLogger(AchievementTrackerException.class);
	private static final long serialVersionUID = 1L;
	private String message = null;

	public AchievementTrackerException() {
		super();
	}

	public AchievementTrackerException(String message) {
		super(message);
		this.message = message;
		logger.error(message);
	}

	public AchievementTrackerException(Throwable cause) {
		super(cause);
		logger.error(cause);
	}

	public AchievementTrackerException(String message, Throwable cause) {
		super(message, cause);
		logger.error(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
