package rnd.mate00.springboot.recipe.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rnd.mate00.springboot.recipe.converters.RecipeCommandToRecipe;
import rnd.mate00.springboot.recipe.converters.RecipeToRecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.repositories.RecipeRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by mate00 on 24.09.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceTest {

    @InjectMocks
    private RecipeService subject;

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() {
        subject = new RecipeService(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void shouldReturnRecipe() {
        // given
        Recipe recipe = new Recipe();
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(1L)).thenReturn(recipeOptional);

        // when
        Recipe result = subject.findById(1L);

        // then
        assertEquals(recipe, result);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExcWhenRecipeNotFound() {
        when(recipeRepository.findById(1L)).thenThrow(new RuntimeException());

        subject.findById(1L);
    }

}