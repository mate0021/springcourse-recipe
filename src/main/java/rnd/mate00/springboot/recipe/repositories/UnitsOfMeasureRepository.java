package rnd.mate00.springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import rnd.mate00.springboot.recipe.model.UnitOfMeasure;

/**
 * Created by mate00 on 13.09.17.
 */
public interface UnitsOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
