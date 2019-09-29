package Model;

public class Pacient {
	private String name;
	private String documentId;
	private String phone;
	private String address;
	private Login login;
	
	public Pacient(
		String userName,
		String password,
		String type,
		String name,
		String documentId,
		String phone,
		String address
	) {
		this.name = name;
		this.documentId = documentId;
		this.phone = phone;
		this.address = address;
		this.login = new Login(userName, password, type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
}
