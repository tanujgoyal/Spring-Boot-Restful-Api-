package com.spring.rest.restfulwebservices;

//Purpose - This class create the appointment details of patient.

public class AppointmentVo {

	private String specialistName;
	private String patientName;
	private String availableDay;
	private String availableTime;
	public String getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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


