package Model;

public class MedicalRecords {
	private String id;
	private String pacientId;
	private String doctorId;
	private String symptoms;
	private String bloodType;
	private String treatment;
	private String examDate;
	private String status;
	
	public MedicalRecords(
		String id,
		String pacientId,
		String doctorId,
		String symptoms,
		String bloodType,
		String examDate,
		String status,
		String treatment
	) {
		this.id = id;
		this.pacientId = pacientId;
		this.doctorId = doctorId;
		this.symptoms = symptoms;
		this.bloodType = bloodType;
		this.examDate = examDate;
		this.status = status;
		this.treatment = treatment;
	}


	public String getStatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getPacientId() {
		return pacientId;
	}

	public void setPacient(String pacientId) {
		this.pacientId = pacientId;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
		
}
