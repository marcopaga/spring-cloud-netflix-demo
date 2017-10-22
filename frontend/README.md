# Frontend REST Service

# API

The following addresses are available:
- http://localhost:8091/calculate/{first}/{second}/
- http://localhost:8091/

Both will return ta string containing both numbers and the sum.With the first path you can explicitly define the numbers.
The root URL will create two random numbers and sum these up using the backend service.

# Ribbon

The frontend uses [Ribbon](http://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/1.3.5.RELEASE/multi/multi_spring-cloud-ribbon.html) as a client side load balancer. The clients are retrieved from the eureka server.
We can use the service name as the host in the URL.

# Hystrix

Additionally the method Calculation#performAddition is annotated with `@HystrixCommand`. If an exception occurs within this method the fallback method is used to create a response that doesn't rely on the remote system. In this example the method will gracefully degrade by returning an estimation if the resulting number is positive. In a real project you might try to call an external system to lookup an address and fallback to a local cache that only contains some major districts. 