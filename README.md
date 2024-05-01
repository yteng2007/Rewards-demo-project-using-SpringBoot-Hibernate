Requirement.

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
 
Solve using Spring Boot
Create a RESTful endpoint
Make up a data set to best demonstrate your solution
Be sure to include unit tests (parameterized tests)
Check solution into GitHub

# rewards
demo retailer rewards program using Sring Boot JPA RESTFUL service

This project uses Spring Boot + Spring Restful API + JPA/H2 DB + Maven + Junit 5 parameterized test + OpenAPI/Swagger

Swagger UI is at

	http://localhost:8080/swagger-ui/index.html
	
API doc is at 

	http://localhost:8080/v3/api-docs/

H2 DB console is at 

	http://localhost:8080/h2-console
	
To build project, run command from terminal with 
	
	mvn clean install
	
To start embedded Tomcat, , run command from terminal with 
	
	java -jar target/rewards-0.0.1-SNAPSHOT.war
