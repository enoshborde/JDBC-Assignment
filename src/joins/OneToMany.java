package joins;

import java.sql.*;

public class OneToMany {

	public static void main(String[] args) {
		// empAdd1();
		empAdd();

	}

	public static void empAdd() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT customer_name from customer inner join orders on customer.customer_id = orders.customer_id");

			while (result.next()) {

				// System.out.print(result.getInt(customer_id));
				System.out.print(result.getString("customer_name"));
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
					"SELECT customer_name from customer right join orders on customer.customer_id = orders.customer_id");

			while (result.next()) {

				// System.out.print(result.getInt(customer_id));
				System.out.print(result.getString("customer_name"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
