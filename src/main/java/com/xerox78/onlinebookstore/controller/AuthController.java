package com.xerox78.onlinebookstore.controller;

import com.xerox78.onlinebookstore.dto.RegistrationDto;
import com.xerox78.onlinebookstore.models.UserEntity;
import com.xerox78.onlinebookstore.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model)
    {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result, Model model)
    {
        UserEntity existingUser = userService.findByEmail(user.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty())
        {
            return "redirect:/register?fail";
        }

        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());

        if (existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty())
        {
            return "redirect:/register?fail";
        }

        if (result.hasErrors())
        {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/books?success";
    }

}
