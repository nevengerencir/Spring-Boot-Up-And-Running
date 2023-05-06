package nevengerencir.coffee.controllers;

import nevengerencir.coffee.entities.Coffee;
import nevengerencir.coffee.entities.Details;
import nevengerencir.coffee.repos.CoffeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
        Coffee coffee = new Coffee();
        Details details = new Details();
        coffee.setName("Kenya");
        details.setInfo("populating a field in Coffee");
        coffee.setDetails(details);
        coffeeRepository.save(coffee);
    }

    @GetMapping("/{id}")
    public Optional<Coffee> findCoffeeById(@PathVariable String id){
        return coffeeRepository.findById(Integer.valueOf(id));
    }
}
