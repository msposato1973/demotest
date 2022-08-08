package com.gocity.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
import com.gocity.demo.repository.CustomersRepository;
import com.gocity.demo.service.exception.CustomersNotFoundException;

@Service
public class CustomersService implements ICustomersService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomersService.class);
	
	private final CustomersRepository customersRepository;
	
	public CustomersService(CustomersRepository customersRepository) throws Exception {
		this.customersRepository = customersRepository;
	}

	@Override
	public CustomersDTO addCustomer(Customers entity) throws Exception {
		
		logger.info("Service addCustomer: begin");
		Customers newCustomers = customersRepository.saveAndFlush(entity);
		
		return customerToDto(newCustomers);
	}

	
	/***
	 * 
	 * @param customers
	 * @return
	 * @throws Exception
	 */ 
	private  CustomersDTO customerToDto(Customers customers) throws Exception {
		logger.info("Service customerToDto: begin");
		return (customers!=null) ? new CustomersDTO(
										customers.getId(), 
										customers.getFirstname(), 
										customers.getSurname()
									) : new CustomersDTO();
	}

	@Override
	public Map<String, String> removeCustomer(Integer customersId) throws Exception {
		logger.info("Service removeCustomer: begin");
		Customers customer =  customersRepository.findById(customersId)
	            .orElseThrow(() -> new CustomersNotFoundException("Customer not found for this id :: " + customersId)
	     );
		
		Map<String, String> response = new HashMap < > ();
		customersRepository.delete(customer);
    
        response.put("deleted", "success");
        
		return response;
	}
	
	

	@Override
	public CustomersDTO findById(Integer customersId) throws Exception {
		logger.info("Service findById: begin");
		Customers customer = customersRepository.findById(customersId)
	            .orElseThrow(() -> new Exception("Customers not found :: " + customersId)
	     );
		
		Customers employee = customersRepository.findById(customersId)
				.orElseThrow(() -> new CustomersNotFoundException("Customer not found for this id :: " + customersId));
		
		return customerToDto(customer);
		 
	}

	@Override
	public List<CustomersDTO> findAll() throws Exception {
		
		logger.info("Service findAll: begin");
		List<Customers> list = customersRepository.findAll();
		List<CustomersDTO> listDTO = new ArrayList<>();
		
		for (Customers element : list)  listDTO.add(customerToDto(element));
		 
		return listDTO;
	}

}
