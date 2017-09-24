package rnd.mate00.springboot.recipe.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

@Service
public class RecipeService {

	public RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
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
}
