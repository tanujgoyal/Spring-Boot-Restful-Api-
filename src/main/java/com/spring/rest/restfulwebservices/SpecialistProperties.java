package com.spring.rest.restfulwebservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//PropertySource("classpath:specialist.properties")


@Component
@PropertySource("classpath:specialist.properties")
@ConfigurationProperties
public class SpecialistProperties {

	
	private String specialistName;	
	private String availableDay;
	private String availableTime;
	public String getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}
	public String getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	
	
}
