package nevengerencir.coffee.entities;

import jakarta.persistence.*;
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    @TableGenerator(name = "key_generator",
            table = "key_generator",
            pkColumnName = "key_name",
            valueColumnName = "key_value")
    private Integer id;

   private String name;
   @OneToOne(cascade = CascadeType.ALL)
    private Details details;

    public Coffee() {
    }

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

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }
}
