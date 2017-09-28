package rnd.mate00.springboot.recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.commands.UnitOfMeasureCommand;
import rnd.mate00.springboot.recipe.model.UnitOfMeasure;

/**
 * Created by mate00 on 28.09.17.
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }

        return new UnitOfMeasureCommand(source.getId(), source.getName());
    }
}
