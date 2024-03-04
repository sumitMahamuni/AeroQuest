package com.aeroQuest.ars.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aeroQuest.ars.model.User;
import com.aeroQuest.ars.repository.UserRepository;
import com.aeroQuest.ars.service.RegistrationService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RegistrationController.class)
public class RegistrationControllerTest {
	@MockBean
	private UserRepository userRepository;
	@MockBean
	private RegistrationService registrationService;
	@InjectMocks
	private RegistrationController registrationController;
	@Autowired
	private MockMvc mockMvc;
	private User user1;
	private User user2;
	private String command = "command";
	private String dummy1 = "dummy1";
	private String dummysuccess2 = "dummysuccess2";
	
	public void user1() {
		user1 = new User();
		user1.setUserId(dummy1);
		user1.setPassword(dummy1);
		user1.setName(dummy1);
		user1.setCity(dummy1);
		user1.setEmail(dummy1);
		user1.setPhone(dummy1);
	}
	
	public void user2() {
		user2 = new User();
		user2.setUserId(dummysuccess2);
		user2.setPassword(dummysuccess2);
		user2.setName(dummysuccess2);
		user2.setCity("Chennai");
		user2.setEmail("dummysuccess2@gmail.com");
		user2.setPhone("1234567890");
	}
	
	@Before
	public void setUp() {
		user1();
		user2();
	}
	
	/*
	
	@Test
	public void testRegistrationGet() throws Exception {
		this.mockMvc.perform(get("/register")).andExpect(status().isOk()).andExpect(model().attrubuteExists(comand)).
		andExpect(view().name("register")).andDo(print());
	}
	
	@Test
	public void testSubmitCustomerFailsValidation() throws Exception {
		this.mockMvc.perform(post("/registerUser").param("userId", user1.getUserId()).param("password", user1.getPassword()).
				param("name",user1.getName()).param.("city", user1.getCity()).param("email", user1.getEmail())
				.param("Phone", user1.getPhone()));
	}
	
	@Test
	public void testSubmitCustomerPassesValidation() throws Exception {
		this.mockMvc.perform(post("/registerUser").param("userId", user2.getUserId()).param("password", user2.getPassword()).
				param("name",user2.getName()).param.("city", user2.getCity()).param("email", user2.getEmail())
				.param("Phone", user2.getPhone()));
	}
	
	*/
}
