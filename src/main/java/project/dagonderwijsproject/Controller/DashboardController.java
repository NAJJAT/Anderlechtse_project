package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.dagonderwijsproject.Modle.User;
import project.dagonderwijsproject.Service.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getDashboard(Authentication authentication, Model model) {
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            List<User> users = userService.getAllUser();
            model.addAttribute("users", users);
            return "admin";
        } else if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "user";
        } else {
            return "error"; // fallback for unexpected roles
        }
    }
}

