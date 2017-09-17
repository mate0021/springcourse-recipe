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

    public Ingredient() {}
    
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure units) {
		super();
		this.description = description;
		this.amount = amount;
		this.units = units;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUnits() {
		return units;
	}

	public void setUnits(UnitOfMeasure units) {
		this.units = units;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Ingredient [description=" + description + ", amount=" + amount + ", units=" + units + "]";
	}

    

}
