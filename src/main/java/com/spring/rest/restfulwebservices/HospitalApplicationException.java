package com.spring.rest.restfulwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Purpose - This class will handle the run time exception.

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HospitalApplicationException extends RuntimeException{
	
	public HospitalApplicationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub 
	}

}
