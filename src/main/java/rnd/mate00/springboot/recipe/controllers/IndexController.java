package rnd.mate00.springboot.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.SortedMap;

/**
 * Created by mate00 on 11.09.17.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        return "index";
    }
}
