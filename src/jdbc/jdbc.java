package jdbc;

import java.sql.*;

public class jdbc {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery("select * from employee");
			// ResultSet result = state.executeQuery("select * from address");
			// ResultSet result = state.executeQuery("select * from customer");
			// ResultSet result = state.executeQuery("select * from orders");
			// ResultSet result = state.executeQuery("select * from doctor");
			// ResultSet result = state.executeQuery("select * from patient");
			// ResultSet result = state.executeQuery("select * from
			// doc_patient");
			while (result.next()) {
				// System.out.println(result.getInt(1));
				// System.out.println(result.getString(2));
				// System.out.println(result.getString(3));
				// System.out.println(result.getInt(2));
				// System.out.println(result.getDouble(3));
				System.out.print(result.getInt("emp_id"));
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
