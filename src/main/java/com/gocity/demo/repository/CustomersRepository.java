package com.gocity.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gocity.demo.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
