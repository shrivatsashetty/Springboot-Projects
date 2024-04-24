package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		

		ClassPathXmlApplicationContext cap = new ClassPathXmlApplicationContext("beans.xml");
	SampleSpring e = (SampleSpring)cap.getBean("hw");
		
		e.setS("hi shri");
		
		System.out.print(""+ e.getS());
		
		cap.close();
	}

}
