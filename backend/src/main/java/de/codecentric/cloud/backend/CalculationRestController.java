package de.codecentric.cloud.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationRestController {

    @GetMapping("/")
    public String index(){
        return "Backend Application";
    }

    @GetMapping("/add/{first}/{second}/")
    public int add(@PathVariable("first") int first, @PathVariable("second") int second){
        return first + second;
    }
}
