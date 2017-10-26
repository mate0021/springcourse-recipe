package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rnd.mate00.springboot.recipe.commands.IngredientCommand;
import rnd.mate00.springboot.recipe.commands.UnitOfMeasureCommand;
import rnd.mate00.springboot.recipe.model.Ingredient;
import rnd.mate00.springboot.recipe.service.IngredientService;
import rnd.mate00.springboot.recipe.service.RecipeService;
import rnd.mate00.springboot.recipe.service.UnitOfMeasureService;

import java.util.List;
import java.util.Set;

/**
 * Created by mate00 on 04.10.17.
 */
@Controller
public class IngredientController {

    private RecipeService recipeService;

    private IngredientService ingredientService;

    private UnitOfMeasureService unitOfMeasureService;

    @Autowired
    public IngredientController(
            RecipeService recipeService,
            IngredientService ingredientService,
            UnitOfMeasureService unitOfMeasureService) {

        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String getIngredientList(@PathVariable String id, Model model) {
        Long idLong = Long.parseLong(id);
        Set<Ingredient> ingredients = recipeService.findById(idLong).getIngredients();
        model.addAttribute("recipe", recipeService.findById(idLong));
        model.addAttribute("ingredients", ingredients);
        return "recipe/ingredients/list";
    }

    @RequestMapping("/recipe/{id}/ingredient/{idIngredient}/show")
    public String showSingleIngredient(@PathVariable String id, @PathVariable String idIngredient, Model model) {
        Long recipeId = Long.parseLong(id);
        Long ingredientId = Long.parseLong(idIngredient);

        Ingredient ingredient = ingredientService.findIngredientById(ingredientId);

        model.addAttribute("recipeId", recipeId);
        model.addAttribute("ingredient", ingredient);

        return "recipe/ingredients/show";
    }

    @RequestMapping("/recipe/{id}/ingredient/{idIngredient}/update")
    public String updateIngredient(@PathVariable String id, @PathVariable String idIngredient, Model model) {
        Long recipeId = Long.parseLong(id);
        Long ingredientId = Long.parseLong(idIngredient);

        IngredientCommand ingredientCommand = ingredientService.findCommandById(ingredientId);
        ingredientCommand.setRecipeId(recipeId);
        model.addAttribute("ingredient", ingredientCommand);
        System.out.println("command before posting: " + ingredientCommand);

        List<UnitOfMeasureCommand> unitOfMeasures = unitOfMeasureService.getAllUnitsOfMeasureCommand();
        model.addAttribute("uomList", unitOfMeasures);

        return "recipe/ingredients/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{id}/ingredientForm")
    public String updateIngredient(@ModelAttribute IngredientCommand ingredientCommand, @PathVariable String id) {
        Long recipeId = Long.parseLong(id);
        ingredientCommand.setRecipeId(recipeId);
        ingredientService.saveIngredientCommand(ingredientCommand);

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
