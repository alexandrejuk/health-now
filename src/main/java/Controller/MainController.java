package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import Model.Login;
import Model.Pacient;

public class MainController {

	private static List<Employee> EMPLOYEES = new ArrayList<Employee>();
	private static List<Pacient> PACIENTS = new ArrayList<Pacient>();
	
	private static Employee createEmployee(int index, String role) {		
		Employee fakeEmploye = new Employee(
			"" + index,
			role + index,
			"123456e",
			"employee",
			"fake " + role + " "+ index,
			"" + index,
			role,
			"11987654321",
			"fake address employee, 899, FAE, 123434 - 000" + index
		);
		
		return fakeEmploye;
	};
	
	private static Pacient createPacient(int index) {
		Pacient fakePacient = new Pacient(
			""+ index,
			"pacient" + index,
			"123456p",
			"pacient",
			"fake pacient " + index,
			"" + index,
			"1209876554321",
			"fake address pacient, 100, FAP, 123434 - 000" + index,
			"A"
		);
		
		return fakePacient;
	};
	
	static {
		try {
			for(int item = 1; item <= 10; item++) {
				PACIENTS.add(createPacient(item));
				EMPLOYEES.add(createEmployee((item+100), "doctor"));
				EMPLOYEES.add(createEmployee((item), "secretary"));
			};
		} 
		catch (Exception e) { }
	}
	
	public Employee loginEmployee(String userName, String password) {
		Employee foundEmployee = null;

		for(int i = 0; i < EMPLOYEES.size(); i++) {
			Login login = EMPLOYEES.get(i).getLogin();
		    if (login.getUserName().equals(userName) && login.getPassword().equals(password)) {
		       foundEmployee = EMPLOYEES.get(i);
		    }
		}
		
		return foundEmployee;
	}
	
	public Pacient loginPacient(String userName, String password) {
		Pacient foundPacient = null;

		for(int i = 0; i < PACIENTS.size(); i++) {
			Login login = PACIENTS.get(i).getLogin();
		    if (login.getUserName().equals(userName) && login.getPassword().equals(password)) {
		    	foundPacient = PACIENTS.get(i);
		    }
		}
		
		return foundPacient;
	}
	
	public List<Employee> getAllEmployee() {
		return EMPLOYEES;
	}
	
	public List<Pacient> getAllPacient() {
		return PACIENTS;
	}
	
	public Pacient getPacientById(String id) {
		Pacient foundPacient = null;
		for(int i = 0; i < PACIENTS.size(); i++) {
			Pacient pacient = PACIENTS.get(i);
		    if (pacient.getId().equals(id)) {
		    	foundPacient = PACIENTS.get(i);
		    }
		}
		
		return foundPacient;
	}
	
	public Employee getEmployeeById(String id) {
		Employee foundEmployee = null;
		for(int i = 0; i < EMPLOYEES.size(); i++) {
			Employee employee = EMPLOYEES.get(i);
		    if (employee.getId().equals(id)) {
		    	foundEmployee = EMPLOYEES.get(i);
		    }
		}
		
		return foundEmployee;
	}
	
	public int totalPacient() {
		return PACIENTS.size();
	}
	
	
	
	public int totalDoctor() {
		int count = 0;
		for(int i = 0; i < EMPLOYEES.size(); i++) {
			if (EMPLOYEES.get(i).getRole().equals("doctor"))
				count += 1;
		}
		return count;
	}
	
	public Employee getEmployeeByDocumentId(String documentId) {
		Employee foundEmployee = null;
		for(int i = 0; i < EMPLOYEES.size(); i++) {
			Employee employee = EMPLOYEES.get(i);
		    if (employee.getId().equals(documentId)) {
		    	foundEmployee = EMPLOYEES.get(i);
		    }
		}
		
		return foundEmployee;
	}
	
	public Pacient newPacient(
			String userName,
			String password,
			String type,
			String name,
			String documentId,
			String phone,
			String address,
			String status
		) {
		String id = "" + (PACIENTS.size() + 1);
		Pacient pacient = new Pacient(
			id,
			userName,
			password,
			type,
			name,
			documentId,
			phone,
			address,
			status
		);	
		PACIENTS.add(pacient);
		
		return pacient;
	}
	
	public Employee newEmployee(
			String userName,
			String password,
			String type,
			String name,
			String documentId,
			String phone,
			String address,
			String role
		) {
		String id = "" + (EMPLOYEES.size() + 1);
		Employee employee = new Employee(
			id,
			userName,
			password,
			type,
			name,
			documentId,
			role,
			phone,
			address
		);	
		EMPLOYEES.add(employee);
		
		return employee;
	}
	
	public Pacient updatePacient(
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
		
		Pacient pacient = new Pacient(
			id,
			userName,
			password,
			type,
			name,
			documentId,
			phone,
			address,
			status
		);
		
		for(int i = 0; i < PACIENTS.size(); i++) {
		    if (PACIENTS.get(i).getId().equals(id)) {
		    	PACIENTS.set(i, pacient);
		    }
		}
		
		return pacient;
		
	}
	
	public Employee updateEmployee(
			String id,
			String userName,
			String password,
			String type,
			String name,
			String documentId,
			String phone,
			String address,
			String role
		) {
		
		Employee employee = new Employee(
			id,
			userName,
			password,
			type,
			name,
			documentId,
			phone,
			address,
			role
		);
		
		for(int i = 0; i < EMPLOYEES.size(); i++) {
		    if (EMPLOYEES.get(i).getId().equals(id)) {
		    	EMPLOYEES.set(i, employee);
		    }
		}
		
		return employee;
		
	}
}
