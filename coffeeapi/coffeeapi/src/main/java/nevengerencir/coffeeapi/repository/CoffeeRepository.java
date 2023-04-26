package nevengerencir.coffeeapi.repository;

import nevengerencir.coffeeapi.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository <Coffee, String> {
}
