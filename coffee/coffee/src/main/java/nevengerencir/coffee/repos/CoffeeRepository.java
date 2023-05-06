package nevengerencir.coffee.repos;

import nevengerencir.coffee.entities.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee,Integer> {
}
