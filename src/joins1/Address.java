package joins1;

public class Address {
	private int emp_id;
	private String address;

	public Address(int emp_id, String address) {
		super();
		this.emp_id = emp_id;
		this.address = address;
	}
	public Address(){}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
