package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rnd.mate00.springboot.recipe.commands.RecipeCommand;
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

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipeForm") // matches html form action name
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand) { // will find form to match RecipeCommand
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);

        return "redirect:/recipe/show/" + savedRecipeCommand.getId(); // just after creating will redirect to newly saved Recipe
    }
}
