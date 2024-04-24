package com.exam.lab07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	// CREATE
	public void addCustomer(String name, String address) {
		customerRepo.save(new Customer(name, address));
	}

	// READ
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		return customerList;
	}

	// UPDATE
	public void updateCustomers(Long id, String newName, String newAddress) {
		Customer existingCustomer = customerRepo.findById(id).orElse(null);
		if (!existingCustomer.equals(null)) {
			existingCustomer.setAddress(newAddress);
			existingCustomer.setName(newName);
			customerRepo.save(existingCustomer);
		}
	}

	// DELETE
	public void deleteCustomerById(Long id){
		customerRepo.deleteById(id);
	}
	
}
