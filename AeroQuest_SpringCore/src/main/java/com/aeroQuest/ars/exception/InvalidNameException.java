package com.aeroQuest.ars.exception;

public class InvalidNameException extends AeroQuestBootException{
	
	private static final long serialVersionUID = 1L;
	
	/*	
	 * This Exception is thrown form RegistrationService class with error message
		
		RegistrationSErvice.INVALID_NAME if the given city is not matching the
		constraints given in the regular expression
	*/	
	
	public InvalidNameException(String message) {
		super(message);
	}
}
