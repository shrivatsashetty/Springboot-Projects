package com.practice.restpractice;

import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Person {
	/* adding validations for fields */
	
	@NotEmpty(message = "Name Cannot be empty")
	@Size(min = 3, max = 100)
	private String name;
	
	@NotNull(message = "ssn cannot be null!!")
	@Min(value = 1, message = "1 is the minimum value for ssn")
	@Max(value = 100, message = "100 is the max value for ssn")	
	private int ssn;
	
	Person(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	/* toString method to print custom description of the object*/
	@Override
	public String toString() {
		return "Person [name=" + name + ", ssn=" + ssn + "]";
	}

	
	 
}
