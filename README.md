Hair Salons Web Application for Epicodus Level 2 Java Project 3:

By Ililochi Onwuzu

Description:

 backed Directory web application to link up Stylists with their Clients. It uses two classes/units: Stylist and Clients in a one to many relationship. The user can add as many Stylists as possible and their details (e.g name) as attributes of the Stylist class and add as many Clients with their details to each Stylist. The code was designed using BDD testing principles. The units were automatically build in gradle, tested independently using jUnit and the integration/Selenium tests were done Fluentinum.

Setup/Installation Requirements :

. First clone this repository . Install auto-build and test application such as Gradle . Build in the terminal using 'gradle run' command . Database Set-Up In PSQL: CREATE DATABASE hair_salon; \c to_do; CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylist_id int); CREATE TABLE stylists (id serial PRIMARY KEY, name varchar); CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon; . Open localhost:4567 in any browser to use the web application

Known Bugs:

None

Support and contact details:

lpr422@gmail.com

Technologies Used:

HTML, CSS, Object Oriented Java, POSTGREs DB backed, Fluentinum/Selenium, Gradle, BDD Testing, jUnit, Apache Spark, Apache Velocity

License

This Software Is Licensed Under MIT.

Copyright (c) 2015 Onwuzu, LPO Inc.
