package in.nit.hcma.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hcma.entities.Patient;
import in.nit.hcma.exception.PatientNotFoundException;
import in.nit.hcma.repositories.PatientRepository;
import in.nit.hcma.services.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository repo;
	
	@Override
	public Patient savePatient(Patient patient) {
		
		return repo.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {

		return repo.findAll();
	}

	@Override
	public void deletePatient(Long patientId) {
		
		repo.delete(getPatient(patientId));
		
	}

	@Override
	public Patient getPatient(Long patientId) {

		Optional<Patient> optional=repo.findById(patientId);
		if(optional.isPresent())
		{
			return optional.get();
		}else {
			
			String message= "Patient : "+patientId +" , not found ";
			throw new PatientNotFoundException(message); 
		}
		
	}

	@Override
	public Patient updatePatient(Patient patient) {
		patient= repo.save(patient);
		return patient;
	}

	

}
