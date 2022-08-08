package com.gocity.demo.model;

import java.io.Serializable;

public class CustomersDTO implements Serializable{
 
    private static final long serialVersionUID = 1L;
    
	private Integer id;
	private String firstname;
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

	public CustomersDTO(Integer id, String firstname, String surname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
	}
	
	public CustomersDTO(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}
	
	 
	public CustomersDTO() {
		super();
	}

	
}
