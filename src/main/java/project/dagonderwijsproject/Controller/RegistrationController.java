package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.dagonderwijsproject.Modle.User;
import project.dagonderwijsproject.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder; // Autowire PasswordEncoder


    @GetMapping("/register")
    public String showRegistrationForm(ModelMap model) {
        model.addAttribute("user", User.builder().build());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        // Check if username already exists
        if (userService.existsByUsername(user.getUsername())) {
            result.rejectValue("username", "error.user", "Username already exists");
        }
        // If there are validation errors or username already exists, return to registration page
        if (result.hasErrors()) {
            return "registration";
        }
        // Hash the password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        // Save the user
        userService.saveUser(user);
        return "redirect:/login";
    }
    //login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
