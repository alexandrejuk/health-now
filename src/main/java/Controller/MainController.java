package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import Model.Login;
import Model.MedicalRecords;
import Model.Pacient;

public class MainController {

	private static List<Employee> EMPLOYEES = new ArrayList<Employee>();
	private static List<Pacient> PACIENTS = new ArrayList<Pacient>();
	private static List<MedicalRecords> SCHEDULES = new ArrayList<MedicalRecords>();
	
	private static MedicalRecords createMedicalRecords(int index) {		
		MedicalRecords fakeMedicalRecords = new MedicalRecords(
			"" + index,
			PACIENTS.get(index).getId(),
			"101",
			"Nausea e dores na cabeça",
			"B+",
			"2019-09-07",
			"waiting_doctor",
			""
		);
		
		return fakeMedicalRecords;
	};
	
	
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
			
			for(int item = 1; item <= 4; item++) {
				EMPLOYEES.add(createEmployee((item+100), "doctor"));
				EMPLOYEES.add(createEmployee((item), "secretary"));
			};
			
			for(int item = 1; item <= 3; item++) {
				PACIENTS.add(createPacient(item));
			};
			
			for(int item = 1; item <= 5; item++) {
				SCHEDULES.add(createMedicalRecords(item));
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
	
	public List<MedicalRecords> getAllShedule() {
		return SCHEDULES;
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
	
	
	public MedicalRecords getScheduleById(String id) {
		MedicalRecords foundShedule = null;
		for(int i = 0; i < SCHEDULES.size(); i++) {
			MedicalRecords shedule = SCHEDULES.get(i);
		    if (shedule.getId().equals(id)) {
		    	foundShedule = shedule;
		    }
		}
		
		return foundShedule;
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
	
	public Pacient getPacientByDocumentId(String documentId) {
		Pacient foundPacient = null;
		for(int i = 0; i < PACIENTS.size(); i++) {
			Pacient pacient = PACIENTS.get(i);
		    if (pacient.getId().equals(documentId)) {
		    	foundPacient = PACIENTS.get(i);
		    }
		}
		
		return foundPacient;
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
	public MedicalRecords newShedule(
			String pacientId,
			String doctorId,
			String symptoms,
			String bloodType,
			String examDate,
			String status
		) {
		String id = "" + (SCHEDULES.size() + 1);
		MedicalRecords shedule = new MedicalRecords(
			id,
			pacientId,
			doctorId,
			symptoms,
			bloodType,
			examDate,
			status,
			""
		);	
		SCHEDULES.add(shedule);
		
		return shedule;
	}
	
	public MedicalRecords updateShedule(
			String id,
			String pacientId,
			String doctorId,
			String symptoms,
			String bloodType,
			String examDate,
			String status,
			String treatment
		) {
		MedicalRecords shedule = new MedicalRecords(
			id,
			pacientId,
			doctorId,
			symptoms,
			bloodType,
			examDate,
			status,
			treatment
		);	
		
		for(int i = 0; i < SCHEDULES.size(); i++) {
		    if (SCHEDULES.get(i).getId().equals(id)) {
		    	SCHEDULES.set(i, shedule);
		    }
		}
				
		return shedule;
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
	
	public int totalSchedule(String doctorId) {
		int total = 0;
		if(doctorId == null) 
			return total;
		for(int i = 0; i < SCHEDULES.size(); i++) {
			
			if(
				SCHEDULES.get(i).getStatus().equals("waiting_doctor") && 
				SCHEDULES.get(i).getDoctorId().equals(doctorId)
			) {
				total += 1;
			}
		}
		return total;
	}
	
	public int totalScheduleFinish(String doctorId) {
		int total = 0;
		if(doctorId == null) {
			return total;
		}
		for(int i = 0; i < SCHEDULES.size(); i++) {
			
			if(
				SCHEDULES.get(i).getStatus().equals("finished") && 
				SCHEDULES.get(i).getDoctorId().equals(doctorId)
			) {
				total += 1;
			}
		}
		return total;
	}
}
