package joins;

import java.sql.*;

public class OnetoOne {

	public static void main(String[] args) {
		empAdd();
		empAdd1();
	}

	public static void empAdd() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT emp_name,subject from employee inner join address on employee.emp_id = address.emp_id");

			while (result.next()) {

				// System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.print(result.getString("subject"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void empAdd1() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT emp_name,subject from employee right join address on employee.emp_id = address.emp_id");

			while (result.next()) {

				// System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.print(result.getString("subject"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
