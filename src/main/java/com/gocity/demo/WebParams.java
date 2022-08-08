package com.gocity.demo;

public interface WebParams {
 
	public static final String ALL_API = "/";
	public static final String API = ALL_API + "api/v1";
	public static final String ID = "/" + "{id}";
   
    
    //Operation 1: Add a Customer
    public static final String ADD_CUSTOMER = ALL_API + "addCustomers";
    
    //Operation 2: Remove a Customer, given their ID
    public static final String REMOVE_CUSTOMER = ALL_API +"remove" + ID;
    
    //Operation 3: List all Customers
    public static final String ALL_CUSTOMER = ALL_API + "customers";
    
   //Operation 4: Get a Customer, given their ID
    public static final String FINDBYID_URL = ALL_API + "customers" + ID;
    
  //Operation 3: List all Customers
    public static final String BASE_CUSTOMER = ALL_API + "customers";
    
    

}
