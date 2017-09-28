package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.CategoryCommand;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.model.Category;
import rnd.mate00.springboot.recipe.model.Recipe;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mate00 on 28.09.17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Override
    public Category convert(CategoryCommand source) {
        Set<Recipe> recipes = new HashSet<>();
        return new Category(source.getId(), source.getDescription(), recipes);
    }
}
