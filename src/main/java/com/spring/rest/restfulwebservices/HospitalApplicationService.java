package com.spring.rest.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Purpose - This class will handle all the request which will come from Rest Controller. 

@Component
public class HospitalApplicationService {

	@Autowired
	private HospitalApplicationConfig hospitalApplicationConfig ;
	
	private static List<HospitalVO> hospitals = new ArrayList<>();
	private static List<SpecialistVO> specilaists = new ArrayList<>();
	private static List<PatientVO> patients = new ArrayList<>();
	
	
	public List<HospitalVO> populateHospitalList(){
		
		SpecialistVO specialistOne = new SpecialistVO("Dentist", "Sandhya", "Monday,Wednesday", "5 To 6", "Y", "946");
		SpecialistVO specialistSecond = new SpecialistVO("Dentist", "Saranya", "Monday,Thursday", "6 To 8", "N", "946");
		SpecialistVO specialistThird = new SpecialistVO("Sergon", "Manoj", "Tuesday", "2 To 4", "Y", "800");
		SpecialistVO specialistFour = new SpecialistVO("Ortho", "Amit", "Friday", "10 To 2", "Y", "800");
		
		specilaists.add(specialistOne);
		specilaists.add(specialistSecond);
		specilaists.add(specialistThird);
		specilaists.add(specialistFour);
		
		PatientVO patientOne = new PatientVO("Tanuj", "Goyal", "30", "DISCHARGE","946");
		PatientVO patientSecond = new PatientVO("Ankit", "Gupta", "33", "DISCHARGE","946");
		PatientVO patientThird = new PatientVO("Mohit", "Sharma", "40", "ADMIT","800");
		PatientVO patientFour = new PatientVO("Rohit", "Sharma", "25", "ADMIT","800");
		
		patients.add(patientOne);
		patients.add(patientSecond);
		patients.add(patientThird);
		patients.add(patientFour);
		
				
		HospitalVO hospitalOne = new HospitalVO("946", "Global", new ArrayList<>(Arrays.asList(specialistOne , specialistSecond)),
				new ArrayList<>(Arrays.asList(patientOne , patientSecond)));
		HospitalVO hospitalSecond = new HospitalVO("800", "Columbia", new ArrayList<>(Arrays.asList(specialistThird , specialistFour)),
				new ArrayList<>(Arrays.asList(patientThird , patientFour)));
		
		hospitals.add(hospitalOne);
		hospitals.add(hospitalSecond);
		
		
		return hospitals;
	}
	
	// Requirement 1 - Retrieve Specialist Details
	
	public List<SpecialistVO> populateSpecialistVO(String hospitalName , String specialistType){
		
		List<HospitalVO> hospitalList = new ArrayList<HospitalVO>();
		hospitalList=populateHospitalList();
		
		String matchHospital = null;
		List<SpecialistVO> specialistVOFoundList=new ArrayList<SpecialistVO>();
		specialistVOFoundList.clear();
		boolean specilistFound = false ;
		for (HospitalVO hospitalVO : hospitalList) {
			if(hospitalName.equalsIgnoreCase(hospitalVO.getHospitalName()))
			{
				matchHospital=hospitalVO.getHospitalName();
			}
		}
		
		if(matchHospital == null) {
			throw new HospitalApplicationException( hospitalName + " Hospital Details Not Found");
			
		}
		
		if(matchHospital !=null)
		{	
			for (SpecialistVO specialistVO : specilaists) {
				if(specialistType.equalsIgnoreCase(specialistVO.getSpecialistType()))
				{
					specilistFound= true;
					specialistVOFoundList.add(specialistVO);
				}
				
			}
		}	
		
		  if(!specilistFound) { 
			  throw new HospitalApplicationException(specialistType + " Specialist Details Not Found in " + hospitalName + " hospital"); 
			  }
		 		
		specilaists.clear();
		return specialistVOFoundList;
		
	}
	
	
	// Requirement 2– Return a New Appointment
	public AppointmentVo getAppointment(String specialistName, String appointmentDay, String patientName) {		
		AppointmentVo appointment = new AppointmentVo();
		Map<String, String> map = hospitalApplicationConfig.readFromProeprtiesFile();

		String name = map.get("name");
		String availableDay = map.get("availableDay");
		String availableTime = map.get("availableTime");

		if (specialistName.equalsIgnoreCase(name) && appointmentDay.equalsIgnoreCase(availableDay)) {
			
			appointment.setSpecialistName(specialistName);
			appointment.setAvailableDay(availableDay);
			appointment.setPatientName(patientName);
			appointment.setAvailableTime(availableTime);
			return appointment;

		}

		return null;
	}
	
	
	// Requirement 3:– Return Number of beds available in the hospital for Admission 
	public Integer getPatientDischargeCount(String hospitalName){		
		String matchHospital = null;
		String hospitalId = null;
		int bedCount = 0;
		List<HospitalVO> hospitalList = new ArrayList<HospitalVO>();
		hospitalList=populateHospitalList();
		
		for (HospitalVO hospitalVO : hospitalList) {
			if(hospitalName.equalsIgnoreCase(hospitalVO.getHospitalName()))
			{
				matchHospital=hospitalVO.getHospitalName();
				hospitalId = hospitalVO.getHospitalId();
			}
		}
		
		if(matchHospital == null) {
			throw new HospitalApplicationException( hospitalName + " Hospital Details Not Found");
			
		}
		
		if(matchHospital !=null)
		{	
			for (PatientVO patientVO : patients) {
				if("DISCHARGE".equalsIgnoreCase(patientVO.getPatientStatus()) && hospitalId.equalsIgnoreCase(patientVO.getHospitalId()))
				{
					bedCount ++ ;  
				}
				
			}
		}
		
		if(bedCount == 0) {
			throw new HospitalApplicationException(" Beds are not available for Admission in " + hospitalName + " hospital");
		}
		patients.clear();
		
		return bedCount;
		
	}
		

}	