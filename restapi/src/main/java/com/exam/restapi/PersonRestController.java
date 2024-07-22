package com.exam.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/personapi")
public class PersonRestController {

    private List<Person> people = new ArrayList<>();

    // GET
    @GetMapping("/getall")
    public List<Person> getAllPeople(){
        return people;
    }

    
    // GET by Id
    @GetMapping("/getperson/{id}")
    public Person getPersonById(@PathVariable Long id){
        return people.stream().filter( p -> p.getId().equals(id) ).findFirst().orElse(null);
    }

    // POST
    @PostMapping("/postperson")
    public ResponseEntity<?> postPerson(@Valid @RequestBody Person newPerson, BindingResult bindingResult){
        List<String> erroList = new ArrayList<>();
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(error -> erroList.add(error.getField() + " " + error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(erroList);
        }
        else{
            people.add(newPerson);
            return ResponseEntity.status(HttpStatus.CREATED).body(people);
        }

    }

    // PUT
    @PutMapping("/putperson/{id}")
    public ResponseEntity<?> putPerson(@PathVariable Long id, @Valid @RequestBody Person updatedPerson, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<String> errorList = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(error -> errorList.add(error.getField() + " " + error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errorList);
        }
        else{
            Person existingPerson = getPersonById(id);
            if(existingPerson != null){
                existingPerson.setAge(updatedPerson.getAge());
                existingPerson.setName(updatedPerson.getName());
                return ResponseEntity.status(HttpStatus.CREATED).body(existingPerson);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }
         
    }

    // PATCH
    @PatchMapping("/updateperson/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson){

        Person existingPerson = getPersonById(id);

        if (!updatedPerson.getName().equals(null)){
            existingPerson.setName(updatedPerson.getName());
        }

        if ( updatedPerson.getAge() != 0){
            existingPerson.setAge(updatedPerson.getAge());
        }

        if (!updatedPerson.getEmail().equals(null)){
            existingPerson.setEmail(updatedPerson.getEmail());
        }

        return existingPerson;
    }

    // DELETE
    @DeleteMapping("/deleteperson/{id}")
    public String deletePersonById(@PathVariable Long id, @RequestBody Person person){
        Person targetPerson = getPersonById(id);
        if(targetPerson != null){
            people.remove(targetPerson);
            return "Person with Id " + targetPerson.getId() + " removed";
        }
        
        return "Person Not Found";
    }

}


