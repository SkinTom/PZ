package pz.grupa5a.athena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pz.grupa5a.athena.model.Item;
import pz.grupa5a.athena.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    private static final int PAGE_SIZE = 5;

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
        return findPaginatedItem(0, model);
    }

    @GetMapping("/items/page/{page}")
    public String findPaginatedItem(@PathVariable(value = "page") int page, Model model) {
        String menuItem = "items";

        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        Page<Item> items = itemRepository.findAll(pageable);
        List<Item> itemList = items.getContent();

        model.addAttribute("item", new Item());
        model.addAttribute("menuItem", menuItem);
        model.addAttribute("items", itemList);
        model.addAttribute("currentPage", items.getNumber());
        model.addAttribute("totalItems", items.getTotalElements());
        model.addAttribute("totalPages", items.getTotalPages());
        return "items";
    }

    @PostMapping("/items/add")
    public String createItem(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {
        itemRepository.deleteById(id);
        return "redirect:/items";
    }
}
