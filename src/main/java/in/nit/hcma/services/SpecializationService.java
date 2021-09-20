package in.nit.hcma.services;

import java.util.List;

import in.nit.hcma.entities.Specialization;

public interface SpecializationService {
	
	public Specialization saveSpecialization(Specialization specialization);
	public List<Specialization> getAllSpecialization();
	public void deleteSpecialization(Long id);
	public Specialization getSpecialization(Long id);
	public Specialization updateSpecialization(Specialization specialization);
	public boolean isSpecCodeExist(String code); 

}
