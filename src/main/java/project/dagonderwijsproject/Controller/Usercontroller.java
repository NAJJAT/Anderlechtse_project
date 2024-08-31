package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.dagonderwijsproject.Modle.User;
import project.dagonderwijsproject.Service.UserService;

@Controller
public class Usercontroller {

        @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUser() {
        userService.getAllUser();
        return "user";
    }
}
