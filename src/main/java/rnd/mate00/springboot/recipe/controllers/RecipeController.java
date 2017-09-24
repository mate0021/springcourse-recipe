package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rnd.mate00.springboot.recipe.service.RecipeService;

/**
 * Created by mate00 on 24.09.17.
 */
@Controller
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String findRecipeById(@PathVariable String id, Model model) {
        long recipeId = Long.parseLong(id);

        model.addAttribute("recipe", recipeService.findById(recipeId));

        return "recipe/show";
    }
}
