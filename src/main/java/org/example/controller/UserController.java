package org.example.controller;

import org.example.domain.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        //System.out.println("1user : "+ userService.loadUserByUsername("admin").toString());
        System.out.println("1user2 : "+ userService.loadUserByUsername("ADMIN").getAuthorities().toString());
        return "login";
    }

    //---------------------------------------------------------------------------------------------------------------------
    /*@RequestMapping("/")
    public String getIndex(ModelMap model){
        List<User> users = userService.listUsers();
        logger.info("Number of users : "+users.toString());
        model.addAttribute("users",users);
        return "index";
    }
    @RequestMapping("/add")
    public String addUser(){
        return "add";
    }
    @PostMapping(path = "/save",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String saveUser(User user){
        System.out.println("eteetet" +user.toString());
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam Long id, ModelMap model){
        User user = userService.userById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @PostMapping(path = "/update",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String updateUser(User user){
        System.out.println("eteetet" +user.toString());
        userService.update(user.getId(),user);
        return "redirect:/";
    }
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam Long id){
        userService.delete(id);
        return "redirect:/";
    }*/

}
