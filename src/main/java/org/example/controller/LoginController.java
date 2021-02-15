package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;


@Controller
@RequestMapping("/")
public class LoginController {


    UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        System.out.println("1user2 : "+ userService.loadUserByUsername("ADMIN").getAuthorities().toString());
        return "login";
    }
    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userInfo(Principal principal, ModelMap model) {
        User user = userService.getByName(principal.getName());
        model.addAttribute("user",user);
        return "user";
    }
}
