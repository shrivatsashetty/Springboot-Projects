package in.example.firstjpa;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication
public class FirstjpaApplication {

	public static void main(String[] args) {
		
		// creating an application context object
		ApplicationContext applicationContext = SpringApplication.run(FirstjpaApplication.class, args);
		
		// fetching the required bean using application context
		CustomerService customerService = applicationContext.getBean(CustomerService.class);
		
		// inserting a new record
		customerService.insertCustomer(2, "Anil", 576200, LocalDate.of(1990, Month.SEPTEMBER, 30) );
		
		// retrieve all records
		List<Customer> customerList = customerService.fetchAllCustomers();
		
		// display all customers one by one
		for(Customer customer : customerList) {
			System.out.println(customer);
		}
		
	}

}
