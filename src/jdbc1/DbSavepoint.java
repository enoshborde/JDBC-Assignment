package jdbc1;

import java.sql.*;

public class DbSavepoint {
	private static String INSERT = "INSERT INTO employee (emp_id, emp_name,subject ) VALUES (?, ?, ?)";

	public static void insertRow(Connection connection, int emp_id, String emp_name, String subject)
			throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = connection.prepareStatement(INSERT);
		pstmt.setInt(1, emp_id);
		pstmt.setString(2, emp_name);
		pstmt.setString(3, subject);
		pstmt.execute();
		pstmt.close();
	}

	public static void main(String[] args) {
		Connection connection = null;
		Savepoint savepoint = null;
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
			insertRow(connection, 1, "Enosh", "Python");
			insertRow(connection, 2, "Eibar", "Devops");
			savepoint = connection.setSavepoint("SavePoint1");
			insertRow(connection, 3, "Galicia", "Salesforce");
			connection.commit();
			System.out.println("The transaction was successfully executed");
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println(e.getMessage());
				System.out.println("The transaction was rollback to the last savepoint");
			} catch (SQLException e1) {
				System.out.println("There was an error making a rollback");
			}
		}
	}
}
