package de.codecentric.cloud.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Random;

import static java.lang.String.format;

@RestController
public class FrontendRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontendRestController.class);

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/")
    public String calculate(){
        final Random random = new Random();
        int first = random.nextInt();
        int second = random.nextInt();

        return performAddition(first, second);
    }

    @GetMapping("/calculate/{first}/{second}")
    public String calculate(@PathVariable("first") int first, @PathVariable("second") int second){
        return performAddition(first, second);
    }

    private String performAddition(int first, int second) {
        LOGGER.info("Calculation of {} + {} requested.", first, second);
        final ResponseEntity<Integer> result = restTemplate.getForEntity("http://backend/add/{first}/{second}/", Integer.class, first, second);
        LOGGER.info("Result is: {}", result.getBody());
        return format("%d + %d = %d", first, second, result.getBody());
    }
}
