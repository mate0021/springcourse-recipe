package rnd.mate00.springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import rnd.mate00.springboot.recipe.model.UnitOfMeasure;

import java.util.List;
import java.util.Optional;

/**
 * Created by mate00 on 13.09.17.
 */
public interface UnitsOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByName(String name);

    List<UnitOfMeasure> findAll();
}
