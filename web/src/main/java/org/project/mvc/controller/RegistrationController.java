package org.project.mvc.controller;

import org.project.entity.Role;
import org.project.entity.Users;

import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import javax.validation.Valid;


@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    RegistrationController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model) {
        model.addAttribute("users", new Users());
        model.addAttribute("roles",Role.values());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser( @ModelAttribute("users") Users users , Errors errors, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("username", users.getUsername());
            model.addAttribute("password", users.getPassword());
            model.addAttribute("roles", users.getRole());
            return "registration";
        }
        userService.registerSave(users);
        return "redirect:/home";
    }
}
