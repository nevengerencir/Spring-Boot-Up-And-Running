package nevengerencir.hospital.repos;

import nevengerencir.hospital.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient,Integer> {
}
