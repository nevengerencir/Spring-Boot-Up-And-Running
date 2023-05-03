package nevengerencir.coffeeapi.model.entity;

import jakarta.persistence.*;
import nevengerencir.coffeeapi.model.embeddables.Address;

@Entity
@SecondaryTable(name = "address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "customer"))

public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;

    public Customer() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

@Column(table = "address")
    private String city;
    @Column(table = "address")

    private Integer number;
    @Column(table = "address", name = "name")

    private String street_name;
}
