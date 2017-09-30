package rnd.mate00.springboot.recipe.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.converters.RecipeCommandToRecipe;
import rnd.mate00.springboot.recipe.converters.RecipeToRecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository recipeRepository;

	private RecipeCommandToRecipe recipeCommandToRecipe;

	private RecipeToRecipeCommand recipeToRecipeCommand;
	
	@Autowired
	public RecipeService(RecipeRepository recipeRepository,
                         RecipeCommandToRecipe recipeCommandToRecipe,
                         RecipeToRecipeCommand recipeToRecipeCommand) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}
	
	public Set<Recipe> getAllRecipes() {
		Set<Recipe> result = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(result::add);
		
		return result;
    }

    public Recipe findById(long id) {
        Recipe recipeById = recipeRepository.findById(id).orElseThrow(RuntimeException::new);

        return recipeById;
    }

    @Transactional // because we go through converters outside spring context
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
	    Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);
        Recipe saved = recipeRepository.save(detachedRecipe);
        System.out.println("Recipe from backing bean: " + detachedRecipe);
        System.out.println("Saved recipe: " + saved);

        return recipeToRecipeCommand.convert(saved);
    }

    @Transactional
    public RecipeCommand findCommandById(long id) {
        Recipe foundRecipe = findById(id);

        return recipeToRecipeCommand.convert(foundRecipe);
    }
}
