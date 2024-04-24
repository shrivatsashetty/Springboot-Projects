package com.exam.lab07;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    // auto generated primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    // constructor 
    public Customer() {
        // empty default constructor
    }

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // getter-setter
    public Long getId() {
        return id;
    }

    /* no setter method for id field since it's auto generated */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
 

}
