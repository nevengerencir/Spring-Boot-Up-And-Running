package nevengerencir.jparelationships.repos;

import nevengerencir.jparelationships.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
