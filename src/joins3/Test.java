package joins3;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			Statement state = connection.createStatement();
			boolean bool = state.execute(
					"select patient.patient_id,patient_name,doctor.doc_id,doc_name  from patient inner join doc_patient on patient.patient_id=doc_patient.patient_id inner join doctor on doc_patient.doc_id = doctor.doc_id");

			if (bool) {
				ResultSet result = state.getResultSet();
				while (result.next()) {
					Patient patient = new Patient(result.getInt("patient_id"), result.getString("patient_name"));
					Doctor doctor = new Doctor(result.getInt("doc_id"), result.getString("doc_name"));
					System.out.println(doctor.getDoc_id() + " " + doctor.getDoc_name() + " " + patient.getPatient_id()
							+ " " + patient.getPatient_name());
				}
			} else {
				int count = state.getUpdateCount();
				System.out.println(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
