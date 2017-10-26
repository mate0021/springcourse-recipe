package rnd.mate00.springboot.recipe.commands;

import java.math.BigDecimal;

/**
 * Created by mate00 on 28.09.17.
 */
public class IngredientCommand {

    private long id;

    private String description;

    private BigDecimal amount;

    private UnitOfMeasureCommand units;

    private RecipeCommand recipe;

    private Long recipeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
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

    public UnitOfMeasureCommand getUnits() {
        return units;
    }

    public void setUnits(UnitOfMeasureCommand units) {
        this.units = units;
    }

    public RecipeCommand getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeCommand recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "IngredientCommand{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", units=" + units +
                ", recipe=" + recipe +
                ", recipeId=" + recipeId +
                '}';
    }
}
