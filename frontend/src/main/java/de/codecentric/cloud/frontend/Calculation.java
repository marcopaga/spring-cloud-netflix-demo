package de.codecentric.cloud.frontend;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static java.lang.String.format;

@Component
public class Calculation {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculation.class);

    @Resource
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "performAdditionFallback")
    String performAddition(int first, int second) {
        LOGGER.info("Calculation of {} + {} requested.", first, second);
        final ResponseEntity<Integer> result = restTemplate.getForEntity("http://backend/add/{first}/{second}/", Integer.class, first, second);
        LOGGER.info("Result is: {}", result.getBody());
        return format("%d + %d = %d", first, second, result.getBody());
    }

    private String performAdditionFallback(int first, int second){
        if(first > 0 && second > 0){
            return "The result will be positive.";
        } else {
            return "The result will be a number.";
        }
    }
}
