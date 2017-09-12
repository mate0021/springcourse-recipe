package rnd.mate00.springboot.recipe.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by mate00 on 12.09.17.
 */
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure units;

    @ManyToOne()
    private Recipe recipe;


}
