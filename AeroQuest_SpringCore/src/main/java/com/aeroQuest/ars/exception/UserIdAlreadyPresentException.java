package com.aeroQuest.ars.exception;

public class UserIdAlreadyPresentException extends AeroQuestBootException {
	private static final long serialVersionUID = 1L;
	
	public UserIdAlreadyPresentException(String message) {
		super(message);
	}
}
