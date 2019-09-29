package Model;

public class Employee {
	private String name;
	private String documentId;
	private String role;
	private String phone;
	private String address;
	private Login login;
	
	public Employee(
		String userName,
		String password,
		String type,
		String name,
		String documentId,
		String role,
		String phone,
		String address
	) {
		this.name = name;
		this.documentId = documentId;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
