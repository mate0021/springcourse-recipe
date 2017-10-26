package rnd.mate00.springboot.recipe.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;

/**
 * Created by mate00 on 29.09.17.
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Autowired
    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }

        IngredientCommand result = new IngredientCommand();
        result.setId(source.getId());
        result.setDescription(source.getDescription());
        result.setAmount(source.getAmount());
        result.setUnits(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnits()));

        return result;
    }
}
