package rnd.mate00.springboot.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import rnd.mate00.springboot.recipe.model.Category;

import java.util.Optional;

/**
 * Created by mate00 on 13.09.17.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
