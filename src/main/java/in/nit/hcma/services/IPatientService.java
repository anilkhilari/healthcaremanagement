package in.nit.hcma.services;

import java.util.List;

import in.nit.hcma.entities.Patient;

public interface IPatientService {

	public Patient savePatient(Patient patient);

	public List<Patient> getAllPatient();

	public void deletePatient(Long patientId);

	public Patient getPatient(Long patientId);

	public Patient updatePatient(Patient patient);


}
