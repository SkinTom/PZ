package pz.grupa5a.athena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pz.grupa5a.athena.exception.UserNotFoundException;
import pz.grupa5a.athena.model.User;
import pz.grupa5a.athena.repository.UserRepository;
import pz.grupa5a.athena.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/account")
    public String account(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "account";
    }

    @PostMapping("/account/{id}")
    public String updateAccount(@ModelAttribute User user, RedirectAttributes redirectAttr, Principal principal) throws UserNotFoundException {
        User userToEdit = userRepository.findByEmail(principal.getName());
        userToEdit.setFirstName(user.getFirstName());
        userToEdit.setLastName(user.getLastName());
        userToEdit.setCity(user.getCity());
        userToEdit.setEmail(user.getEmail());
        userRepository.save(userToEdit);
        redirectAttr.addFlashAttribute("message", "Zaktualizowano dane!");
        return "redirect:/account";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user,
                          BindingResult bindResult, RedirectAttributes redirectAttributes) {
        if(bindResult.hasErrors()){
            redirectAttributes.addFlashAttribute("message", "Niepowodzenie!");
            return "redirect:/register";
        }
        else {
            userService.addWithDefaultRole(user);
            redirectAttributes.addFlashAttribute("message", "Utworzono konto! Możesz się zalogować.");
            return "redirect:/login";
        }
    }
}
