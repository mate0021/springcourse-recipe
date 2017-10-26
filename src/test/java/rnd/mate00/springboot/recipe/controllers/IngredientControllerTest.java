package rnd.mate00.springboot.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.service.IngredientService;
import rnd.mate00.springboot.recipe.service.RecipeService;
import rnd.mate00.springboot.recipe.service.UnitOfMeasureService;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mate00 on 04.10.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class IngredientControllerTest {

    @InjectMocks
    private IngredientController subject;

    private MockMvc mockMvc;

    @Mock
    private RecipeService recipeService;

    @Mock
    private IngredientService ingredientService;

    @Mock
    private UnitOfMeasureService unitOfMeasureService;


    @Before
    public void setUp() {
        subject = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
        when(recipeService.findById(1L)).thenReturn(new Recipe());
        when(ingredientService.findIngredientById(2L)).thenReturn(new Ingredient());
        when(ingredientService.findCommandById(2L)).thenReturn(new IngredientCommand());
    }

    @Test
    public void shouldReturnIngredientViewName() throws Exception {
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/list"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void shouldReturnViewNameForSingleIngredient() throws Exception {
        mockMvc.perform(get("/recipe/1/ingredient/2/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/show"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("recipeId"));
    }

    @Test
    public void shouldReturnFormForIngredientUpdate() throws Exception {
        mockMvc.perform(get("/recipe/1/ingredient/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredients/ingredientform"))
                .andExpect(model().attributeExists("ingredient"));
    }

    @Test
    public void shouldRedirectToRecipeIngredientListAfterUpdate() throws Exception {
        IngredientCommand savedCommand = new IngredientCommand();
        savedCommand.setRecipeId(1L);
        savedCommand.setAmount(BigDecimal.valueOf(5));
        when(ingredientService.saveIngredientCommand(any())).thenReturn(savedCommand);
        
        mockMvc.perform(post("/recipe/1/ingredientForm/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("amount", "5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/1/ingredients"));

    }
}