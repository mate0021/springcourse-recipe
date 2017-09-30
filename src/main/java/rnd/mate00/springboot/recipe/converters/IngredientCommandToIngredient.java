package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;

/**
 * Created by mate00 on 29.09.17.
 */
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        Ingredient result = new Ingredient();
        result.setId(source.getId());
        result.setDescription(source.getDescription());

        return result;
    }
}
