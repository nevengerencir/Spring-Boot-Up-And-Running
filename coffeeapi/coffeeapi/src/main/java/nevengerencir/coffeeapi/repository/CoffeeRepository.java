package nevengerencir.coffeeapi.repository;

import nevengerencir.coffeeapi.model.entity.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository <Coffee, Integer> {
}
