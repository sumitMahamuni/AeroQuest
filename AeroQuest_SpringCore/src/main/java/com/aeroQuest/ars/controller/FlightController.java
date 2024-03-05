package com.aeroQuest.ars.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.aeroQuest.ars.model.SearchFlights;

@Controller
public class FlightController {

	@Autowired
	private Environment environment;
	private final RestTemplate restTemplate;
	public FlightController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@RequestMapping(value="/searchFlights", method=RequestMethod.POST)
	public ModelAndView flightSearch(@Valid @ModelAttribute("Command") SearchFlights searchFlights, BindingResult bindingResult, ModelMap model) {
		String restUrl = environment.getProperty("RestUrl");
		ModelAndView modelAndView = null;
		List<SearchFlights> availableFlights = restTemplate.getForObject(restUrl+"/FlightAPI" + searchFlights.getSource()+"/"
					+searchFlights.getDestination()+"/"+searchFlights.getJourneyDate(), List.class);
		
		model.addAttribute("availableFlights", availableFlights);
		model.addAttribute("size", availableFlights.size());
		modelAndView = new ModelAndView("searchFlights", "command", searchFlights);
		
		return modelAndView;
	}
	
}
