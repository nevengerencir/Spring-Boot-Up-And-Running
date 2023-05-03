package nevengerencir.coffeeapi.controller;

import nevengerencir.coffeeapi.model.entity.Customer;
import nevengerencir.coffeeapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerRepository.findById(Integer.valueOf(id));
    }
    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

}

