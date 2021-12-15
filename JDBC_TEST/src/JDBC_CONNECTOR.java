import java.sql.*;
import java.util.Scanner;


public class JDBC_CONNECTOR {
	
	Scanner scanner = new Scanner(System.in);
	
	//adding employee
	private String empLastName;
	private String empFirstName;
	private String empEmail;
	private String empDepartment;
	private String empSalary;
	private int empId;
	private String yesOrNo;
	
	//Getters.
	public String getEmpLastName() {return empLastName;}
	public String getEmpFirstName() {return empFirstName;}
	public String getEmpEmail() { return empEmail;}
	public String getEmpDepartment() {return empDepartment;}
	public String getEmpSalary() {return empSalary;}
	public int getEmpId() {return empId;}
	public String getYesorNo() {return yesOrNo;}
	
	//Setters.
	public void setEmpLastName(String empLastName) {this.empLastName = empLastName;}
	public void setEmpFirstName(String empFirstName) {this.empFirstName = empFirstName;}
	public void setEmpEmail(String empEmail) {this.empEmail = empEmail;}
	public void setEmpDepartment(String empDepartment) {this.empDepartment = empDepartment;}
	public void setEmpSalary(String empSalary) {this.empSalary = empSalary;}
	public void setEmpId(int empId) {this.empId = empId;}
	public void setYesOrNo(String yesOrNo) {this.yesOrNo = yesOrNo;}
		
	Connection myConnection = null;
	PreparedStatement myStatement = null;
	ResultSet myResultSet = null;
		
	public JDBC_CONNECTOR() {
		

		String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user = "students";
		String password = "Johndavid015";

		try {
			myConnection = DriverManager.getConnection(url, user, password);

			System.out.println("Connected to the database Employees...");

			//myStatement = myConnection.createStatement();
			
//	myResultSet = myStatement.executeQuery("SELECT * FROM employees");
//	
//	while (myResultSet.next()) {
//		System.out.println(myResultSet.getString("last_name") + ", " + myResultSet.getString("first_name") + ": " + myResultSet.getString("department") + "\n");  
//	}

		} catch (SQLException e) {
			System.out.println("Something went wrong!");
			System.out.println(e.getMessage());
		}
	}
	
	public void addEmployee(int empId, String empLastName, String empFirstName, String empEmail, String empDepartment, String empSalary) {
		setEmpLastName(empLastName);
		setEmpFirstName(empFirstName);
		setEmpEmail(empEmail);
		setEmpDepartment(empDepartment);
		setEmpSalary(empSalary);
		setEmpId(empId);
		
		try {
		
		myStatement = myConnection.prepareStatement("insert into employees " + "(id, last_name, first_name, email, department, salary)" + "values" + "(? , ?, ?, ?, ?, ?)");
		
		myStatement.setInt(1, getEmpId());
		myStatement.setString(2, getEmpLastName());
		myStatement.setString(3, getEmpFirstName());
		myStatement.setString(4, getEmpEmail());
		myStatement.setString(5, getEmpDepartment());
		myStatement.setString(6, getEmpSalary());
		
		int row = myStatement.executeUpdate();
		
		System.out.println("Employee " + getEmpLastName() + "is added to the database");
		
		}catch(SQLException e) {
			System.out.println("Something went wrong");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
	}
	
	public void searchForDepartment(String empDepartment) {
		setEmpDepartment(empDepartment);

		try {
		
		myStatement = myConnection.prepareStatement("select * from employees where department = ?" );
		
		myStatement.setString(1, getEmpDepartment());
		
		myResultSet = myStatement.executeQuery();
		
		
		System.out.println("\nData Searched in the Database...\n");
		if(myResultSet.next()) {
		while(myResultSet.next()) {
			final String empid = myResultSet.getString(1);
			final String emplastname = myResultSet.getString(2);
			final String empdep = myResultSet.getString(5);
			System.out.println("ID NUMBER: " + empid + " lastname: " + emplastname + " department: " + empdep);
			}
		}else {
			System.out.println("There is no " + getEmpDepartment() + " in the Database Employee");
		}
		
		}catch(SQLException e) {
			System.out.println("Something went wrong");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
	}
	
	public void deleteEmployee(int empId, String empLastName) {
		setEmpId(empId);
		setEmpLastName(empLastName);
		
		try {
			
		myStatement = myConnection.prepareStatement("select * from employees where id = ? and last_name = ?");
		
		myStatement.setInt(1, getEmpId());
		myStatement.setString(2, getEmpLastName());
		
		myResultSet = myStatement.executeQuery();
		
		System.out.println("Do you want to Delete This Employee? [Y or N]");
		while(myResultSet.next()) {
			 String empid = myResultSet.getString(1);
			 String empfirstname = myResultSet.getString(3);
			 String emplastname = myResultSet.getString(2);
			 String empdep = myResultSet.getString(5);
			 
			System.out.println("ID NUMBER: " + empid + " LASTNAME: " + emplastname + " FIRSTNAME: " + empfirstname);
		}
		
		setYesOrNo(scanner.nextLine());
		
		while(true) {
			
			if(getYesorNo().toUpperCase().trim().equals("Y")) {
				myStatement = myConnection.prepareStatement("delete from employees where id = ? and last_name = ?");
				
				myStatement.setInt(1, getEmpId());
				myStatement.setString(2, getEmpLastName());
				
				int rowsAffected = myStatement.executeUpdate();
				
				System.out.println("Data is Deleted...");
				
				break;
				
			}else {
				
				System.out.println("Data is not Deleted...");
				break;
			}
		}
		
		}catch(SQLException e) {
			System.out.println("Something went wrong...");
			System.out.println(e.getMessage());
		}
	}
	
	public void UpdateEmployeeResume() {
		
	}
}
