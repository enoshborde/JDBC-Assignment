package joins2;

public class Orders {
	private int order_id;
	private int customer_id;
	private double amount;

	public Orders(int order_id, int customer_id, double amount) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.amount = amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
