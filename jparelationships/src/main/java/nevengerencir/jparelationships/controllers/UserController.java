package nevengerencir.jparelationships.controllers;

import nevengerencir.jparelationships.entities.Adress;
import nevengerencir.jparelationships.entities.User;
import nevengerencir.jparelationships.repos.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
//        User user = new User();
//        Adress adress = new Adress();
//        adress.setName("Erwtenstraat");
//        adress.setNumber(14);
//        user.setAdress(adress);
//        user.setName("Neven");
//        userRepository.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable String id){
return userRepository.findById(Integer.valueOf(id));
    }
}
