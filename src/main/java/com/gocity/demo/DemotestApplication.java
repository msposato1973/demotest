package com.gocity.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gocity.demo.entity.Customers;
import com.gocity.demo.repository.CustomersRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class DemotestApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemotestApplication.class);

	public static void main(String[] args) {
		logger.info("main - DemotestApplication.run: begin");
		SpringApplication.run(DemotestApplication.class, args);
	 }

	 @Bean
	    CommandLineRunner initializeData(@Autowired CustomersRepository customersRepository) {
		    logger.info("main - DemotestApplication.initializeData: begin");
	        
		    return args -> {
	            customersRepository.save(new Customers(1, "Max", "Sposato"));
	            customersRepository.save(new Customers(2, "Mary", "Teamseal"));
	            customersRepository.save(new Customers(3, "Mary", "Wolf"));
	            customersRepository.save(new Customers(4, "Mary", "Gallagher"));
	            customersRepository.save(new Customers(5, "Marrie", "Smith"));
	        };
	    }
	 
}
