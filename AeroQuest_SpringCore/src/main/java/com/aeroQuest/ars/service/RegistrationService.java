package com.aeroQuest.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeroQuest.ars.entity.UserEntity;
import com.aeroQuest.ars.exception.AeroQuestBootException;
import com.aeroQuest.ars.exception.UserIdAlreadyPresentException;
import com.aeroQuest.ars.model.User;
import com.aeroQuest.ars.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
		
	public void registerUser(User user) throws AeroQuestBootException {
		
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
	}
		
}
