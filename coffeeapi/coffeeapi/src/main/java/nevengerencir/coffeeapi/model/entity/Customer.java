package nevengerencir.coffeeapi.model.entity;

import jakarta.persistence.*;
import nevengerencir.coffeeapi.model.embeddables.Address;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "key_generator")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "client_name")

    private String name;

    public Customer() {
    }





    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "street_name"))
    @AttributeOverride(name = "number", column = @Column(name = "street_number"))

    private Address address;
}
