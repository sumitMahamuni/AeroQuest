package com.aeroQuest.ars.endpoints;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="myendpoint")
public class MyEndpoint {
	
	private Map<String, String> myUsers = new HashMap<>();
	
	@ReadOperation
	public Map<String, String> features() {
		myUsers.put("Firstuser", "Abhinaya");
		myUsers.put("SecondUser", "Viveka");
		return myUsers;
	}
	
	@WriteOperation
	public String writeOperation(String name) throws MalformedURLException {
		return name + "\t in HTTP POST method";
	}
	
	@DeleteOperation
	public String deleteOperation() {
		return "HTTP DELETE method";
	}
}
