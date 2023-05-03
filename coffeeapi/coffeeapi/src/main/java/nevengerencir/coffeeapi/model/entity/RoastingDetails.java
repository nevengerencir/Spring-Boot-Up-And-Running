package nevengerencir.coffeeapi.model.entity;

import jakarta.persistence.*;
import nevengerencir.coffeeapi.model.entity.enums.Roast;

import java.util.Date;

@Entity
@Table(name = "roasting_details")
public class RoastingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String roaster;

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @OneToOne( cascade = CascadeType.PERSIST)
    private Coffee coffee;
    @Enumerated(EnumType.STRING)
    private final Roast type = Roast.LIGHT;

    public RoastingDetails() {

    }


    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date roastingDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoaster() {
        return roaster;
    }

    public void setRoaster(String roaster) {
        this.roaster = roaster;
    }

    public Roast getType() {
        return type;
    }

    public Date getRoastingDate() {
        return roastingDate;
    }

    public void setRoastingDate(Date roastingDate) {
        this.roastingDate = roastingDate;
    }

}
