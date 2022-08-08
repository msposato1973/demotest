package com.gocity.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;

public class AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
	 
	/***
	 *  
	 * @param antityDTO
	 * @return
	 */
	protected ResponseEntity<Object> buildResponseEntity(CustomersDTO antityDTO) {
		logger.info("buildResponseEntity: begin");
		return new ResponseEntity<>(antityDTO, HttpStatus.CREATED);
	}
	
	/***
	 * 
	 * @param antityDTO
	 * @return
	 */
	protected ResponseEntity<Object> buildResponseEntity(Object antityDTO) {
		logger.info("buildResponseEntity: begin");
		  	 
		return (antityDTO == null) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(antityDTO, HttpStatus.OK);

	}
	
	/***
	 * 
	 * @param  List<CustomersDTO> antityDTO
	 * @return ResponseEntity<Object> 
	 */
	protected ResponseEntity<Object> buildResponseEntity(List<CustomersDTO> antityDTO) {
		logger.info("buildResponseEntity: begin");
		  	 
		return (antityDTO == null || antityDTO.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(antityDTO, HttpStatus.OK);

	}
	
	/***
	 *  
	 * @param antityDTO
	 * @param created
	 * @return
	 */
	protected ResponseEntity<Object> buildResponseEntity(CustomersDTO antityDTO, HttpStatus created) {
		logger.info("buildResponseEntity: begin");
		return (antityDTO!=null) ?   new ResponseEntity<>(antityDTO, created) :  buildNonFoundResponseEntity();
	}
	
	/***
	 *  
	 * @param antityDTO
	 * @param created
	 * @return
	 */
	protected ResponseEntity<Object> buildNonFoundResponseEntity() {
		logger.info("buildNonFoundResponseEntity: begin");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/***
	 *  
	 * @param antityDTO
	 * @param created
	 * @return
	 */
	protected ResponseEntity<Object> buildBedRequestResponseEntity() {
		logger.info("buildBedRequestResponseEntity: begin");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	protected boolean validateCustomer(Customers antity) {
		return (antity.getFirstname()!=null && antity.getSurname()!=null);
	}
}
