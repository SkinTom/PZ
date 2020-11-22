package pz.grupa5a.athena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pz.grupa5a.athena.model.Item;
import pz.grupa5a.athena.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    private ItemRepository itemRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

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
        List<Item> items = itemRepository.findAll();

        model.addAttribute("item", new Item());
        model.addAttribute("menuItem", menuItem);
        model.addAttribute("items", items);
        return "items";
    }

    @PostMapping("/items/add")
    public String createItem(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/update/{id}")
    public String updateItem(@PathVariable(value = "id") long id, Model model) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        Item item = null;
        if(optionalItem.isPresent()) {
            item = optionalItem.get();
        }

        model.addAttribute("itemToEdit", item);
        return "";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {
        itemRepository.deleteById(id);
        return "redirect:/items";
    }
}
