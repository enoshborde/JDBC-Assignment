package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employee {
	private int emp_id;
	private String emp_name;

	public employee(int emp_id, String emp_name, String subject) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.subject = subject;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private String subject;

	public static void main(String[] args) {
		test(1);
	}

	public static void test(int emp_id) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			boolean bool = state.execute("select * from employee where emp_id=" + emp_id);

			if (bool) {
				ResultSet result = state.getResultSet();
				List<employee> emp1 = new ArrayList<>();
				if (result.next()) {
					employee emp = new employee(result.getInt("emp_id"), result.getString("emp_name"),
							result.getString("subject"));
					emp1.add(emp);
					System.out.println(emp.getEmp_id() + emp.getEmp_name() + emp.getSubject());
				}
			} else {
				int count = state.getUpdateCount();
				System.out.println(count);
			}

			// state.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
