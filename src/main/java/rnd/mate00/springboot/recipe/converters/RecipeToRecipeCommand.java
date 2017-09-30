package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;

/**
 * Created by mate00 on 29.09.17.
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

    @Override
    public RecipeCommand convert(Recipe source) {
        RecipeCommand result = new RecipeCommand();

        result.setDifficulty(source.getDifficulty());
        result.setDirections(source.getDirections());
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        result.setCookTime(source.getCookTime());

        return result;
    }
}
