package com.aeroQuest.ars.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeroQuest.ars.entity.UserEntity;
import com.aeroQuest.ars.exception.AeroQuestBootException;
import com.aeroQuest.ars.exception.InvalidCityException;
import com.aeroQuest.ars.exception.InvalidEmailException;
import com.aeroQuest.ars.exception.InvalidNameException;
import com.aeroQuest.ars.exception.InvalidPasswordException;
import com.aeroQuest.ars.exception.InvalidPhoneException;
import com.aeroQuest.ars.exception.InvalidUserIdException;
import com.aeroQuest.ars.exception.UserIdAlreadyPresentException;
import com.aeroQuest.ars.model.User;
import com.aeroQuest.ars.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	String regex1 = "^[a-zA-Z0-9]{4,15}+$";
	
	public String registerUser(User user) throws AeroQuestBootException {
		validateUser(user);
		boolean b = userRepository.existsById(user.getUserId());
		if(b)
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
			UserEntity userEntity = new UserEntity();
			userEntity.setCity(user.getCity());
			userEntity.setEmail(user.getEmail());
			userEntity.setName(user.getPassword());
			userEntity.setPassword(user.getPassword());
			userEntity.setPhone(user.getPhone());
			userEntity.setUserId(user.getUserId());
			userRepository.saveAndFlush(userEntity);
			return "UserRespository.REGISTRATION_SUCCESS";
	}
	
	public void validateUser(User user) throws AeroQuestBootException {
		if(!isValidUserId(user.getUserId()))
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
				
		if(!isValidPassword(user.getPassword()))
			throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");		

		if(!isValidName(user.getName()))
			throw new InvalidNameException("RegistrationService.INVALID_NAME");
		
		if(!isValidCity(user.getCity()))
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		
		if(!isValidEmail(user.getEmail()))
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		
		if(!isValidPhoneNumber(user.getPhone()))
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
	}
	
	public Boolean isValidUserId(String userid) {
		Boolean b1 = false;
		
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(userid);
		
		if(matcher1.matches())
			b1 = true;
		
		return b1;
	}
	
	private boolean isValidPassword(String password) {
		Boolean b1 = false;
		String regex = "^[a-zA-Z0-9]{8,15}+$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.matches())
			b1 = true;
		
		return b1;
	
	}

	private boolean isValidName(String name) {
		Boolean b1 = false;
		
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(name);
		
		if(matcher.matches())
			b1 = true;
		
		return b1;
	}
	
	private boolean isValidCity(String city) {
		Boolean b1 = false;
		
		Pattern pattern = Pattern.compile(regex1);
		Matcher matcher = pattern.matcher(city);
		
		if(matcher.matches())
			b1 = true;
		
		return b1;
	}
	
	private Boolean isValidEmail(String email) {
		
		Boolean b1 = false;
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches())
			b1 = true;
		
		return b1;		
	}
	
	private Boolean isValidPhoneNumber(String number) {
		Boolean b1 = false;
		String regex = "[0-9]{10}";
		
		Pattern pattern1 = Pattern.compile(regex);
		Matcher matcher1 = pattern1.matcher(number);
		
		if(matcher1.matches())
			b1 = true;
		
		return b1;
	}
	
}
