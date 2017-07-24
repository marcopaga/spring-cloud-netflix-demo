package de.codecentric.cloud.frontend;

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

    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/")
    public String calculate(){
        final Random random = new Random();
        int first = random.nextInt();
        int second = random.nextInt();
        final ResponseEntity<Integer> result = restTemplate.getForEntity("http://backend/add/{first}/{second}/", Integer.class, first, second);
        return format("%d + %d = %d", first, second, result.getBody());
    }

    @GetMapping("/calculate/{first}/{second}")
    public String calculate(@PathVariable("first") int first, @PathVariable("second") int second){
        final ResponseEntity<Integer> result = restTemplate.getForEntity("http://backend/add/{first}/{second}/", Integer.class, first, second);
        return format("%d + %d = %d", first, second, result.getBody());
    }
}
