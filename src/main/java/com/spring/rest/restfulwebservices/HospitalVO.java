package com.spring.rest.restfulwebservices;

import java.util.List;

//Purpose - This class will contain the hospitals details like patient details, specialist details.

public class HospitalVO {
	
	String hospitalId;
	String hospitalName;
	List <SpecialistVO> specialistVO;
	List <PatientVO> patientVO;
	public HospitalVO(String hospitalId, String hospitalName, List<SpecialistVO> specialistVO,
			List<PatientVO> patientVO) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.specialistVO = specialistVO;
		this.patientVO = patientVO;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public List<SpecialistVO> getSpecialistVO() {
		return specialistVO;
	}
	public void setSpecialistVO(List<SpecialistVO> specialistVO) {
		this.specialistVO = specialistVO;
	}
	public List<PatientVO> getPatientVO() {
		return patientVO;
	}
	public void setPatientVO(List<PatientVO> patientVO) {
		this.patientVO = patientVO;
	}
	@Override
	public String toString() {
		return "HospitalVO [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", specialistVO="
				+ specialistVO + ", patientVO=" + patientVO + "]";
	}
	
	
}
