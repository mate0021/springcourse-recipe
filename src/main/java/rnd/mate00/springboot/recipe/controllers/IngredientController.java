package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.service.IngredientService;
import rnd.mate00.springboot.recipe.service.RecipeService;

import java.util.Set;

/**
 * Created by mate00 on 04.10.17.
 */
@Controller
public class IngredientController {

    private RecipeService recipeService;

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String getIngredientList(@PathVariable String id, Model model) {
        Long idLong = Long.parseLong(id);
        Set<Ingredient> ingredients = recipeService.findById(idLong).getIngredients();
        model.addAttribute("recipe", recipeService.findById(idLong));
        model.addAttribute("ingredients", ingredients);
        return "recipe/ingredients/list";
    }

    @RequestMapping("/recipe/{id}/ingredients/{idIngredient}/show")
    public String showSingleIngredient(@PathVariable String id, @PathVariable String idIngredient, Model model) {
        Long recipeId = Long.parseLong(id);
        Long ingredientId = Long.parseLong(idIngredient);

        Ingredient ingredient = ingredientService.findIngredientById(ingredientId);

        model.addAttribute("recipeId", recipeId);
        model.addAttribute("ingredient", ingredient);

        return "recipe/ingredients/show";
    }
}
