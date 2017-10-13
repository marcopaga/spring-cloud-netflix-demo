# spring-cloud-netflix-demo
Spring cloud Demo Project with Zuul, Eureka, Ribbon, Sleuth &amp; Zipkin

This is a simple Demo Project of Spring Cloud. Currently mostly focusing to the netflix part to investigate the resiliency capabilities.

![System diagram][Spring_cloud.png]

# Running

Prepare the Spring Boot Apps with Maven.

> mvn clean install 

Start the applications with Docker Compose

> docker-compose up -d

# Using

You need to give the whole stack some time to find the available services in eureka.

## Sample call:

http://localhost:8080/api/

## Zipkin:

http://localhost:9411/

## Eureka:

http://localhost:8761/

## Config Server:

http://localhost:8888/
