package nevengerencir.coffeeapi.repository;

import nevengerencir.coffeeapi.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}
