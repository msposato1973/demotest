package com.gocity.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gocity.demo.WebParams;
import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
import com.gocity.demo.repository.CustomersRepository;
import com.gocity.demo.service.CustomersService;
import com.gocity.demo.util.AbstractTest;

@RunWith(SpringRunner.class)
@WebMvcTest(value= CustomersController.class)
@WithMockUser
class  CustomersControllerTest extends AbstractTest{
	
	 
	
	private List<Customers> list;
	
	@Autowired
    private MockMvc mockMvc;

	@MockBean
    private CustomersService customersServiceMock;
	
	@MockBean
    private  CustomersRepository mockRepository;
	
	private static final String URL_ALL =  WebParams.API + WebParams.ALL_CUSTOMER;
	private static final String URL_ADD =  WebParams.API + WebParams.ADD_CUSTOMER;
	private static final String URL_REMOVE =  WebParams.API + WebParams.ALL_API  + "remove" + WebParams.ALL_API + 1;
	
	@BeforeEach
	void setUp() throws Exception { }
	
	@Test
	void  getAllCustomersTest() throws Exception {
	 
		 when(mockRepository.findAll()).thenReturn(list);
		 Mockito.when(customersServiceMock.findAll()).thenReturn(buildListCustomersDTO());
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL_ALL).accept(MediaType.APPLICATION_JSON);
		 
		 MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		  
		 
		 String expected = buildAllExpectedCustomers();
		 JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	void addCustomersTest() throws Exception {
		
		 Customers newCustomers = new Customers(1, "Massimo", "Sposato");
		 CustomersDTO responsedto = new CustomersDTO(1, "Massimo", "Sposato");
		 
		 when(mockRepository.saveAndFlush(new Customers(1, "Massimo", "Sposato"))).thenReturn(newCustomers);
		 when(customersServiceMock.addCustomer(any(Customers.class))).thenReturn(responsedto);
		 Mockito.when(customersServiceMock.addCustomer(newCustomers)).thenReturn(responsedto);
		 
		 MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADD)
			      .contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"id\":1,\"firstname\":\"Massimo\",\"surname\":\"Sposato\"}")).andReturn();
		 
		 int status = mvcResult.getResponse().getStatus();
		 assertEquals(201, status);
		  
		 
		 
		 String expected = buildExpectedCustomers();
		 JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
					 
	}
	
	@Test
	public void deleteCustomerstest() throws Exception 
	{
	 
	   MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URL_REMOVE)).andReturn();
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	    
	   String expected = buildExpectedDeleteustomers();
	   JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
		 
	    
	}
	
 
}
