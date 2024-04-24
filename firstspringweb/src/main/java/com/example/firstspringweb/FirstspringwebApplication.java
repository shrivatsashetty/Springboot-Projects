package com.example.firstspringweb;

/* imports */
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FirstspringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringwebApplication.class, args);
		
		// we create an object of application context which has all info of the application stored in it
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("firstspringweb.xml"); // takes path to the XML file as input
		
		Book comicBook = appContext.getBean("_book", Book.class); // takes id and an instance of Book class
		System.out.println(comicBook + " " + comicBook.getBookTitle() + " " + "published by: " +
				comicBook.getPublisher().getPublisherName()); 
		
		/* by default spring creates Singleton objects */
		/* to demo this let's create on more object of Book class */
		Book storyBook = appContext.getBean("_book", Book.class);
		System.out.println(storyBook + " " + storyBook.bookTitle + " " + "published by: " +
				storyBook.getPublisher().getPublisherName()); 	
		
		/* if we crate another application context that will return us a different object of Book class */
		/* that's because it will have it's own set of singleton beans */
		ClassPathXmlApplicationContext secondAppContext = new ClassPathXmlApplicationContext ("firstspringweb.xml");
		Book textBook = secondAppContext.getBean("_book", Book.class);
		System.out.println(textBook + " " + textBook.getBookTitle() + " " + "published by: " +
				textBook.getPublisher().getPublisherName()); 
//		System.out.println(textBook.toString());
		
		// close the objects of ApplicationContext to avoid memory leaks
		appContext.close(); 
		secondAppContext.close();
	}

}
