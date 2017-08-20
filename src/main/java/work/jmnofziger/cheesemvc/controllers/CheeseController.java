package work.jmnofziger.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // Request path:/cheese
    @RequestMapping(value="")
    public String index(Model model){
        String title = "My Cheeses";

        ArrayList<String> cheeses = new ArrayList<>();
        cheeses.add("cheddar");
        cheeses.add("parmesan");
        cheeses.add("munster");

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title",title);
        return "cheese/index";
    }

    @RequestMapping(value="add")
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add")
    public String processAddCheeseForm(){

    }
}
