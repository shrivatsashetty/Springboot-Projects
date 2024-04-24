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

	/*
	 * get the whole configuration loaded into an object,
	 * this object will give us access to all configurations
	 * since the configuration file contains a tag called session factory
	 */
	SessionFactory sessionFactory = configuration.buildSessionFactory();

	/* a method to set object's state and insert it to database as a record */
	@SuppressWarnings("deprecation")
	public void insertRecord(int empId, String empName, int empAge, int empSalary) {
		Employee employee = new Employee(); // creating a new object of Employee class

		// get a session object from the sessionFactory
		Session session = sessionFactory.openSession(); // opens a new session
		// a single Session can span multiple transaction
		Transaction transaction = session.beginTransaction();

		// calling the setter methods to set the values or state of the object
		employee.setEmpId(empId);
		employee.setEmpAge(empAge);
		employee.setEmpName(empName);
		employee.setEmpSalary(empSalary);

		// save the changes and commit
		session.save(employee);
		transaction.commit();

	}

	/* a method to read and fetch all the records */
	public List<Employee> readAllRecords() {

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// the query string must contain name as packagename.classname not the SQL table
		String queryString = "FROM testhibernate.Employee";

		Query<Employee> query = session.createQuery(queryString, Employee.class);

		// this method will return multiple objects in List
		List<Employee> empList = query.getResultList(); // query.getList() also works

		transaction.commit();
		session.close();

		System.out.println(empList);

		return empList;

	}

	/* search a particular record by employee Id */
	public Employee searchRecordById(int empId) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// String after the colon symbol represents a parameter
		String queryString = "FROM Employee WHERE empId=:empId";

		Query<Employee> query = session.createQuery(queryString, Employee.class);

		// substituting the empId passed as argument into the Query
		query.setParameter("empId", empId);

		// this method will return a single object of type EMployee
		Employee empRecord = query.getSingleResult();

		transaction.commit();
		session.close();

		// once print the returned record to standard output before returning
		System.out.println(empRecord);

		return empRecord;
	}

}
