# Backend REST Service

# API

The following addresses are available:
- http://localhost:8090/add/{first}/{second}/
- http://localhost:8090/

Both will return the sum of two numbers. With the first path you can explicitly define the numbers.
The root URL will create two random numbers and sum these up.

# Health Checks

The backend has this property set:

    eureka:
      client:
        healthcheck:
          enabled: true

This will advise eureka to check the `/health` Spring Boot Actuator endpoint for the service. As a consequence this instance will only be announced to other clients if the health Status is `UP`.

# Processing

The process simulates a processing time. The maximum number of millis can be configured with the spring property `backend.processing.time.max`. This property is currently propagated by the Spring cloud config server. 

# Failures

The service will return an exception randomly from time to time. You will find a `IllegalStateException` in the logs that clearly states it's purpose in the logs. These exceptions are needed to test the resiliency features.