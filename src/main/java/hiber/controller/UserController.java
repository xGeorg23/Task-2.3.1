package hiber.controller;

import hiber.config.AppConfig;
import hiber.config.WebConfig;
import hiber.model.User;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String allUser(ModelMap model) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        UserServiceImp userService = context.getBean(UserServiceImp.class);

        userService.add(new User("","User1","Lastname1"));
        userService.add(new User("","User2","Lastname2"));
        userService.add(new User("","User3","Lastname3"));
        userService.add(new User("","User4","Lastname4"));

        model.addAttribute("index", userService.listUsers());

        return "index";
    }

    @GetMapping(value = "/user")
    public String addUser(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("index", messages);
        return "user";
    }
}
