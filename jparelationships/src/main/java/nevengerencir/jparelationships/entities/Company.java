package nevengerencir.jparelationships.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
private String name;
@ManyToMany(cascade = CascadeType.PERSIST)
@JsonManagedReference
    private List<FreelanceEmployee> freelanceEmployees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FreelanceEmployee> getFreelanceEmployees() {
        return freelanceEmployees;
    }

    public void setFreelanceEmployees(List<FreelanceEmployee> freelanceEmployees) {
        this.freelanceEmployees = freelanceEmployees;
    }
}
