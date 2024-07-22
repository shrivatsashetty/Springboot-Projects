package lab6;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@SuppressWarnings("deprecation")
public class StudentService {
	// first we start off by creating a configuration object
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	
	SessionFactory sFactory = configuration.buildSessionFactory();
	
	Session session = sFactory.openSession();
	
	Transaction transaction = session.beginTransaction();
	
	// CREATE
	public void addStudent(int id, String name, int marks) {
		Student student =new Student(id,name,marks);
		session.save(student);
	}
	
	// READ
	public void getStudents(){
		Query query = session.createQuery("FROM students");
		List<Student> studentList = query.getResultList();
		for(Student student : studentList) {
			System.out.println(student);
		}
		
	}
	
	// DELETE 
	public void deleteStudentById(int id) {
		Query query = session.createQuery("DELETE FROM students WHERE id=:id");
		query.setParameter("id", id);
		int deteteStatus = query.executeUpdate();

	}
	
	// find by id
	public void findStudentById(int id) {
		Query query = session.createQuery("FROM students WHERE id=:id");
		query.setParameter("id", id);
		List<Student> student = query.getResultList();

	}
}
