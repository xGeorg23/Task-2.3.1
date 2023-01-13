package hiber.controller;

import hiber.config.AppConfig;
import hiber.config.WebConfig;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String allUser(ModelMap model) {
        model.addAttribute("allUsers", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/createUser")
    public String addUser(ModelMap model) {
        User person = new User();
        model.addAttribute("person", person);
        return "user";
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
