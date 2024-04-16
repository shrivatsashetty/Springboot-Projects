package com.practice.restpractice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.ArrayIterator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

	/* lets create an array list to store people */
	List<Person> peopleList = new ArrayList<>();

	@GetMapping("/hello")
	public String getDefault() {
		return "Hello World";
	}

	// GET method to return an object
	@GetMapping("/getperson")
	@ResponseBody
	public Person getPerson() {
		return new Person("Shankar", 123);
	}// http://localhost:8080/person/getperson

	@GetMapping("/hellobyid")
	@ResponseBody
	public String getHello(@RequestParam(value = "ssid") int ssn) { // here we are providing an annotation for the
																	// method argument
		return "Hello from person with SSN:" + ssn;
	} // http://localhost:8080/person/hellobyid?ssid=2

	/* GET method to fetch the object notation form of a Person object */
	@GetMapping("/getpersonobj")
	@ResponseBody
	public Person getPersonObj(@RequestParam(value = "name") String name, @RequestParam(value = "ssn") int ssn) {
		return new Person(name, ssn);
	} // http://localhost:8080/person/getpersonobj?name=shri&ssn=2

	/* a method to return all the people in the list */
	@GetMapping("/getpeople")
	@ResponseBody
	public List<Person> getPeople() {
		return peopleList;
	} // http://localhost:8080/person/getpeople

	/* retrieve a person object by name */
	@GetMapping("/getpersonbyname")
	@ResponseBody
	public Person getPersonByName(@RequestParam(value = "name") String name) {
		for (Person person : peopleList) {
			// now perform a case insensitive search for name
			if (person.getName().equalsIgnoreCase(name)) {
				return person;
			}
		}
		return null;
	}
	// http://localhost:8080/person/getpersonbyname?name=Naveen
	// http://localhost:8080/person/getpersonbyname?name=naveen
	
	/* search by ssn */
	@GetMapping("/searchperson/{ssn}")
	@ResponseBody
	public Person getPersonByID(@PathVariable int ssn) {
		for(Person person : peopleList) {
			if(person.getSsn() == ssn) {
				return person;
			}
		}
		return null;
	}// http://localhost:8080/searchperson/search/7

	
	/* adding a new person to the list of people */
	@PostMapping("/postperson")
	public List addPerson(@Valid @RequestBody Person person, BindingResult bindingResults) {
		/*an ArrayList to store the description of the errors in String format */
		List<String> errorDescList = new ArrayList<>();
		
		if(bindingResults.hasErrors()) {
			/* an ArrayList to store the actual FieldError objects */
			List<FieldError> fieldErrorList = bindingResults.getFieldErrors();
			
			for(FieldError fieldError : fieldErrorList) {
				errorDescList.add(fieldError.getField() + " " + fieldError.getDefaultMessage());
			}
			return fieldErrorList;
		}
		peopleList.add(person);
		return peopleList;
	} // http://localhost:8080/person/postperson

	/* a handler method for DELETE request */
	@DeleteMapping("/deleteperson")
	public String deletePersonByID(@RequestParam(name = "name") String name) {
		for (Person person : peopleList) {
			if (person.getName().equalsIgnoreCase(name)) {
				peopleList.remove(person);
				return "Following person: " + person + " has been deleted from list\n" + "Current items in list:\n"
						+ peopleList;
			}
		}
		return "Person not found in List for deletion";
	} // http://localhost:8080/person/deleteperson?name=manu
	
	/* handler for PATCH i.e. Update */
	@PatchMapping("/editperson")
	public Person editPersonDetails( @RequestParam(value = "ssn") int ssn, @RequestBody Person modifiedPerson ) {
		for(Person person : peopleList) {
			if (ssn == modifiedPerson.getSsn()){
				person.setName(modifiedPerson.getName());
				return person;
			}
		}
		return null;
	}
	

}
