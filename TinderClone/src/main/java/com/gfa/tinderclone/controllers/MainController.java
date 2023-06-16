package com.gfa.tinderclone.controllers;

import com.gfa.tinderclone.models.User;
import com.gfa.tinderclone.services.SwipeService;
import com.gfa.tinderclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private final UserService userService;
    private final SwipeService swipeService;

    @Autowired
    public MainController(UserService userService, SwipeService swipeService) {
        this.userService = userService;
        this.swipeService = swipeService;
    }

    @GetMapping ("/")
    public String getRegisterPage(Model model) {
        model.addAttribute("currentUser", userService.getEmptyUser());
        model.addAttribute("users", userService.getAllUsers());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes attributes) {
        if (userService.getUserByEmail(user.getEmail())) {
            attributes.addFlashAttribute("existingUser", true);
            return "redirect:/";
        }
        userService.registerUser(user);
        attributes.addFlashAttribute("current", user);
        return "redirect:/profile?id=" + user.getId();
    }
}
