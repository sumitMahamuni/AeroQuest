package com.aeroQuest.ars.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import com.aeroQuest.ars.entity.UserEntity;
import com.aeroQuest.ars.exception.AeroQuestBootException;
import com.aeroQuest.ars.exception.UserIdAlreadyPresentException;
import com.aeroQuest.ars.model.User;
import com.aeroQuest.ars.repository.UserRepository;

@ContextConfiguration
public class RegistrationServiceTest {
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private RegistrationService registrationService;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	User user = new User();
	UserEntity userEntity = new UserEntity();
	
	public void initializedUserAndUserEntity() {
		user.setCity("Chennai");
		user.setEmail("sam@aeroQuest.com");
		user.setName("sammual");
		user.setPassword("sammmual_svs");
		user.setPhone("9876543210");
		user.setUserId("C1021");
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		userEntity.setUserId(user.getUserId());
	}
	
	@Before
	public void initialWork() {
		MockitoAnnotations.initMocks(this);
		initializedUserAndUserEntity();
	}
	
	@Test
	public void testRegisteruserPositive() {
		Mockito.when(userRepository.getOne(user.getName())).thenReturn(null);
		
		Mockito.when(userRepository.saveAndFlush(userEntity)).thenReturn(userEntity);
		try {
			registrationService.registerUser(user);
		}catch(Exception e) {
			Assert.fail("Exception "+e);
		}
	}
	
	@Test
	public void testRegisterUserNegative() throws AeroQuestBootException {
		expectedException.expect(UserIdAlreadyPresentException.class);
		expectedException.expectMessage("RegistrationService.USERID_PRESENT");
		
		Mockito.when(userRepository.existsById(Mockito.anyString())).thenReturn(true);
		registrationService.registerUser(user);
	}
}
