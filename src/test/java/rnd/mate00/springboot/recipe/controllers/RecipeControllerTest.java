package rnd.mate00.springboot.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.service.RecipeService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by mate00 on 24.09.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class RecipeControllerTest {

    @InjectMocks
    private RecipeController subject;

    @Mock
    private RecipeService recipeService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        subject = new RecipeController(recipeService);
        mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
    }

    @Test
    public void shouldReturnViewName() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        when(recipeService.findById(1L)).thenReturn(recipe);

        // when
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

    @Test
    public void shouldReturnViewNameForNewRecipe() throws Exception {
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    public void shouldRedirectToShowNewRecipeAfterPost() throws Exception {
        RecipeCommand backingBean = new RecipeCommand();
        backingBean.setId(17L);
        backingBean.setDescription("famous new recipe");

        when(recipeService.saveRecipeCommand(any())).thenReturn(backingBean);

        mockMvc.perform(post("/recipeForm/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "famous new recipe"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/show/17"));
    }

    @Test
    public void shouldShowExistingRecipe() throws Exception {
        RecipeCommand backingBean = new RecipeCommand();
        backingBean.setId(2L);

        when(recipeService.findCommandById(anyLong())).thenReturn(backingBean);

        mockMvc.perform(get("/recipe/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));

    }

}