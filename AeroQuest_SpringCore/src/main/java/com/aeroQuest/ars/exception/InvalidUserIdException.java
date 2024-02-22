package com.aeroQuest.ars.exception;

public class InvalidUserIdException extends AeroQuestBootException{
	
	private static final long serialVersionUID = 1L;
	
	/*	
	 * This Exception is thrown form RegistrationService class with error message
		
		RegistrationSErvice.INVALID_USER_ID if the given city is not matching the
		constraints given in the regular expression
	*/	
	
	public InvalidUserIdException(String message) {
		super(message);
	}
}
