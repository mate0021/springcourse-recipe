package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import rnd.mate00.springboot.recipe.commands.CategoryCommand;
import rnd.mate00.springboot.recipe.model.Category;

/**
 * Created by mate00 on 29.09.17.
 */
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Override
    public CategoryCommand convert(Category source) {
        if (source == null) {
            return null;
        }

        return new CategoryCommand(source.getId(), source.getDescription());
    }
}
