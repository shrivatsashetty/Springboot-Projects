package com.example.studentapp;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StudentappApplication {

	public static void main(String[] args) {
		System.out.println(); // just printing a new line before the output
		/* the run() method takes an instance of application as argument and runs it */
		SpringApplication.run(StudentappApplication.class, args);
		
		/* create a new instance of an annotation-configuration based application context instead of an XML-configuration based application context
		 * the constructor takes the class instance as an argument unlike the name of XML file in XML application context constructor */
		AnnotationConfigApplicationContext annotAppCntxt = new AnnotationConfigApplicationContext(StudentSchoolConfig.class);
//		
		School cambridgeSchool = annotAppCntxt.getBean(School.class);
		System.out.println(cambridgeSchool);
		
		Student studentA = annotAppCntxt.getBean(Student.class);
		System.out.println(studentA.getStdId()); // 1
		System.out.println(studentA.getStudentName()+ " Studies in\n" + studentA.getSchool().getSchoolName());
		System.out.println("Student DOB: " + studentA.getDob());
	}

}
