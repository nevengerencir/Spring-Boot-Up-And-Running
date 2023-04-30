package nevengerencir.coffeeapi.model.entity;

import jakarta.persistence.*;
import nevengerencir.coffeeapi.model.entity.enums.Roast;

import java.time.LocalDate;
import java.util.Date;
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
    @Column(name = "roast_date")
    @Temporal(TemporalType.DATE)
    private Date date_roast;

    public Coffee(String name, Date date_exp) {
        this.name = name;
        this.date_roast = date_exp;
    }

    @Enumerated(EnumType.STRING)
    private final Roast roast = Roast.LIGHT;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDate_roast() {
        return date_roast;
    }

    public void setDate_roast(Date date_roast) {
        this.date_roast = date_roast;
    }

    public Coffee() {
    }
}
