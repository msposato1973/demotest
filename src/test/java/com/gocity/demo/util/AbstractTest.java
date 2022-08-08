package com.gocity.demo.util;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
import com.gocity.demo.repository.CustomersRepository;
import com.gocity.demo.service.CustomersService;

public class AbstractTest {
	

	public static final Integer ID = buildId();
	

	@InjectMocks
	public CustomersService service;
	
	@Mock
	public  CustomersRepository repository;
	
	

	public List<Customers> buildListOfCustomers() {

		List<Customers> listOptional = List.of(buildCustomers(), new Customers(buildId(), "Alan", "Sepe"));
		return listOptional;
	}

	public List<CustomersDTO> buildListOfCustomersDTO() {

		List<CustomersDTO> listOptional = List.of(buildCustomersDTO(), new CustomersDTO(buildId(), "Alan", "Sepe"));
		return listOptional;
	}
	
	public Customers buildCustomers() {
		return new Customers(ID, "Massimo", "Sposato");
	}
	
	public List<Customers> buildListCustomers() {
		List<Customers> localList = List.of(new Customers(1, "Massimo", "Sposato"), new Customers(6, "Stefano", "Di Rella"));
		return localList;
	}
	
	public CustomersDTO buildCustomersDTO() {
		return new CustomersDTO(ID, "Massimo", "Sposato");
	}


	public static Integer buildId() {
		Random ran = new Random();
		int x = ran.nextInt(1) + 5;
		return Integer.valueOf(x);
	}
	
	public String buildAllExpectedCustomers() {
		String expected = "[{\"id\":1,\"firstname\":\"Massimo\",\"surname\":\"Sposato\"},{\"id\":6,\"firstname\":\"Stefano\",\"surname\":\"Di Rella\"}]";
		return expected;
		 
	}
	
	public String buildExpectedCustomers() {
		String expected = "{\"id\":1,\"firstname\":\"Massimo\",\"surname\":\"Sposato\"}";
		return expected;
		 
	}
	
	public String buildExpectedDeleteustomers() {
		String expected = "{\"headers\":{},\"body\":{},\"statusCode\":\"ACCEPTED\",\"statusCodeValue\":202}";
		return expected;
		 
	}
	
	public List<CustomersDTO> buildListCustomersDTO() {
		List<CustomersDTO> localList = List.of(new CustomersDTO(1, "Massimo", "Sposato"), new CustomersDTO(6, "Stefano", "Di Rella"));
		return localList;
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	

	public void checkAssertionsCustomersDTO(CustomersDTO customersdto) {
		Assertions.assertNotNull(customersdto);
		Assertions.assertEquals(ID, customersdto.getId());
		Assertions.assertEquals("Massimo", customersdto.getFirstname());
		Assertions.assertEquals("Sposato", customersdto.getSurname());
	}
	
}
