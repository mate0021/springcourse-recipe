package rnd.mate00.springboot.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.repositories.IngredientRepository;

/**
 * Created by mate00 on 08.10.17.
 */
@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Ingredient findIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
