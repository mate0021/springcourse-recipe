package rnd.mate00.springboot.recipe.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.model.Recipe;

/**
 * Created by mate00 on 29.09.17.
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    @Autowired
    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.unitOfMeasureCommandToUnitOfMeasure = unitOfMeasureCommandToUnitOfMeasure;
    }


    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setId(source.getRecipeId());

        Ingredient result = new Ingredient();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        result.setAmount(source.getAmount());
        result.setRecipe(recipe);
        result.setUnits(unitOfMeasureCommandToUnitOfMeasure.convert(source.getUnits()));

        return result;
    }
}
