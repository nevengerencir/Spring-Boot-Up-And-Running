package nevengerencir.jparelationships.controllers;

import nevengerencir.jparelationships.entities.Company;
import nevengerencir.jparelationships.entities.FreelanceEmployee;
import nevengerencir.jparelationships.entities.Patient;
import nevengerencir.jparelationships.repos.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
//        Company company1 = new Company();
//        Company company2 = new Company();
//        company1.setName("Coca cola");
//        company2.setName("IBM");
//        FreelanceEmployee employee1 = new FreelanceEmployee();
//        FreelanceEmployee employee2 = new FreelanceEmployee();
//        employee1.setName("Luka");
//        employee2.setName("Jovan");
//        company1.setFreelanceEmployees(List.of(employee1,employee2));
//        company2.setFreelanceEmployees(List.of(employee1,employee2));
//        companyRepository.saveAll(List.of(company1,company2));
    }

    @GetMapping
    public Iterable <Company> findAllCompanies(){
        return companyRepository.findAll();
    }

}
