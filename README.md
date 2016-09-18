## Osmar Horas repository

##Prerequisites - Development environment
JDK 8 -> Details in https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html<br>
Maven -> Details in https://maven.apache.org/<br>
Apache Tomcat 7 -> Details in http://tomcat.apache.org/<br>

##Prerequisites - Server environment
Apache Tomcat 7 - Details in http://tomcat.apache.org/<br>
Mysql - Details in https://www.mysql.com/<br>

## Installation & Execution
Import the database, with osmar_horas.sql
```
mvn clean install
```
Do not forget to initialize the tomcat7, before the next command!
<br>
```
mvn tomcat7:run
```
