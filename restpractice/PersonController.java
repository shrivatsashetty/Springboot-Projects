package com.practice.restpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/hii")
public class PersonController {

    @GetMapping("/hello")
    public String getDefault(){
        return "Hello World" ;
    }
    
    @GetMapping("/helloid")
    public String getHello(@RequestParam(value="ssn") int ssn){ // here we are providing an annotation for the method argument
        return "SSN passed:" + ssn;
    }
    
}
