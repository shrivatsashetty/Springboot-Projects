package com.practice.restpractice;

public class Person {
	
	private String name;
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

	
	 
}
