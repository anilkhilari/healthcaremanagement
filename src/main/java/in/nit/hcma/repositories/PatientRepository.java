package in.nit.hcma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hcma.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
