package com.aeroQuest.ars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public ModelAndView getHomeDetails() {
		return new ModelAndView("AeroQuest", "", "");
	}
	

}