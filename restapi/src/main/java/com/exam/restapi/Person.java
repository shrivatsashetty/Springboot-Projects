package com.exam.restapi;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Person {

    // preset to 1 in Long format
    // private static Long nextPersonId =1l;
    
    @NotNull(message = "Id cannot be null")
    @Min(1)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(1)
    @Max(100)
    private int age;

    @Email(message = "This is not in email format")
    private String email;

    // // constructor
    // public Person() {
    //     // to auto set the person id
    //     this.id = nextPersonId++;
    // }

    // // getter-setter
    // public static Long getNextPersonId() {
    //     return nextPersonId;
    // }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    

}
