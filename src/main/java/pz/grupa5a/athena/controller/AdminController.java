package pz.grupa5a.athena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/finances")
    public String finances() {
        return "finances";
    }

    @GetMapping("/employees")
    public String employees() {
        return "employees";
    }

    @GetMapping("/items")
    public String items() {
        return "items";
    }
}
