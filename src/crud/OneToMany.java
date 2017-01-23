package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OneToMany {

	public static void main(String[] args) {
		// createCustomer(6, "Abhi");
		// readCustOrd();
		// updateCustOrd();
		// deleteCustOrd();

	}

	public static void createCustomer(int customer_id, String customer_name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?)");
			preparedStatement.setInt(1, customer_id);
			preparedStatement.setString(2, customer_name);
			preparedStatement.execute();
			System.out.println("1 customer inserted...");
			createOrder(555, customer_id, 500);
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

	public static void createOrder(int order_id, int customer_id, int amount) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			preparedStatement = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?)");
			preparedStatement.setInt(1, order_id);
			preparedStatement.setInt(2, customer_id);
			preparedStatement.setInt(3, amount);
			preparedStatement.execute();
			System.out.println("1 record inserted...");
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

	public static void readCustOrd() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			PreparedStatement state = connection.prepareStatement("select * from customer where customer_name=? ");
			state.setString(1, "Abhi");
			ResultSet result = state.executeQuery();

			if (result.next()) {

				System.out.print(result.getInt("customer_id"));
				System.out.print(result.getString("customer_name"));
				System.out.println();
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateCustOrd() {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("UPDATE customer SET customer_id=?, customer_name=? WHERE customer_id=6");
			p3 = connection.prepareStatement("update orders set customer_id = ? where customer_id=6");
			p4 = connection.prepareStatement("SET foreign_key_checks = 1");
			p2.setInt(1, 7);
			p2.setString(2, "Amar");
			p3.setInt(1, 7);
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			System.out.println("1 customer updated...");

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

	public static void deleteCustOrd() {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("delete from customer where customer_id=?");
			p3 = connection.prepareStatement("delete from orders where customer_id=?");
			p4 = connection.prepareStatement("SET foreign_key_checks = 1");
			p2.setInt(1, 7);
			p3.setInt(1, 7);
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			System.out.println("1 customer deleted...");

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
