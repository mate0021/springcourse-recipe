package rnd.mate00.springboot.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rnd.mate00.springboot.recipe.commands.UnitOfMeasureCommand;
import rnd.mate00.springboot.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import rnd.mate00.springboot.recipe.model.UnitOfMeasure;
import rnd.mate00.springboot.recipe.repositories.UnitsOfMeasureRepository;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by mate00 on 22.10.17.
 */
@Service
public class UnitOfMeasureService {

    private UnitsOfMeasureRepository unitsOfMeasureRepository;

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Autowired
    public UnitOfMeasureService(UnitsOfMeasureRepository unitsOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitsOfMeasureRepository = unitsOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    public Set<UnitOfMeasure> findAllUnitsOfMeasure() {
        return unitsOfMeasureRepository
                .findAll()
                .stream()
                .collect(toSet());
    }

    public List<UnitOfMeasureCommand> getAllUnitsOfMeasureCommand() {
        return findAllUnitsOfMeasure().stream()
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(toList());
    }
}
