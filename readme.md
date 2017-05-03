## _Title_
	Epicodus- Java - Stylists & Clients
	
#### _Creator_
	Lilo Onwuzu 
	
#### _Date_
	05.16.2016

#### _Description_
		This site uses the concepts of RESTful routing to set up a web application to link up Stylists with their Clients. 
		It uses two classes: Stylist and Clients in a many to many relationship. 
		The user can add as many Stylists as possible and their details (e.g name) as attributes of the Stylist class 
		The user can add as many Clients with their details to each Stylist.
		The test application was backed with a Postgres database server (local- see set up instructions) 
		Restful web pages are routered and rendered through the Spark Framework. 
		Velocity tool is used to create html (with lightweight java code) templates for our Spark routines (get/post etc).
		VelocityTemplateEngine is used as an adapter to add Velocity templates to our Spark routines.	
		The code was designed using Behavoir Driven Development (BDD) testing principles. 
		The unit testing of the backend is done using jUnit. 
		The integration testing of the user interface was done using Selenium Webdriver tests and a FluentLenium Adapter. 
		All testing dependencies were managed using Gradle. 

#### _Setup/Installation Requirements_
	Set Up To Run Database Locally On Computer:
		First clone this repository
		Install Postgres
		Run "pg_ctl start" in terminal to start running postgres server
		Run "psql" in a new terminal to access DB
		In psql: 
			Run "CREATE DATABASE hair_salon;"
			Run "CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;"
		In Terminal:
			Run "psql hair_salon < hair_salon.sql"
			Run "psql hair_salon_test < hair_salon_test.sql"
		Install Gradle (a build & test automation program that will manage all our dependencies)
		Build in the terminal using 'gradle run' command
		Open localhost:4567/stylists in any browser to use the web application
		Interact with the app.

#### _Known Bugs_
 	None

#### _Support and contact details_
	lpr422@gmail.com
	
#### _Technologies Used_
	HTML, CSS, Object Oriented Java, SQL on POSTGREs DB, Selenium Web Driver- UI Testing, Fluentinum Adapter,
	jUnit backend testing, Spark Framework, Velocity Templates, Velocity Template Engine, RESTful routing
	Many to Many Database Relationships, Gradle Dependency Manager, BDD Testing

#### _License_
	This software is licensed under the MIT license
	Copyright (c) 2016 IPONWUZU



