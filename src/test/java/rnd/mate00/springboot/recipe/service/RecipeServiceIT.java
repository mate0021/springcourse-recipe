package rnd.mate00.springboot.recipe.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.converters.RecipeCommandToRecipe;
import rnd.mate00.springboot.recipe.converters.RecipeToRecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by mate00 on 29.09.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    @Autowired
    private RecipeService subject;

    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Autowired
    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void t() {
        Recipe recipe = recipeRepository.findById(1L).orElseThrow(IllegalArgumentException::new);
        RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);

        recipeCommand.setDescription("new description");
        RecipeCommand savedRecipeCommand = subject.saveRecipeCommand(recipeCommand);

        assertEquals(recipeCommand.getId(), savedRecipeCommand.getId());
        assertNotEquals(recipe.getDescription(), savedRecipeCommand.getDescription());
    }
}