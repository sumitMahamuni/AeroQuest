package com.aeroQuest.ars.utility;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aeroQuest.ars.exception.AeroQuestBootException;

@Component
@Aspect
public class LoggingAspect {
	
	@AfterThrowing(pointcut = "excution(* com.aeroQuest.ars.repository.*.*(..))", throwing = "exception")
	public void logExceptionFromRepository(AeroQuestBootException exception) throws AeroQuestBootException {
		log(exception);
	}
	
	@AfterThrowing(pointcut = "execution(* com.aeroQuest.ars.service.*.*(..))", throwing = "exception")
	public void logExceptionFromService(AeroQuestBootException exception) throws AeroQuestBootException {
		if(exception.getMessage().contains("Service")) {
			log(exception);
		}
	}
	
	private void log(Exception exception) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.error(exception.getMessage(), exception);
		
	}
}
