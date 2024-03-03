package com.example.studentapp;

import java.util.Date;

public class Student {
	
	/* attributes */
	private int stdId;
	private int grade;
	private Date dob;
	
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
	
}
