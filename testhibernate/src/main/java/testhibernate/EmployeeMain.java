
package testhibernate;

/* this is our main class */
public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeConfig employeeConfig = new EmployeeConfig();

		// inserting a record
		// employeeConfig.insertRecord(3, "Komal", 37, 50000);

		// read all records
		employeeConfig.readAllRecords();

		// search record with empID
		employeeConfig.searchRecordById(1);

	}

}
