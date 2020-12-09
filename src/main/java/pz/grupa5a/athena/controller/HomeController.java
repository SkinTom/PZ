package pz.grupa5a.athena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pz.grupa5a.athena.model.Item;
import pz.grupa5a.athena.model.User;
import pz.grupa5a.athena.repository.ItemRepository;

import java.util.List;

@Controller
public class HomeController {

    private ItemRepository itemRepository;

    @Autowired
    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "catalog";
    }

    @GetMapping("/")
    public String home() {
            return "redirect:/catalog";
    }
}
