# Java Engineer

### Take home technical test
We require a simple HTTP based RESTful API that provides 3 operations for managing customers.:

These Operations are:
- Operation 1: Add a Customer
- Operation 2: Remove a Customer, given their ID
- Operation 3: List all Customer

Where a Customer has the following attributes:
- Id
- Firstname
- Surname

The API and its Operations should:
- Use JSON for data transfer
- Adhere to REST principles
- Be written using Java
- Be runnable/testable on a Windows or Mac laptop with JDK 8 and Maven 3 installed (e.g. via maven commands or similar)

Have automated tests for each operation

There is no need to persist the data (i.e. no need to use a database)

### Further Guidance

This exercise should take no more than 2.5 hours, assuming your development machine is already configured with Java, and IDE etc. You may use whichever Framework/3rd Party Libraries you wish, as long as they’re publicly available from the central Maven Repository.

### Returning the test

Please zip up your solution and return it via your recruitment contact. Please do not put this exercise anywhere in the public domain.

## Implementation Classes
- Spring Data
- Java 11
- Spring Boot 2.7.2 (with Spring Web MVC, Spring Data JPA)
- H2 Database
- Maven 3.6.1

- Implementation of custome exception 
- Service : CustomersService, ICustomersService
- Repository : CustomersRepository
- Entity : Customers
- CustomizedDTO : Model for Data transfer entity 

## Implementation Interface classes
- ICustomersService
- WebParams : mapping URL/endpoint
 
## For all Settings project informations
 Open src/main/resources/application.properties
 
## Run & Test
Run Spring Boot application with command: mvn spring-boot:run.

tutorials table will be automatically generated in Database.

Let’s open H2 console with url: http://localhost:8080/h2-ui:
http://localhost:8080/h2-console will change to http://localhost:8080/h2-ui.

You can create an executable JAR file, and run the Spring Boot application by using the Maven commands given below

For Maven, you can use the command given below :
mvn clean install

## DOCUMENTTION
location : demotest/doc/index.html
./{projectfolder} /doc/index.html

#### Methods	Urls	Actions
- POST	 /api/vi/addCustomers -> 	create new Customer
- GET	 /api/v1/customers	return list published Customers
- DELETE	 /api/v1/remove/:id	delete a Customer by :id
- GET	 /api/vi/customers/	:id a Customer by :id
 
