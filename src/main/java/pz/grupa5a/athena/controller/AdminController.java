package pz.grupa5a.athena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pz.grupa5a.athena.exception.UserNotFoundException;
import pz.grupa5a.athena.model.Item;
import pz.grupa5a.athena.model.User;
import pz.grupa5a.athena.model.UserRole;
import pz.grupa5a.athena.repository.ItemRepository;
import pz.grupa5a.athena.repository.UserRepository;
import pz.grupa5a.athena.repository.UserRoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private static final int PAGE_SIZE = 5;

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/admin")
    public String adminPanel() {
        return "redirect:/admin/items";
    }

    @GetMapping("/admin/finances")
    public String finances(Model model) {
        List<User> employees = userRepository.findByRoleName("ROLE_EMPLOYEE");
        String menuItem = "finances";

        model.addAttribute("employees", employees);
        model.addAttribute("menuItem", menuItem);
        return "finances";
    }

    @PostMapping("/admin/finances/{id}")
    public String salary(@PathVariable(value = "id") long id, @RequestParam(name = "salary") double salary, RedirectAttributes redirectAttr) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for this id: " + id));
        user.setSalary(salary);
        userRepository.save(user);
        redirectAttr.addFlashAttribute("message", "Wartość wynagrodzenia zaktualizowana z powodzeniem.");
        return "redirect:/admin/finances";
    }

    @GetMapping("/admin/employees")
    public String employees(Model model) {
        String menuItem = "employees";
        List<User> employees = userRepository.findByRoleName("ROLE_EMPLOYEE");
        UserRole userRole = userRoleRepository.findByRole("ROLE_USER");
        UserRole employeeRole = userRoleRepository.findByRole("ROLE_EMPLOYEE");
        UserRole adminRole = userRoleRepository.findByRole("ROLE_ADMIN");

        model.addAttribute("menuItem", menuItem);
        model.addAttribute("employees", employees);
        model.addAttribute("userRole", userRole);
        model.addAttribute("employeeRole", employeeRole);
        model.addAttribute("adminRole", adminRole);
        return "employees";
    }

    @PostMapping("/admin/employees/manage-roles/{id}")
    public String manageRoles(@PathVariable(value = "id") long id, @RequestParam(name = "roles") List<String> roleNames, RedirectAttributes redirectAttr) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
        Set<UserRole> roles = new HashSet<>();

        for(String roleName: roleNames) {
            UserRole role = userRoleRepository.findByRole(roleName);
            roles.add(role);
        }
        user.setRoles(roles);
        userRepository.save(user);
        redirectAttr.addFlashAttribute("message", "Role zaktualizowano z powodzeniem.");
        return "redirect:/admin/employees";
    }

    @GetMapping("/admin/items")
    public String items(Model model) {
        return findPaginatedItem(0, model);
    }

    @GetMapping("/admin/items/page/{page}")
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

    @PostMapping("/admin/items/add")
    public String createItem(@ModelAttribute Item item, RedirectAttributes redirectAttr) {
        itemRepository.save(item);
        redirectAttr.addFlashAttribute("message", "Operacja zakończona powodzeniem.");
        return "redirect:/admin/items";
    }

    @GetMapping("/admin/items/delete/{id}")
    public String deleteItem(@PathVariable(value = "id") long id, RedirectAttributes redirectAttr) {
        itemRepository.deleteById(id);
        redirectAttr.addFlashAttribute("message", "Pozycja usunięta!");
        return "redirect:/admin/items";
    }
}
