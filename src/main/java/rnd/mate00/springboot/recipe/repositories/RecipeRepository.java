package rnd.mate00.springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import rnd.mate00.springboot.recipe.model.Recipe;

/**
 * Created by mate00 on 13.09.17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
