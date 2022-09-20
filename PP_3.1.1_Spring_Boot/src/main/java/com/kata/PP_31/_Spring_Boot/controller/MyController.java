package com.kata.PP_31._Spring_Boot.controller;

import com.kata.PP_31._Spring_Boot.entity.User;
import com.kata.PP_31._Spring_Boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class MyController {

    private UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allusers", allUsers);
        return "all-users";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
    userService.deleteById(id);
    return "redirect:/";
    }

    @GetMapping("/user/update/{id}")
    public String updateUserFrom(@PathVariable("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
