# Zuul Edgeservice

# API

Frontend Service: [localhost:8080/api/](http://localhost:8080/api/)

[localhost:8080/routes](http://localhost:8080/routes)

[localhost:8080/health](http://localhost:8080/health)

# Services

The frontend service is the only available service. The configuration has `zuul.ignored-services: '*'` and an explicit mapping for the frontend service. If you omit this setting all eureka services are published by zuul. 
You can find the configuration here: [application.yml](src/main/resources/application.yml).

# Sleuth Tracing

The default Zuul implementation doesn't return the tracing information to a client. This might be a problem if you need to debug an issue reported by an external user or system.
I would favor the forwarding of the span-Id to aid debugging so you can see the id in the error reports. If you have these Ids you can simply find all related tracing information. 

The `SleuthResponseFilter` adds the `tmx-correlation-id` HTTP Header.

    ➜  cloud-demo git:(master) ✗ http http://localhost:8080/api/
    HTTP/1.1 200
    Content-Type: text/plain;charset=UTF-8
    Date: Thu, 19 Oct 2017 04:20:13 GMT
    Transfer-Encoding: chunked
    X-Application-Context: edgeservice:default:8080
    tmx-correlation-id: 3b2466c39096a21f
    
    The result will be a number.
