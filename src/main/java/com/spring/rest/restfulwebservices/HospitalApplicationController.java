package com.spring.rest.restfulwebservices;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//Purpose - This is a Rest Controller class which will accept the input and return the output.

@RestController
public class HospitalApplicationController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private HospitalApplicationService hospitalApplicationService;

	@Value("${spring.type}")
	private String type;

	@Value("${spring.environment}")
	private String environment;

	@Value("${spring.port}")
	private String port;

	@Value("${spring.url}")
	private String url;

	@Value("${spring.hospitalName}")
	private String hospitalName;

	@Value("${spring.specialistType}")
	private String specialistType;

	
	
	// Requirement 1 - Retrieve Specialist Details

	@GetMapping(value = "${spring.getSpecialistDetails}/{hospitalName}/{specialistType}", produces = {
			"application/json", "application/xml" })
	public List<SpecialistVO> getSpecialistDetails(@PathVariable String hospitalName,
			@PathVariable String specialistType) {

		List<SpecialistVO> specialList = new ArrayList<SpecialistVO>();
		specialList = hospitalApplicationService.populateSpecialistVO(hospitalName, specialistType);

		return specialList;
	}

	// Requirement 2– Return a New Appointment

	@GetMapping("${spring.getAppointment}/{specialistName}/{appointmentDay}/{patientName}")
	public AppointmentVo getAppointment(@PathVariable String specialistName, @PathVariable String appointmentDay,
			@PathVariable String patientName) {

		AppointmentVo appointmentbooked = hospitalApplicationService.getAppointment(specialistName, appointmentDay,
				patientName);
		if (appointmentbooked == null) {
			throw new HospitalApplicationException(
					"Specialist Doctor - " + specialistName + " is not available on " + appointmentDay);
		}

		return appointmentbooked;

	}

	// Requirement 3 – Return Number of beds available in the hospital for Admission

	@GetMapping("${spring.bedAvailable}/{hospitalName}")
	public String getPatientDischargeCount(@PathVariable String hospitalName) {

		int bedCount = hospitalApplicationService.getPatientDischargeCount(hospitalName);

		String bedCountToString = Integer.toString(bedCount);
		String bedAvailable = "Number of Beds of Available is = ".concat(bedCountToString);

		return bedAvailable;
	}
	
	// Requirement 4 - Write a REST client using Rest Templates to test the Requirement 1

	@GetMapping("${spring.testSpecialistDetails}")
	public List<SpecialistVO> SpecialistDetailsJson() throws URISyntaxException {
		List<SpecialistVO> specialistVO = GetSpecialistDetailsJson(type,environment,port,url,hospitalName,specialistType);

		 return specialistVO;		

	}

	public List<SpecialistVO> GetSpecialistDetailsJson(String type, String environment, String port, String url, String hospitalName,
			String specialistType) {

		String serviceURL = type.concat(environment).concat(port).concat(url).concat(hospitalName)
				.concat(specialistType);
		
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); 
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML)); 
		  HttpEntity<SpecialistVO> entity = new HttpEntity<SpecialistVO>(headers);
		  
		  ResponseEntity<List<SpecialistVO>> response = restTemplate.exchange(serviceURL, HttpMethod.GET,entity, new ParameterizedTypeReference<List<SpecialistVO>>(){});
		  
		  List<SpecialistVO> specialistResponse = response.getBody();
		 

		 return specialistResponse;

	}
	
	
	

}
 