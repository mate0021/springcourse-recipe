package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.CategoryCommand;
import rnd.mate00.springboot.recipe.model.Category;

/**
 * Created by mate00 on 28.09.17.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Override
    public Category convert(CategoryCommand source) {
        return new Category(source.getId(), source.getDescription());
    }
}
