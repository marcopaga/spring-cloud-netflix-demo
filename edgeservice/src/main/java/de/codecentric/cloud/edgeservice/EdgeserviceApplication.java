package de.codecentric.cloud.edgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulServer
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
public class EdgeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeserviceApplication.class, args);
	}
}
