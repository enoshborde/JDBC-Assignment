package crud;

public class doctor {
	private int doc_id;
	private String doc_name;
	public doctor(int doc_id, String doc_name) {
		super();
		this.doc_id = doc_id;
		this.doc_name = doc_name;
	}
	
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

}
