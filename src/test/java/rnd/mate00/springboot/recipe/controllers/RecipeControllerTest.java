package rnd.mate00.springboot.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.service.RecipeService;

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

    @Before
    public void setUp() {
        subject = new RecipeController(recipeService);
    }

    @Test
    public void shouldReturnViewName() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        when(recipeService.findById(1L)).thenReturn(recipe);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(subject).build();

        // when
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"));
    }

}