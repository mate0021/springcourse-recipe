package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rnd.mate00.springboot.recipe.service.RecipeService;

/**
 * Created by mate00 on 11.09.17.
 */
@Controller
public class IndexController {
	
	private RecipeService recipeService;

	@Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        return "index";
    }
    
    /**
     * Lists all available recipes.
     * @param model
     * @return
     */
    @RequestMapping("/allRecipes")
    public String getAllRecipes(Model model) {
    	model.addAttribute("recipes", recipeService.getAllRecipes());
    	
    	return "allRecipes";
    }
}
