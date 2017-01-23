package joins1;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		empAdd();

	}
	public static void empAdd() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT employee.emp_id,emp_name,subject,address from employee inner join address on employee.emp_id = address.emp_id");
			while(result.next()) {
			Employee emp = new Employee(result.getInt("emp_id"), result.getString("emp_name"),
					result.getString("subject"));
			Address add1=new Address(result.getInt("emp_id"), result.getString("address"));
			System.out.println(emp.getEmp_name()+ emp.getSubject()+add1.getAddress());
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
