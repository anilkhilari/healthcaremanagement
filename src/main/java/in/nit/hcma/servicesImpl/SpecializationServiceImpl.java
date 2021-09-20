package in.nit.hcma.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hcma.entities.Specialization;
import in.nit.hcma.exception.SpecializationNotFoundException;
import in.nit.hcma.repositories.SpecializationRepository;
import in.nit.hcma.services.SpecializationService;

@Service
public class SpecializationServiceImpl implements SpecializationService {
	
	@Autowired
	private SpecializationRepository specializationRepository;
	private Object String;
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
	public void deleteSpecialization(Long id) {
		specializationRepository.delete(getSpecialization(id));
		
	}
	
	  @Override
	public Specialization getSpecialization(Long id) {
		Optional<Specialization> optional= specializationRepository.findById(id);
		
		if(optional.isPresent())
		{
			return optional.get();
		}else {
			
			String message= id +" not found ";
			throw new SpecializationNotFoundException(message);
		}
		
	  }
	  
	@Override
	public Specialization updateSpecialization(Specialization specialization) {
		specialization=specializationRepository.save(specialization);
		return specialization;
	}
	
	@Override
	public boolean isSpecCodeExist(String code) {
		/*Integer count = repo.getSpecCodeCount(specCode);
		boolean exist = count>0 ? true : false;
		return exist;*/
		return specializationRepository.getSpecCodeCount(code)>0;
	}
}
