package testhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.hibernate.Transaction;

/* this is the configuration class and and also has the main() method */
public class EmployeeConfig {
	
	// create a new configuration object
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	
	/* get the whole configuration loaded into an object, 
	 * this object will give us access to all configurations 
	 * since the configuration file contains a tag called session factory */
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	/* a method to set object state and insert it to database as a record */
	@SuppressWarnings("deprecation")
	public void insertRecord(int empId, String empName, int empAge, int empSalary ) {
		Employee employee = new Employee(); // creating a new object of Employee class
		
		// get a session object from the sessionFactory
		Session session = sessionFactory.openSession(); // opens a new session
		// a single Session can span multiple transaction
		Transaction transaction = session.beginTransaction();
		
		// calling the setter methods to set the values or state of the object
		employee.setempId(empId);
		employee.setEmpAge(empAge);
		employee.setEmpName(empName);
		employee.setEmpSalary(empSalary);
		
		// save the changes and commit
		session.save(employee); // session.save() is deprecated since Hibernate 6.0
 		transaction.commit();
		
	}
	

	
	
}






