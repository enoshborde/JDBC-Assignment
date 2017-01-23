package jdbc1;

import java.sql.*;

public class DbTransaction {

	private static String INSERT = "INSERT INTO employee (emp_id, emp_name, subject) VALUES (?, ?, ?)";

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = DbConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("There was an error getting the connection");
		}

		try {
			connection.setAutoCommit(false);
			System.out.println("The autocommit was disabled!");
		} catch (SQLException e) {
			System.out.println("There was an error disabling autocommit");
		}

		// Starts JDBC Transaction

		try {

			pstmt = connection.prepareStatement(INSERT);
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Madrid");
			pstmt.setString(3, "JDBC");
			pstmt.execute();

			connection.commit();
			System.out.println("The transaction was successfully executed");
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println(e.getMessage());
				System.out.println("The transaction was rollback");
			} catch (SQLException e1) {
				System.out.println("There was an error making a rollback");
			}
		}
	}
}
