package nevengerencir.coffeeapi.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Coffee {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @TableGenerator(
            name="key_generator",
            table="key_generator",
            pkColumnName="key_name",
            valueColumnName="key_value",
            pkColumnValue="coffee_id")
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "key_generator")
    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coffee(String name) {
        this.name = name;
    }



    public Coffee() {
    }
}
