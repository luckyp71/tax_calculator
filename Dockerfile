FROM java:8
MAINTAINER Lucky Pratama

COPY /target/tax_calculator-0.0.1-SNAPSHOT.jar tax_calculator-0.0.1-SNAPSHOT.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/tax_calculator-0.0.1-SNAPSHOT.jar"]
