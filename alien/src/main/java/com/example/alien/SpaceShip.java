package com.example.alien;

import org.springframework.stereotype.Component;

// declare SpaceShip as Component to make it a Bean

@Component
public class SpaceShip {
	int spaceShipId;
	final double MAX_SPEED = 3.18;
	
	
	// constructor
	public SpaceShip() {
		super();
		System.out.println("Flying spaceship...");
	}

	public int getSpaceShipId() {
		return spaceShipId;
	}
	
	public void setSpaceShipId(int spaceShipId) {
		this.spaceShipId = spaceShipId;
	}
	
	// only getter method for final field
	public double getMAX_SPEED() {
		return MAX_SPEED;
	}
	
	// toString() method to print the description of the object
 	@Override
	public String toString() {
		return "SpaceShip [spaceShipId=" + spaceShipId + ", MAX_SPEED=" + MAX_SPEED + "]";
	}
 	
 	// this class has it's own method
 	public void flyAtMaxSpeed() {
 		System.out.println("Flying at speed : " + this.MAX_SPEED + "x10^8 m/s");
 	}
 	
		
}







