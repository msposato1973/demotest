package com.gocity.demo.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.model.CustomersDTO;
import com.gocity.demo.util.AbstractTest;

@ExtendWith(MockitoExtension.class)
class CustomersServiceTest extends AbstractTest{
	
	 
	 
	
	@BeforeEach
	void setUp() throws Exception {
		 
		service = new CustomersService(repository);
	}
	
	@Test
	void testFindAll() throws Exception {

        try {
            Mockito.when(repository.findAll()).thenReturn(buildListCustomers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
     // Execute the service that uses the mocked repository
        List<CustomersDTO> listDto = service.findAll();
        
     // Validate the response
        Assertions.assertNotNull(listDto);
        Assertions.assertEquals(2, listDto.size());
	}
	
	
	@Test
	void testAddCustomer() throws Exception {
		 Customers newCustomers = new Customers(1, "Massimo", "Sposato");
		 
		
		 
		 try {
	         // Execute the service that uses the mocked repository
	            CustomersDTO responsedto  = service.addCustomer(newCustomers);
	            
	            Assertions.assertNotNull(responsedto);
	            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	

	 
	 
}
