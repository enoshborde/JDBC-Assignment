package joins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManyToMany {

	public static void main(String[] args) {
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

}
