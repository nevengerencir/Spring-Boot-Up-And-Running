package nevengerencir.coffeeapi.controller;

import nevengerencir.coffeeapi.entity.Coffee;
import nevengerencir.coffeeapi.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")

public class CoffeeController {
    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;

        this.coffeeRepository.saveAll(List.of(
                new Coffee("Kenya"),
                new Coffee("Ethiopia"),
                new Coffee("Honduras")
                ));
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
}
