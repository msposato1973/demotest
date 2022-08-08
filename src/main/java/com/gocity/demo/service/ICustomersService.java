package com.gocity.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
 

@Component
public interface ICustomersService {
	
	/**
	 * 
	 * @param customers
	 * @return
	 * @throws Exception
	 */
	CustomersDTO addCustomer(Customers customers) throws Exception ;
	 
	/***
	 * 
	 * @param customersId
	 * @return
	 * @throws Exception
	 */
	Map<String, String> removeCustomer(Integer customersId) throws Exception;
	
	/***
	 * 
	 * @param customersId
	 * @return
	 * @throws Exception
	 */
	CustomersDTO findById(Integer customersId) throws Exception;

	/***
	 * 
	 * @return
	 * @throws Exception
	 */
	List<CustomersDTO> findAll() throws Exception;
	

}
