/* the class containing the main method will be present by default */

package com.example.alien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AlienApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(AlienApplication.class, args);
		
		// create an instance of the Alien class
		Alien alien = appContext.getBean(Alien.class);
		
		alien.speakName();
		
		// creating one more object of Alien,
		// but constructor will not be called since an instance already exists if Scope is singleton 
//		Alien jadooAlien = appContext.getBean(Alien.class);
//		jadooAlien.speakName();
		
	}

} 
