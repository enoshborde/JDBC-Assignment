package crud;

import java.sql.*;

public class OneToOne {

	public static void main(String[] args) {
		// createEmployee(7, "-Sam", "Oracle");
		// readEmployees();
		// updateEmployee();
		// deleteEmployee(7);

	}

	public static void createEmployee(int emp_id, String emp_name, String subject) {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			p1 = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
			p2 = connection.prepareStatement("INSERT INTO address VALUES(?,?)");
			p1.setInt(1, emp_id);
			p1.setString(2, emp_name);
			p1.setString(3, subject);
			p2.setInt(1, emp_id);
			p2.setString(2, "100 India");
			p1.execute();
			p2.execute();
			System.out.println("1 record inserted...");
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.exit(1);
		} finally {
			try {
				p1.close();
				p2.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}
	}

	public static void readEmployees() {
		Connection connection = null;
		Statement statement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from employee");

			while (result.next()) {

				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.print(result.getString("subject"));
				System.out.println();
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.exit(1);
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}
	}

	public static void updateEmployee() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			preparedStatement = connection.prepareStatement("UPDATE employee SET emp_name='Mahi' WHERE emp_id=7");
			// preparedStatement.setInt(1, emp_id);
			// preparedStatement.setString(2, emp_name);
			preparedStatement.execute();
			System.out.println("One record Updated");

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.exit(1);
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}
	}

	public static void deleteEmployee(int emp_id) {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("delete from employee where emp_id=?");
			p3 = connection.prepareStatement("delete from address where emp_id=?");
			p4 = connection.prepareStatement("SET foreign_key_checks = 1");
			p2.setInt(1, 7);
			p3.setInt(1, 7);
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			System.out.println("1 record deleted...");
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.exit(1);
		} finally {
			try {
				p1.close();
				p2.close();
				p3.close();
				p4.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}
	}
}
