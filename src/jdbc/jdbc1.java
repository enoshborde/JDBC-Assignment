package jdbc;

import java.sql.*;

public class jdbc1 {

	public static void test() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("select * from employee where emp_id=1");

			if (result.next()) {

				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void test1() {

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("select count(*) as count from employee");

			if (result.next()) {
				int count = result.getInt(1);
				System.out.println(count);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void test2(int emp_id) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("select * from employee where emp_id=" + emp_id);

			if (result.next()) {

				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void test3(String emp_name) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("select * from employee where emp_name=" + "emp_name");

			if (result.next()) {

				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		test();
		test1();
		test2(2);
		test3("-Adam");

	}

}
