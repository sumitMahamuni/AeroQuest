package com.aeroQuest.ars.exception;

public class InvalidCityException extends AeroQuestBootException{
	
	private static final long serialVersionUID = 1L;
	
	/*	
	 * This Exception is thrown form RegistrationService class with error message
		
		RegistrationSErvice.INVALID_CITY if the given city is not matching the
		constraints given in the regular expression
	*/	
	
	public InvalidCityException(String message) {
		super(message);
	}
}
