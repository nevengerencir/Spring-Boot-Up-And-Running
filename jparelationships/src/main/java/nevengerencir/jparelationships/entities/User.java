package nevengerencir.jparelationships.entities;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @TableGenerator(
            name="key_generator",
            table="key_generator",
            pkColumnName="key_name",
            valueColumnName="key_value",
            pkColumnValue="user",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    Adress adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
