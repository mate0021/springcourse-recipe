package rnd.mate00.springboot.recipe.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import rnd.mate00.springboot.recipe.model.Recipe;
import rnd.mate00.springboot.recipe.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by mate00 on 20.09.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class IndexControllerTest {

    private IndexController subject;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        subject = new IndexController(recipeService);
    }

    @Test
    public void shouldReturnViewName() {
        String viewName = subject.getAllRecipes(model);

        assertEquals("allRecipes", viewName);
    }

    @Test
    public void t() {
        // given
        Recipe r1 = new Recipe();
        r1.setDescription("recipe1");

        Recipe r2 = new Recipe();
        r2.setDescription("recipe2");

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(r1);
        recipes.add(r2);

        when(recipeService.getAllRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argCaptor = ArgumentCaptor.forClass(Set.class);

        // when
        subject.getAllRecipes(model);

        // then
        verify(recipeService).getAllRecipes();
        verify(model).addAttribute(eq("recipes"), argCaptor.capture());
        Set<Recipe> captured = argCaptor.getValue();
        System.out.println(captured);
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(subject).build(); // webAppSetup brings up whole spring context

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

}