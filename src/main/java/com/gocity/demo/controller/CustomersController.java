    package com.gocity.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gocity.demo.WebParams;
import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
import com.gocity.demo.service.CustomersService;
import com.gocity.demo.service.ICustomersService;
import com.gocity.demo.service.exception.CustomersForbiddenException;
import com.gocity.demo.service.exception.CustomersNotFoundException;

@RestController
@RequestMapping(WebParams.API)
public class CustomersController extends AbstractController{
	
	 
	private static final Logger logger = LoggerFactory.getLogger(CustomersController.class);
	
	private final ICustomersService customersService;
	
	/***
	 * Constructor
	 * @param CustomersService customersService
	 */
	public CustomersController(CustomersService customersService){
			this.customersService = customersService;
	}

	
	/***
	 * 
	 * @param Customers
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = WebParams.ADD_CUSTOMER)
	public ResponseEntity<Object> addCustomers(@RequestBody Customers customers) throws Exception {
		logger.info("addCustomers: begin");
		
		if(!validateCustomer(customers)) {
			throw new CustomersForbiddenException("Impossible request not valid " );
		}
		
		
		CustomersDTO antityDTO = customersService.addCustomer(customers);
		return (antityDTO == null) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(antityDTO, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping(path = WebParams.ALL_CUSTOMER)
    public ResponseEntity<Object> getAllCustomers() throws Exception {
		logger.info("getInstructors: begin");
		 
		return buildResponseEntity(customersService.findAll());
       
    }

	


	@DeleteMapping(path = WebParams.REMOVE_CUSTOMER)
    public ResponseEntity<Object> deleteCustomers(
        @PathVariable(value = "id") Integer customersId) throws Exception {
		logger.info("deleteCustomers: begin");
		
		if(customersId == null || customersId == 0) return  buildBedRequestResponseEntity();
		 
		
		Map<String, String> response = customersService.removeCustomer(customersId);
      	return buildResponseEntity(new ResponseEntity<>(response, HttpStatus.ACCEPTED));
    }
	 
	

	@GetMapping(path = WebParams.FINDBYID_URL)
    public ResponseEntity < Object > getCustomersById(
        @PathVariable(value = "id") Integer instructorId) throws   Exception {
		logger.info("getCustomersById: begin");
		CustomersDTO antityDTO = customersService.findById(instructorId);
		if (antityDTO!=null) {
			return ResponseEntity.ok().body(antityDTO);
		} else {
			return buildNonFoundResponseEntity();
		}
        
    }
}
