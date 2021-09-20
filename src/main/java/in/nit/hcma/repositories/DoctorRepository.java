package in.nit.hcma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hcma.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	

}
