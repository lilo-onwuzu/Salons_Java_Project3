// create database class that will be part of the package and called in all the tests
// postgres server is the server or database management system that will save our custom objects so in case the system powers down for instance, our work will be secure and we will not have to start all over.
// databases also create an easy way of handling and manipulating data of in our objects
// postgres server connection ports to 5432
// DB is the class and sql2o is the method
// sql2o is the java method that allows us to easily form objects from data saved in the postgres database
// "jdbc:postgresql://localhost:5432/to_do" is a URL that Java can use to access the database. The first part of the URL is the jdbc:postgresql driver that we installed to access the Postgres serve. The next part tells it to look at localhost to find the server, and to access it over port 5432.
// the second and third arguments are the postgres username and database password. there are no persmissions needed for this database connection therefore "null", "null"

import org.sql2o.*;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", null, null);
}
