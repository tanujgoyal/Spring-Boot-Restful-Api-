package com.spring.rest.restfulwebservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//Purpose - This class will read the value from specialist properties files and set into the map.

@Configuration
public class HospitalApplicationConfig {

	@Autowired
	private SpecialistProperties specialistProperties ;
	
	
	public Map<String, String> readFromProeprtiesFile() {
				
		Map<String,String> map = new HashMap<>(); 
		
	    map.put("name", specialistProperties.getSpecialistName());
	    map.put("availableDay", specialistProperties.getAvailableDay()); 
	    map.put("availableTime", specialistProperties.getAvailableTime());
	   
	  
		
		 return map;
	}
		
}
