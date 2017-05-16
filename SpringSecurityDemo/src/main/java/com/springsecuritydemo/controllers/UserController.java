package com.springsecuritydemo.controllers;

import com.springsecuritydemo.models.RegisterModel;
import com.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegisterModel registerModel){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegisterModel registerModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "register";
        }

        userService.register(registerModel);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", "Invalid Credentials");
        }

        return "login";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
