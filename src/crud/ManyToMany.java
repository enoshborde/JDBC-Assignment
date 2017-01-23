package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import joins3.Doctor;
import joins3.Patient;


public class ManyToMany {

	public static void main(String[] args) {
		
		//createPatDoc();
		//readPatDoc();
		//updatePatDoc();
		deletePatDoc();
	}
	public static void createPatDoc() {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null,p5=null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			patient p = new patient(16,"Sam");
			doctor d =new doctor(106,"Aditya");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("insert into patient values(?,?)");
			p3 = connection.prepareStatement("insert into doctor values(?,?)");
			p4 = connection.prepareStatement("insert into doc_patient values(?,?)");
			p5 = connection.prepareStatement("SET foreign_key_checks = 1");
			p2.setInt(1, p.getPatient_id());
			p2.setString(2, p.getPatient_name());
			p3.setInt(1, d.getDoc_id());
			p3.setString(2, d.getDoc_name());
			p4.setInt(1, d.getDoc_id());
			p4.setInt(2, p.getPatient_id());
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			p5.execute();
			System.out.println("1 customer created...");

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.exit(1);
		} finally {
			try {
				p1.close();
				p2.close();
				p3.close();
				p4.close();
				p5.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}

	}
	public static void readPatDoc() {
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

	public static void updatePatDoc() {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null,p5=null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			patient p = new patient(17,"Sammy");
			doctor d =new doctor(107,"Arav");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("update patient set patient_id=?, patient_name=? where patient_id=16");
			p3 = connection.prepareStatement("update doctor set doc_id=?, doc_name=? where doc_id=106");
			p4 = connection.prepareStatement("update doc_patient set doc_id=?,patient_id=? where doc_id=106");
			p5 = connection.prepareStatement("SET foreign_key_checks = 1");
			p2.setInt(1, p.getPatient_id());
			p2.setString(2, p.getPatient_name());
			p3.setInt(1, d.getDoc_id());
			p3.setString(2, d.getDoc_name());
			p4.setInt(1, d.getDoc_id());
			p4.setInt(2, p.getPatient_id());
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			p5.execute();
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
				p5.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}

	}
	public static void deletePatDoc() {
		Connection connection = null;
		PreparedStatement p1 = null, p2 = null, p3 = null, p4 = null,p5=null;
		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jnit", "root", "root");
			p1 = connection.prepareStatement("set foreign_key_checks = 0;");
			p2 = connection.prepareStatement("delete from patient where patient_id=17");
			p3 = connection.prepareStatement("delete from doctor where doc_id=107");
			p4 = connection.prepareStatement("delete from doc_patient where doc_id=107");
			p5 = connection.prepareStatement("SET foreign_key_checks = 1");
			p1.execute();
			p2.execute();
			p3.execute();
			p4.execute();
			p5.execute();
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
				p5.close();
				connection.close();
			} catch (Exception e) {
				System.exit(1);
			}
		}

	}



}
