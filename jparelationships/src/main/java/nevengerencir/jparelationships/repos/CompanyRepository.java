package nevengerencir.jparelationships.repos;

import nevengerencir.jparelationships.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Integer> {
}
