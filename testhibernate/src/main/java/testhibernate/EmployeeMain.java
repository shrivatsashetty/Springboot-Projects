
package testhibernate;

/* this is our main class */
public class EmployeeMain {


	public static void main(String[] args) {
		EmployeeConfig employeeConfig = new EmployeeConfig();
		
		employeeConfig.insertRecord(2, "Sharath", 40, 90000);
		
	}

}
