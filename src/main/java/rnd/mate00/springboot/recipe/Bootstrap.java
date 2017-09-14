package rnd.mate00.springboot.recipe;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import rnd.mate00.springboot.recipe.model.Category;
import rnd.mate00.springboot.recipe.model.Difficulty;
import rnd.mate00.springboot.recipe.model.Notes;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.CategoryRepository;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	
	@Autowired
	public Bootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		populateRecipies();
	}
	
	private void populateRecipies() {
		Recipe r = new Recipe();
		Set<Category> categories = new HashSet<>();
		Category americanCategory = categoryRepository.findByDescription("American").orElse(new Category());
		categories.add(americanCategory);
		r.setCategories(categories);
		
		r.setCookTime(90);
		r.setDescription("Description of a recipe");
		r.setDifficulty(Difficulty.MODERATE);
		r.setDirections("Do this, do that");
		
		Notes note = new Notes();
		note.setRecipeNotes("additional notes");
		r.setNotes(note);
		note.setRecipe(r);
		
		recipeRepository.save(r);
	}

}
