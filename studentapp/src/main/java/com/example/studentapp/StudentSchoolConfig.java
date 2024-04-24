package com.example.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

@Configuration // this class is equivalent to an XML configuration file
public class StudentSchoolConfig {
//	<bean id="_school" class="com.example.studentapp.Student" scope="prototype", init-method="initStudent" destroy-method="destroyStudent" >
//		<property name="stdId" value="1"> </property>
//		<property name="studentName" value="Shrivatsa Shetty" />
//		<property name="grade" value="10" />
//		<!-- reference to another bean -->
//		<property name="school" ref="_school" />
//	</bean>
	
	@Bean(name = "_student", initMethod = "initStudent", destroyMethod = "destroyStudent")
	@Description("The class student is a dependent bean on bean school")
	@Scope("prototype")
	public Student geStudent() {
		return new Student();
	}
		
	@Bean("_school") // the argument inside is the Id of the bean
	@Scope("singleton") // makes the scope of the Bean object prototype, each object given out must be stored in an ArrayList
	public School getSchool() {
		return new School();
	}
	
}
