package com.practice.restpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/hello")
    public String getDefault(){
        return "Hello World" ;
    }
    
    // GET method to return an object
    @GetMapping("/getperson")
    @ResponseBody
    public Person getPerson() {
    	return new Person("Shankar", 123);
    }
    
    // http://localhost:8080/person/hellobyid?ssid=2
    @GetMapping("/hellobyid")
    @ResponseBody
    public String getHello(@RequestParam(value="ssid") int ssn){ // here we are providing an annotation for the method argument
        return "Hello from person with SSN:" + ssn;
    }
    
    /* GET method to fetch the object notation form of a Person object */
    @GetMapping("/getpersonobj")
    @ResponseBody
    public Person getPersonObj( 
    		@RequestParam(value="name") String name, @RequestParam(value="ssn") int ssn) {	
    	return new Person(name, ssn);
    } // http://localhost:8080/person/getpersonobj?name=shri&ssn=2
    
    @PostMapping("/postperson")
    public String postPerson(@RequestBody Person person) {
    	return "Person with SSN " + person.getSsn() + " was posted" ;
    } // http://localhost:8080/person/postperson    
    
}
