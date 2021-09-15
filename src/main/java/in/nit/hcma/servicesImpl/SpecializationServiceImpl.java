package in.nit.hcma.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hcma.entities.Specialization;
import in.nit.hcma.repositories.SpecializationRepository;
import in.nit.hcma.services.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Autowired
	private SpecializationRepository specializationRepository;
	@Override
	public Specialization saveSpecialization(Specialization specialization) {
		
		specialization=specializationRepository.save(specialization);
		return specialization;
	}
	
	@Override
	public List<Specialization> getAllSpecialization() {
		List<Specialization> specializations=specializationRepository.findAll();
		return specializations;
	}
	
	@Override
	public void deleteSpecialization(Integer id) {
		
		specializationRepository.deleteById(id);
	}
	
	  @Override
	public Specialization getSpecialization(Integer id) {
		Optional<Specialization> optional= specializationRepository.findById(id);
		
		if(optional.isPresent())
		{
			return optional.get();
		}else 
		
		return null;
		
	  }
	  
	@Override
	public Specialization updateSpecialization(Specialization specialization) {
		specialization=specializationRepository.save(specialization);
		return specialization;
	}
}
