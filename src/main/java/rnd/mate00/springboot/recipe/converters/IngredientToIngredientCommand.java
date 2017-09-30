package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;

/**
 * Created by mate00 on 29.09.17.
 */
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        IngredientCommand result = new IngredientCommand();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        result.setAmount(source.getAmount());

        return result;
    }
}
