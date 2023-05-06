package nevengerencir.coffee.controllers;

import nevengerencir.coffee.entities.Coffee;
import nevengerencir.coffee.entities.CoffeeShop;
import nevengerencir.coffee.entities.Details;
import nevengerencir.coffee.entities.Employee;
import nevengerencir.coffee.repos.CoffeeRepository;
import nevengerencir.coffee.repos.CoffeeShopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;
    private final CoffeeShopRepository coffeeShopRepository;

    public CoffeeController(CoffeeRepository coffeeRepository, CoffeeShopRepository coffeeShopRepository) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeShopRepository = coffeeShopRepository;
        Employee employee = new Employee();
        employee.setName("Lotte");
        CoffeeShop shop = new CoffeeShop();
        shop.setEmployees(new ArrayList<>());
        shop.setName("Normo");
        shop.getEmployees().add(employee);
        coffeeShopRepository.save(shop);
    }

    @GetMapping("/{id}")
    public Optional<Coffee> findCoffeeById(@PathVariable String id){
        return coffeeRepository.findById(Integer.valueOf(id));
    }
}
