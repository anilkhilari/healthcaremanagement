package in.nit.hcma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.hcma.entities.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
