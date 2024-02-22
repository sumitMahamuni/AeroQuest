package com.aeroQuest.ars.exception;

public class InvalidPhoneException extends AeroQuestBootException{
	
	private static final long serialVersionUID = 1L;
	
	/*	
	 * This Exception is thrown form RegistrationService class with error message
		
		RegistrationSErvice.INVALID_PHONE_NUMBER if the given city is not matching the
		constraints given in the regular expression
	*/	
	
	public InvalidPhoneException(String message) {
		super(message);
	}
}
