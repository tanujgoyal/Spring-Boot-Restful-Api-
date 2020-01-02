package com.spring.rest.restfulwebservices;

//Purpose - This class will contain the patient details.

public class PatientVO {

	private String patientFirstName;
	private String patientLastName;
	private String patientAge;
	private String patientStatus;
	private String hospitalId;
	public PatientVO(String patientFirstName, String patientLastName, String patientAge, String patientStatus,
			String hospitalId) {
		super();
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientAge = patientAge;
		this.patientStatus = patientStatus;
		this.hospitalId = hospitalId;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientStatus() {
		return patientStatus;
	}
	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	@Override
	public String toString() {
		return "PatientVO [patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName
				+ ", patientAge=" + patientAge + ", patientStatus=" + patientStatus + ", hospitalId=" + hospitalId
				+ "]";
	}
	
	
	
}
