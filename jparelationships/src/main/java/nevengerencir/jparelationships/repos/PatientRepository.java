package nevengerencir.jparelationships.repos;


import nevengerencir.jparelationships.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
