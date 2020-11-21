package pz.grupa5a.athena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/finances")
    public String finances(Model model) {
        String menuItem = "finances";
        model.addAttribute("menuItem", menuItem);
        return "finances";
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        String menuItem = "employees";
        model.addAttribute("menuItem", menuItem);
        return "employees";
    }

    @GetMapping("/items")
    public String items(Model model) {
        String menuItem = "items";
        model.addAttribute("menuItem", menuItem);
        return "items";
    }
}
