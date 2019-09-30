package Model;

public class Pacient {
	private String id;
	private String name;
	private String documentId;
	private String phone;
	private String address;
	private Login login;
	private String status;
	public Pacient(
		String id,
		String userName,
		String password,
		String type,
		String name,
		String documentId,
		String phone,
		String address,
		String status
	) {
		this.id = id;
		this.name = name;
		this.documentId = documentId;
		this.phone = phone;
		this.address = address;
		this.login = new Login(userName, password, type);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
