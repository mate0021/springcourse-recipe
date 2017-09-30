package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;

/**
 * Created by mate00 on 29.09.17.
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        Recipe result = new Recipe();
        result.setDescription(source.getDescription());
        result.setId(source.getId());
        result.setCookTime(source.getCookTime());
        result.setDifficulty(source.getDifficulty());
        result.setDirections(source.getDirections());
        result.setNotes(source.getNotes());

        return result;
    }
}
