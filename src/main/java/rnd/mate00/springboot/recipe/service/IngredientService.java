package rnd.mate00.springboot.recipe.service;

import org.springframework.stereotype.Service;
import rnd.mate00.springboot.recipe.model.Ingredient;

/**
 * Created by mate00 on 08.10.17.
 */
@Service
public class IngredientService {

    public Ingredient findIngredientById(Long id) {
        return new Ingredient();
    }
}
