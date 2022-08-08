package com.gocity.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.repository.CustomersRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemotestApplicationTests {


	private static final Integer ID = buildId();
	
	@Autowired
	CustomersRepository customersRepository;
	 

	@Test
	@Order(1)
	public  void testCreateCustomers() {
		Customers entityObje = buildCustomers();
		Customers result = customersRepository.save(entityObje);
		
		assertNotNull(result);
		
	}
	
	
	@Test
	@Order(2)
	public  void testUpDateCustomers() {
		Customers entityObje = buildCustomers();
		entityObje.setFirstname("Smith");
		
		Customers result = customersRepository.save(entityObje);
		assertNotNull(result);
		assertTrue(result.getFirstname().equalsIgnoreCase("Smith"));
		
	}
	
	@Test
	@Order(3)
	public  void testReadAllCustomers() {
		List<Customers> resultList =  buildListCustomers();
		resultList.stream().forEach(x->customersRepository.save(x));
		 
		List<Customers> result = customersRepository.findAll();
		
		assertNotNull(result);
		assertThat(resultList).size().isGreaterThan(0);
		
	}
	
	@Test
	@Order(3)
	public  void testFindByIdCustomers() {
		Optional<Customers> result = customersRepository.findById(ID);
		 
		List<Customers> resultList = result.stream().toList();
		
		assertNotNull(result);
		assertThat(resultList).size().isGreaterThan(0);
		
	}
	
	@Test
	@Order(4)
	public  void testRemoveCustomer() {
		
		customersRepository.deleteById(ID);
		Optional<Customers> result = customersRepository.findById(ID);
		assertNotNull(result);
		
	}
	
	

	private List<Customers> buildListCustomers() {
		List<Customers> listCustomers = List.of(
				new Customers(buildId(),  "Mr Poul",  "Mc Curtney"), 
				new Customers(buildId(),  "Mr John",  "Lenon"),
				new Customers(buildId(),  "Mr Jack",  "Daniels")
		);
		
		return listCustomers;
	}
	
	private Customers buildCustomers() {
		return new Customers(ID, "Massimo", "Sposato");
	}
	
	
	
	private static Integer  buildId() {
		Random ran = new Random();
		int x = ran.nextInt(1) + 5;
	    return Integer.valueOf(x);
   }
}
