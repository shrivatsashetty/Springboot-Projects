package in.example.firstjpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* this class is a service for the repository */
@Service
public class CustomerService {
	
	/* the service class has an instance of repository class as one of it's attribute 
	 * and the required instance of class is auto injected at runtime by @Autowired annotation */
	@Autowired
	public CustomerRepository customerRepository;
	
	/* a method to insert a customer object as a record */
	public void insertCustomer(Integer customerId, String firstName, int pincode, LocalDate dateOfBirth) {
		
		Customer customer = new Customer();
		
		customer.setCustomerId(customerId);
		customer.setFirstName(firstName);
		customer.setPinCode(pincode);
		customer.setDateOfBirth(dateOfBirth);
		
		customerRepository.save(customer);
	}
	
	/* a method to return all customer record in table as List */
	public List<Customer> fetchAllCustomers(){
		return customerRepository.findAll();
	}
		
}
