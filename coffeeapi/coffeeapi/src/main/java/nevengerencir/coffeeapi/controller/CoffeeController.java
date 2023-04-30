package nevengerencir.coffeeapi.controller;

import nevengerencir.coffeeapi.model.DTO.Greeting;
import nevengerencir.coffeeapi.model.entity.Coffee;
import nevengerencir.coffeeapi.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")

public class CoffeeController {
    private final Greeting greeting;

    private final CoffeeRepository coffeeRepository;

    public CoffeeController(Greeting greeting, CoffeeRepository coffeeRepository) {
        this.greeting = greeting;
        this.coffeeRepository = coffeeRepository;

        this.coffeeRepository.saveAll(List.of(new Coffee("Kenya",new Date()), new Coffee("Ethiopia",new Date()), new Coffee("Honduras",new Date())));
    }

    @GetMapping
    public Iterable<Coffee> GetCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> GetCoffeeById(@PathVariable String id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffee.setDate_exp(new Date());
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@RequestBody Coffee coffee, @PathVariable String id) {
        return (!coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED) : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }

    @GetMapping("/greeting")
    String getGreeting() {
        return greeting.getName();
    }
}
