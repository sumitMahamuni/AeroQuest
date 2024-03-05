package com.aeroQuest.ars.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aeroQuest.ars.service.FlightService;

@RestController
@RequestMapping("FlightAPI")
public class FlightAPI {
	
	@Autowired
	private FlightService flightService;
	
	/*
	@GetMapping(value = "/{source}/{destination}/{journeyDate}", headers = "Accept-application/json")
	public List<SearchFlights> searchFlights(@PathVariable String source, @PathVariable String destination, 
			@PathVariable String journeyDate) throws Exception{
		Calender jDate = CalenderUtility.getCalendarFromString(journeyDate);
		List<SearchFlights> availableFlights = flightService.getFlights(source, destination, jDate);
		return availableFlights;
	}
	*/
	
	@RequestMapping(value = "/source", method=RequestMethod.GET, headers="Accept=application/json")
	public List<String> getSources() throws Exception {
		try {
			List<String> s1 = flightService.getSorces();
			return s1;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@RequestMapping(value="/destination", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<String>> getDestinations() throws Exception {
		List<String> s2 = flightService.getDestinations();
		return new ResponseEntity<List<String>>(s2, HttpStatus.OK);
	}

}
