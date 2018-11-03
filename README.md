<h1>Tax Calculator</h1>

<h2> RESTful web service to calculate tax using Spring boot.</h2> 
<p>To get more detail about the sample payload of this project, please check <a href="https://app.swaggerhub.com/apis/luckyp/Bill/1.0.0#/developers/getBills">this</a></p>

<h2>Prerequisites</h2>
<p>1. Java 8</p>
<p>2. Spring Boot</p>
<p>3. Spring Data JPA</p>
<p>4. PostgreSQL</p>
<p>5. Docker</p>

<h2>Step to run the project</h2>
<p>Since the project used Spring Data JPA and we set to its config to auto generate ddl, so that we do not need define the table manually.</p>
<p>1. Replace the db credential with yours in application.properties and docker-compose.yml files.</p> 
<p>2. Cleaning, installing, and packaging the project by using maven command i.e. <strong> mvn clean install package.</strong><p>
<p>3. Create and run docker image of this project by using docker-compose command i.e. <strong>docker-compose up -d --build</strong></p>
<p>4. Test this project's web services by using any HTTP client tool or curl command.</p>
<p>5. Once you have done, you could simply run <strong>docker-compose down</strong> command to stop all containers which are running inside your docker.</p>
