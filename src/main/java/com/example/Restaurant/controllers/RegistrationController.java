package com.example.Restaurant.controllers;

import com.example.Restaurant.domain.User;
import com.example.Restaurant.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String Registration(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping
    public String regUser(@ModelAttribute("user") User user, Model model){
        userRepo.save(user);
        return "index.html";
    }


}
