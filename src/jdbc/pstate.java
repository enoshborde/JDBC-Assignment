package jdbc;

import java.sql.*;

public class pstate {

	public static void test(String emp_name) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			PreparedStatement state = connection.prepareStatement("select * from employee where emp_name=? and subject=?");
			state.setString(1,emp_name);
			state.setString(2, "-bio");
			ResultSet result = state.executeQuery();

			if (result.next()) {

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
	public static void test2(int emp_id) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			boolean bool = state.execute("select * from employee where emp_id=" + emp_id);

			if (bool) {
				ResultSet result = state.getResultSet();
				if (result.next()){
					int count = result.getInt(1);
					System.out.println(count);
				System.out.print(result.getInt("emp_id"));
				System.out.print(result.getString("emp_name"));
				System.out.print(result.getString("subject"));
				System.out.println();
			}else{
				int count=state.getUpdateCount();
				System.out.println(count);
			}
			}
			//state.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		test("-Sandy");
	}

}
