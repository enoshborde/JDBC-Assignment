package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class scrollType {

	public static void test() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery("select * from employee");
			// beforeFirst(),first(),last(), afterLast(),previous().
			boolean executeOnce = true;

			while (result.next()) {

				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.print(result.getString("subject"));
				System.out.println();
				if (executeOnce) {
					result.previous();
					executeOnce = false;
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void test1() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery("select * from employee");
			// beforeFirst(),first(),last(), afterLast(),previous().
			result.next();
			System.out.print(result.getInt("emp_id"));
			System.out.print(result.getString("emp_name"));
			System.out.print(result.getString("subject"));
			System.out.println();
			result.first();
			// result.absolute(2);
			System.out.print(result.getInt("emp_id"));
			System.out.print(result.getString("emp_name"));
			System.out.print(result.getString("subject"));
			System.out.println();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	public static void withResources() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root")) 
		{
			Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery("select * from employee");
			// beforeFirst(),first(),last(), afterLast(),previous().
			result.next();
			System.out.print(result.getInt("emp_id"));
			System.out.print(result.getString("emp_name"));
			System.out.print(result.getString("subject"));
			System.out.println();
			result.first();
			// result.absolute(2);
			System.out.print(result.getInt("emp_id"));
			System.out.print(result.getString("emp_name"));
			System.out.print(result.getString("subject"));
			System.out.println();

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		test();
		// test1();
		//withResources();
	}

}
