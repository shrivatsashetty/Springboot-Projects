package in.example.firstjpa;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* this class is  our bean and represents an entity in a relational database or */ 

@Entity
@Table(name = "customers") // mapping the class to the respective table
public class Customer {
	
	/* attributes or fields */
	
	/* the @Id annotation specifies that the field is the PRIMARY KEY 
	 * the @GeneratedValue annotation says that the id is generated automatically */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	private String firstName;
	private int pinCode;
	private LocalDate dateOfBirth;
	
	/* getter and setter */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstNameString) {
		this.firstName = firstNameString;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/* toString() method to print description of the object */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId +
				", firstName=" + firstName + 
				", pinCode=" + pinCode +
				", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
