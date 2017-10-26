package rnd.mate00.springboot.recipe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.converters.IngredientCommandToIngredient;
import rnd.mate00.springboot.recipe.converters.IngredientToIngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.IngredientRepository;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

/**
 * Created by mate00 on 08.10.17.
 */
@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    private RecipeRepository recipeRepository;

    private IngredientToIngredientCommand ingredientToIngredientCommand;

    private IngredientCommandToIngredient ingredientCommandToIngredient;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientToIngredientCommand, IngredientCommandToIngredient ingredientCommandToIngredient) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
    }

    public Ingredient findIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElse(new Recipe());
        return new IngredientCommand();
    }

    public IngredientCommand findCommandById(Long idIngredient) {
        Ingredient ingredient = ingredientRepository.findById(idIngredient).orElseGet(Ingredient::new);

        IngredientCommand ingredientCommand = ingredientToIngredientCommand.convert(ingredient);

        return ingredientCommand;
    }

    public IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand) {
        Ingredient saved = ingredientRepository.save(ingredientCommandToIngredient.convert(ingredientCommand));
        return ingredientToIngredientCommand.convert(saved);
    }
}
