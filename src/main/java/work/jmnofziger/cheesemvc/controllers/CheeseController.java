package work.jmnofziger.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String,String> cheeses = new HashMap<>();

    // Request path:/cheese
    @RequestMapping(value="")
    public String index(Model model){
        String title = "My Cheeses";
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title",title);
        return "cheese/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    // Rewritten with RequestParam annotation to replace HttpServletRequest
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription){
        cheeses.put(cheeseName,cheeseDescription);
        return "redirect:";
    }
}
