package com.example.studentapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/* the dependent class */
public class Student {
	
	/* attributes */
	@Value("Shrivatsa Shetty")
	private String studentName;
	@Value("1")
	private int stdId;
	@Value("10")
	private int grade;
	
	// Can't set default value to dob of type Date and school of type School since both are objects 
	private Date dob;
	
	//@Autowired // injects the dependency at the runtime but waste since I can't access the attribute outside the class since it's provate
	private School school;
	
	/* getter and setters */
	public int getStdId() {
		return stdId;
	}
	
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public School getSchool() {
		return school;
	}
	
	@Autowired // auto injects the required School dependency
	public void setSchool(School school) {
		this.school = school;
	}
	/*getter to get school object*/
	public School getSchool(School school) {
		return new School();
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void initStudent() {
		System.out.println("Init method called...\nInitialized a new object of class Student");
		this.dob = new Date();
		System.out.println("Date of object creation: " + this.dob);
	}
	
}
