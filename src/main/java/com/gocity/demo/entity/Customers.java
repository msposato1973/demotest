package com.gocity.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customers_id")
    private Integer id;
	
	 
	@Column(name = "firstname", nullable = false)
	private String firstname;
	
	@Column(name = "surname", nullable = false)
	private String surname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Customers(Integer id, String firstname, String surname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
	}
	
	public Customers(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}
	
	public Customers() {
		super();
	}
	
	

}
