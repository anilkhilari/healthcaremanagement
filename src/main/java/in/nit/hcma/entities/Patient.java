package in.nit.hcma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_tab")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	private String patientFirstName;
	private String patientLastName;
	private String patientGender;
	// private Date patientDob;
	private String patientMaritalStatus;
	private String patientPresAddress;
	private String patientCommAddress;
	// private String patientPastMedicalHistory;
	private String patientOtherDetails;
	
	public Patient() {
		super();
	}

	public Patient(long patientId, String patientFirstName, String patientLastName, String patientGender,
			String patientMaritalStatus, String patientPresAddress, String patientCommAddress,
			String patientOtherDetails) {
		super();
		this.patientId = patientId;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientGender = patientGender;
		this.patientMaritalStatus = patientMaritalStatus;
		this.patientPresAddress = patientPresAddress;
		this.patientCommAddress = patientCommAddress;
		this.patientOtherDetails = patientOtherDetails;
	}

	public long getpatientId() {
		return patientId;
	}

	public void setpatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getpatientFirstName() {
		return patientFirstName;
	}

	public void setpatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getpatientLastName() {
		return patientLastName;
	}

	public void setpatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getpatientGender() {
		return patientGender;
	}

	public void setpatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientMaritalStatus() {
		return patientMaritalStatus;
	}

	public void setPatientMaritalStatus(String patientMaritalStatus) {
		this.patientMaritalStatus = patientMaritalStatus;
	}

	public String getPatientPresAddress() {
		return patientPresAddress;
	}

	public void setPatientPresAddress(String patientPresAddress) {
		this.patientPresAddress = patientPresAddress;
	}

	public String getPatientCommAddress() {
		return patientCommAddress;
	}

	public void setPatientCommAddress(String patientCommAddress) {
		this.patientCommAddress = patientCommAddress;
	}

	public String getPatientOtherDetails() {
		return patientOtherDetails;
	}

	public void setPatientOtherDetails(String patientOtherDetails) {
		this.patientOtherDetails = patientOtherDetails;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
				+ patientLastName + ", patientGender=" + patientGender + ", patientMaritalStatus="
				+ patientMaritalStatus + ", patientPresAddress=" + patientPresAddress + ", patientCommAddress="
				+ patientCommAddress + ", patientOtherDetails=" + patientOtherDetails + "]";
	}
	
	
	
	
	

}
