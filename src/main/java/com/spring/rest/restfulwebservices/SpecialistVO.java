package com.spring.rest.restfulwebservices;

//Purpose - This class will contain the specialist details.

public class SpecialistVO {
	
	String specialistType;	
	String specialistName;	
	String availableDay;	
	String availableTime;	
	String isAvailable;	
	String hospitalId;
	
	
	public SpecialistVO() {
		super();
	}
	public SpecialistVO(String specialistType, String specialistName, String availableDay, String availableTime,
			String isAvailable, String hospitalId) {
		super();
		this.specialistType = specialistType;
		this.specialistName = specialistName;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
	}
	public String getSpecialistType() {
		return specialistType;
	}
	public void setSpecialistType(String specialistType) {
		this.specialistType = specialistType;
	}
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
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	@Override
	public String toString() {
		return "SpecialistVO [specialistType=" + specialistType + ", specialistName=" + specialistName
				+ ", availableDay=" + availableDay + ", availableTime=" + availableTime + ", isAvailable=" + isAvailable
				+ ", hospitalId=" + hospitalId + "]";
	}
	
	
	
}
