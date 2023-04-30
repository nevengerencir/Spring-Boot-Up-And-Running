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
    @Temporal(TemporalType.DATE)
    private Date date_exp;

    @Enumerated(EnumType.STRING)
   private Roast getRoast() {
        return roast;
    }

    private Roast roast;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_exp() {
        return date_exp;
    }

    public void setDate_exp(Date date_exp) {
        this.date_exp = date_exp;
    }

    public Coffee(String name) {
        this.name = name;

    }



    public Coffee() {
    }
}
