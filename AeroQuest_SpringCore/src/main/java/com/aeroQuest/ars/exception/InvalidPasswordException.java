package com.aeroQuest.ars.exception;

public class InvalidPasswordException extends AeroQuestBootException{
	
	private static final long serialVersionUID = 1L;
	
	/*	
	 * This Exception is thrown form RegistrationService class with error message
		
		RegistrationSErvice.INVALID_PASSWORD if the given city is not matching the
		constraints given in the regular expression
	*/	
	
	public InvalidPasswordException(String message) {
		super(message);
	}
}
