package com.example.STUDENT_MANAGEMENT;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
		 openBrowser("http://localhost:8080/");
	}
	 private static void openBrowser(String url) {
	        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
	            try {
	                Desktop.getDesktop().browse(new URI("http://localhost:8080/"));
	            } catch (IOException | URISyntaxException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}