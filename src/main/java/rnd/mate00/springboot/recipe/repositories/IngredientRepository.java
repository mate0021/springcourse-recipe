package rnd.mate00.springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import rnd.mate00.springboot.recipe.model.Ingredient;

/**
 * Created by mate00 on 09.10.17.
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
