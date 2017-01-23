package joins2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			boolean bool = state.execute(
					"select customer.customer_id,customer_name,order_id,amount from customer inner join orders on customer.customer_id=orders.customer_id order by customer_id");

			if (bool) {
				ResultSet result = state.getResultSet();
				List<Orders> list = new ArrayList<>();
				while (result.next()) {
					Customer customer = new Customer(result.getInt("customer_id"), result.getString("customer_name"));
					Orders order = new Orders(result.getInt("order_id"), result.getInt("customer_id"),
							result.getDouble("amount"));
					list.add(order);
					System.out.println(
							customer.getCustomer_id() + " " + customer.getCustomer_name() + " " + order.getAmount());
				}
			} else {
				int count = state.getUpdateCount();
				System.out.println(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
		public static void updateCustOrd() {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
				Statement state = connection.createStatement();
				boolean bool = state.execute(
						"set foreign_key_checks = 0;UPDATE customer SET customer_id=8, customer_name=happy WHERE customer_id=7;update orders set orders_id=999,customer_id = 8,amount=1000 where customer_id=7;set foreign_key_checks = 1");

				if (bool) {
					ResultSet result = state.getResultSet();
						Customer customer = new Customer(result.getInt("customer_id"), result.getString("customer_name"));
						Orders order = new Orders(result.getInt("order_id"), result.getInt("customer_id"),
								result.getDouble("amount"));
						System.out.println(
								customer.getCustomer_id() + " " + customer.getCustomer_name() + " " + order.getAmount());
					
				} else {
					int count = state.getUpdateCount();
					System.out.println(count);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


