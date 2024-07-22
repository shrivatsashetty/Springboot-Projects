package com.example.studentapp;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* a dependency for the Student class */
@Component
@Scope("singleton") // defining the scope of the bean
public class School {

	/* @Value annotation sets the default values of the attributes
	 * the equivalent XML configuration is as given below
	 * <property name="schoolName" value="Cambridge Intl School" /> */
	@Value("Cambridge International School")
	private String schoolName;
	@Value("1912") // String argument will be auto type-casted to int while setting the default value
	private int estdYear;
	@Value("London")
	private String address;
	
	/* getter and setters */
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public int getEstdYear() {
		return estdYear;
	}
	
	public void setEstdYear(int estdYear) {
		this.estdYear = estdYear;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	// to string method
	@Override
	public String toString() {
		return "School Name:" + this.schoolName + "Established Year:" + this.estdYear; 
	}
		
}
