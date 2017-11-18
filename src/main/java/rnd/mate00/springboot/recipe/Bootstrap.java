package rnd.mate00.springboot.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import rnd.mate00.springboot.recipe.model.*;
import rnd.mate00.springboot.recipe.repositories.CategoryRepository;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;
import rnd.mate00.springboot.recipe.repositories.UnitsOfMeasureRepository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
@Profile({"default"})
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private UnitsOfMeasureRepository unitsOfMeasureRepository;
	
	@Autowired
	public Bootstrap(
			RecipeRepository recipeRepository, 
			CategoryRepository categoryRepository, 
			UnitsOfMeasureRepository unitsOfMeasureRepository) {
		super();
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitsOfMeasureRepository = unitsOfMeasureRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Loading bootstrap from DEFAULT profile");
        populateRecipes();
	}
	
	private void populateRecipes() {
		UnitOfMeasure eachUom = unitsOfMeasureRepository.findByName("Pinch").orElseThrow(IllegalArgumentException::new);
		UnitOfMeasure teaspoonUom = unitsOfMeasureRepository.findByName("Teaspoon").orElseThrow(IllegalArgumentException::new);;
		UnitOfMeasure tableSpoonUom = unitsOfMeasureRepository.findByName("Tablespoon").orElseThrow(IllegalArgumentException::new);;
		
		Recipe someRecipe = new Recipe();
		Set<Category> categories = new HashSet<>();
		Category americanCategory = categoryRepository.findByDescription("American").orElse(new Category());
		Category mexicanCategory = categoryRepository.findByDescription("Mexican").orElse(new Category());
		categories.add(americanCategory);
		someRecipe.setCategories(categories);
		
		someRecipe.setCookTime(90);
		someRecipe.setDescription("Description of a recipe");
		someRecipe.setDifficulty(Difficulty.MODERATE);
		someRecipe.setDirections("Do this, do that");
		someRecipe.addIngredient(new Ingredient("salt n peppa", BigDecimal.valueOf(5), teaspoonUom));
		
		Notes note = new Notes();
		note.setRecipeNotes("additional notes");
		someRecipe.setNotes(note);
		note.setRecipe(someRecipe);
		
		
		recipeRepository.save(someRecipe);
		
		Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setCookTime(10);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        //very redundent - could add helper method, and make this simpler
        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoonUom));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");
        
        recipeRepository.save(guacRecipe);

	}

}
