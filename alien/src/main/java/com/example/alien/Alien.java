/* This is our simple POJO file */

package com.example.alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Alien {
	
	private int alienId;
	private int homePlanet;
	private String scientificName;
	@Autowired // connects the class with it's dependency
	private SpaceShip spaceShip; // an object of other class is a dependency or a bean

	/* constructor */
	public Alien() {
		super();
		System.out.println("Alien Constructor called...");
	}
	
	/* getter-setter */
	
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public void setSpaceShip(SpaceShip spaceShip) {
		this.spaceShip = spaceShip;
	}
	
	public int getAlienId() {
		return alienId;
	}
	
	public void setAlienId(int alienId) {
		this.alienId = alienId;
	}
	
	public int getHomePlanet() {
		return homePlanet;
	}
	
	public void setHomePlanet(int homePlanet) {
		this.homePlanet = homePlanet;
	}
	
	public String getScientificName() {
		return scientificName;
	}
	
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	
	// user defined method
	public void speakName() {
		System.out.println("Alien Name : " + this.scientificName);
		spaceShip.flyAtMaxSpeed(); // we are calling a method of bean class
	}
	
}









