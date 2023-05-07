package nevengerencir.coffeeapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import nevengerencir.coffeeapi.model.entity.enums.Roast;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
public class Coffee  implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @TableGenerator(
            name = "key_generator",
            table = "key_generator",
            pkColumnName = "key_name",
            valueColumnName = "key_value",
            pkColumnValue = "coffee_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Integer id;
    private String name;

    public RoastingDetails getRoastingDetails() {
        return roastingDetails;
    }

    public void setRoastingDetails(RoastingDetails roastingDetails) {
        this.roastingDetails = roastingDetails;
    }

    @OneToOne(mappedBy = "coffee",cascade = CascadeType.ALL)
    @JsonManagedReference

    private RoastingDetails roastingDetails;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Coffee() {
    }
}
