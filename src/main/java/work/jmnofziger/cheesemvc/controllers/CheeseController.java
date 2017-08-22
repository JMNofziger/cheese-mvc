package work.jmnofziger.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String,String> cheeses = new HashMap<>();

    // Request path:/cheese
    @RequestMapping(value="",method=RequestMethod.GET)
    public String index(Model model){
        String title = "My Cheeses";
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title",title);
        return "cheese/index";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String processRemoveCheeseForm(HttpServletRequest request){
        //Process request to get all items from removal form
        List<String> parameterNames = new ArrayList<>(request.getParameterMap().keySet());

        //Remove items from cheese list
        for(String cheese : parameterNames){
            cheeses.remove(cheese);
        }
        return "redirect:";
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
