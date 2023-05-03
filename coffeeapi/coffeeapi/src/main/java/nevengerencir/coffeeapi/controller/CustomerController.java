package nevengerencir.coffeeapi.controller;

import nevengerencir.coffeeapi.model.entity.Customer;
import nevengerencir.coffeeapi.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> getCustomerRepository(@RequestParam String id) {
        return customerRepository.findById(Integer.valueOf(id));
    }
}
