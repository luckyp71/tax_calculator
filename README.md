# Tax Calculator

## RESTful web service to calculate tax using Spring boot, 

## Prerequisites
1. Java 8
2. Spring Boot
3. Spring Data JPA
4. PostgreSQL
5. Docker

## Step to run the project
Since the project used Spring Data JPA and we set its config to auto generate the ddl, so that we do not need define the table manually.
1. Replace the db credential with yours in application.properties and docker-compose.yml files. 
2. Cleaning, installing, and packaging the project by using maven command i.e. mvn clean install package.
3. Create and run docker image of this project by using docker-compose command i.e. docker-compose up -d --build
4. Test this project's web services by using any HTTP client tool or curl command.
5. Once you have done, you could simply run "docker-compose down" command to stop all containers which are running inside your docker.

All references could be found in "./src/main/resources/assets/" folder.
