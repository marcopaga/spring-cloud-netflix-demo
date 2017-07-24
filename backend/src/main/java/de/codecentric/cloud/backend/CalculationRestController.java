package de.codecentric.cloud.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CalculationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationRestController.class);

    @GetMapping("/")
    public String index(){
        return "Backend Application";
    }

    @GetMapping("/add/{first}/{second}/")
    public int add(@PathVariable("first") int first, @PathVariable("second") int second){
        injectFailure();
        simulateLongProcessing();
        final int result = first + second;
        LOGGER.info("Calculation of {} + {} = {}.", first, second, result);
        return result;
    }

    private void simulateLongProcessing() {
        final int processingTime = new Random().nextInt(1100);
        LOGGER.info("Processing will be delayed by {} ms.", processingTime);
        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException ignored) {
        }
    }

    private void injectFailure() {
        if(new Random().nextInt(100) > 95){
            throw new IllegalStateException("This error was automatically created for you to test this stack.");
        }
    }
}
