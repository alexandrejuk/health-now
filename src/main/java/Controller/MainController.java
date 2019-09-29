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
		Employee newEmployee = new Employee(
			role + index,
			"123456" + role,
			"employee",
			"fake employee " + role + " "+ index,
			"12345678000" + index,
			role,
			"11987654321",
			"fake address employee, 899, FAE, 123434 - 000" + index
		);
		
		return newEmployee;
	};
	
	private static Pacient createPacient(int index) {
		Pacient newPacient = new Pacient(
			"pacient" + index,
			"123456p",
			"pacient",
			"fake pacient" + index,
			"9876554321000" + index,
			"1209876554321",
			"fake address pacient, 100, FAP, 123434 - 000" + index
		);
		
		return newPacient;
	};
	
	static {
		try {
			for(int item = 1; item < 10; item++) {
				PACIENTS.add(createPacient(item));
				EMPLOYEES.add(createEmployee(item, "doctor"));
				EMPLOYEES.add(createEmployee(item, "secretary"));
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
}
