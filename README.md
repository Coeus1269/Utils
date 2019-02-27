# Utils
Attempt at a combined project of all the utils classes

The Classes of this project are STATIC classes that house commonly used methods for formatting and validating various elements.
It is my belief that each jar/package should contain one area of functionality to provide the most flexibility without having vast amounts of unnecessary code included in each project. 

Each package is intended to be compiled into a single jar, for each class, to be included in other projects. Part of the overall objective is to have robust functionality with minimum dependencies.

String Utils - Collection of string utilities gathered over the years into one location
  - Built in Java 1.7 - Current version: 1.23<br>
  Dependency on: java.net.URLEncoder ;
	java.io.UnsupportedEncodingException ;


SQL Utils - Collection of SQL utilities gathered over the years into one location
  - Built in Java 1.7 - Current version: 1.23<br>

  	
Date Utils - Collection of date utilities
  - Built in Java 1.7 - Current version: 1.23<br>
  
 
Email Utils - under construction, intended to be a collection of email address handling and validating utilities
  - Built in Java 1.7 - Current version: 1.23<br>


People Utils - a collection of common Name parsing and handling methods
  - Built in Java 1.7 - Current version: 1.23<br>
  Dependency on: StringUtils


Locale Utils - a collection of common Locale parsing and handling methods
  - Built in Java 1.7 - Current version: 1.23<br>


Phone Utils - a collection of common Phone Number processing and handling methods
  - Built in Java 1.7 - Current version: 1.23<br>
  Dependency on: StringUtils
  
  
Number Utils - a collection of common Number parsing and handling methods
  - Built in Java 1.7 - Current version: 1.23<br>


Database Utilities
  - Built in Java 1.7 - Current version: 1.23<br>
  Dependency on: mysql-connector-java-5.1.47.jar

DBconnectMySQL - simplified MySQL database connector and query execution, with minimal dependencies on javax.sql, java.sql and com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource. Also uses connection pooling

RSToConsole - a java class to display a record set to the console in various formats for assisting in trouble shooting
  - Built in Java 1.7 - Current version: 1.23<br>

