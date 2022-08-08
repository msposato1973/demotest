package com.gocity.demo.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomersNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	 

	/***
	 * 
	 * @param String description
	 * 
	 */
	public CustomersNotFoundException(String description) {
		super(description);
	}

	 
}
