package rnd.mate00.springboot.recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rnd.mate00.springboot.recipe.model.Category;
import rnd.mate00.springboot.recipe.model.UnitOfMeasure;
import rnd.mate00.springboot.recipe.repositories.CategoryRepository;
import rnd.mate00.springboot.recipe.repositories.UnitsOfMeasureRepository;

import java.util.List;

/**
 * Created by mate00 on 14.09.17.
 */
@Controller
public class CategoryFinderController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitsOfMeasureRepository unitsOfMeasureRepository;

    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public String findByCategoryName(Model model) {
        Category result = categoryRepository.findByDescription("American").orElse(new Category());
        model.addAttribute("foundCategory", result.getDescription());

        List<UnitOfMeasure> units = unitsOfMeasureRepository.findAll();
        model.addAttribute("allUnitsOfMeasure", units);

        return "categoryFinder";
    }
}
