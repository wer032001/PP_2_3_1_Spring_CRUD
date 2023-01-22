package webhiber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import webhiber.model.User;
import webhiber.service.UserService;
import webhiber.service.UserServiceImp;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        user.setFirstName("BOB");
        userService.addUser(user);
        return "redirect:/users";
    }
}
