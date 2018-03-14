# Backend REST Service

# API

The following addresses are available:
- http://localhost:8090/add/{first}/{second}/

It will return the sum of two numbers. You can explicitly define the numbers.

# Health Checks

The backend has this property set:

    eureka:
      client:
        healthcheck:
          enabled: true

This will advise eureka to check the `/health` Spring Boot Actuator endpoint for the service. As a consequence this instance will only be announced to other clients if the health Status is `UP`.