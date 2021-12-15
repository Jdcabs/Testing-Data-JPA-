
public class main {

	public static void main(String[] args) {
		
		JDBC_CONNECTOR newJDBC = new JDBC_CONNECTOR();
		
		//newJDBC.addEmployee(200,"cabal", "Johndavid", "asdasd@gmail.com", "IT", "40000");
		
		newJDBC.searchForDepartment("IT");
		
		//newJDBC.deleteEmployee(200, "cabal");
	}
}
