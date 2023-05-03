package nevengerencir.coffeeapi.controller;

import nevengerencir.coffeeapi.model.DTO.Greeting;
import nevengerencir.coffeeapi.model.entity.Coffee;
import nevengerencir.coffeeapi.model.entity.Customer;
import nevengerencir.coffeeapi.model.entity.RoastingDetails;
import nevengerencir.coffeeapi.repository.CoffeeRepository;
import nevengerencir.coffeeapi.repository.CustomerRepository;
import nevengerencir.coffeeapi.repository.RoastingDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")

public class CoffeeController {
    private final Greeting greeting;

    private final CoffeeRepository coffeeRepository;
    private final CustomerRepository customerRepository;
    private final RoastingDetailsRepository roastingDetailsRepository;

    public CoffeeController(Greeting greeting, CoffeeRepository coffeeRepository, CustomerRepository customerRepository, RoastingDetailsRepository roastingDetailsRepository) {
        this.greeting = greeting;
        this.coffeeRepository = coffeeRepository;
        this.customerRepository = customerRepository;
        this.roastingDetailsRepository = roastingDetailsRepository;

        Coffee coffee = new Coffee();
        coffee.setName("Kenya Natural V2");
//        coffeeRepository.save(coffee);
        RoastingDetails details = new RoastingDetails();
        details.setRoaster("Neven");
        details.setRoastingDate(new Date());
        details.setCoffee(coffee);
        roastingDetailsRepository.save(details);

//        this.coffeeRepository.saveAll(List.of(new Coffee("Kenya",new Date()), new Coffee("Ethiopia",new Date()), new Coffee("Honduras",new Date())));
//        Customer customerTest = new Customer();
//customerTest.setStreet_name("Viska 28");
//customerTest.setCity("Antwerp");
//customerTest.setNumber(23);
//customerTest.setName("Normo Coffee");
//        this.customerRepository.save(customerTest);

    }

    @GetMapping
    public Iterable<Coffee> GetCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> GetCoffeeById(@PathVariable String id) {
        return coffeeRepository.findById(Integer.valueOf(id));
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@RequestBody Coffee coffee, @PathVariable String id) {
        return (!coffeeRepository.existsById(Integer.valueOf(id))) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED) : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(Integer.valueOf(id));
    }

    @GetMapping("/greeting")
    String getGreeting() {
        return greeting.getName();
    }
}
