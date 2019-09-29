package Model;

public class MedicalRecords {
	private Pacient pacient;
	private String symptoms;
	private String bloodType;
	private String treatment;
	private String examDate;
	
	public MedicalRecords(
		Pacient pacient,
		String symptoms,
		String bloodType,
		String treatment,
		String examDate
	) {
		this.pacient = pacient;
		this.symptoms = symptoms;
		this.bloodType = bloodType;
		this.treatment = treatment;
		this.examDate = examDate;
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
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
