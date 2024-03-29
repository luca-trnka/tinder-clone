package com.gfa.tinderclone.controllers;

import com.gfa.tinderclone.models.Swipe;
import com.gfa.tinderclone.models.User;
import com.gfa.tinderclone.services.DirectionService;
import com.gfa.tinderclone.services.SwipeService;
import com.gfa.tinderclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private final UserService userService;
    private final SwipeService swipeService;
    private final DirectionService directionService;

    @Autowired
    public MainController(UserService userService, SwipeService swipeService, DirectionService directionService) {
        this.userService = userService;
        this.swipeService = swipeService;
        this.directionService = directionService;
    }

    @GetMapping ("/")
    public String getRegisterPage(Model model) {
        model.addAttribute("currentUser", userService.getEmptyUser());
        model.addAttribute("users", userService.getAllUsers());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes attributes, Model model) {
//        if (!(userService.isExisting(user.getEmail()))) {
//            attributes.addAttribute("error", "Error happened:(");
//            return "redirect:/";
//        }
//        userService.registerUser(user);
//        attributes.addFlashAttribute("current", user);
//        return "redirect:/profile?id=" + user.getId();

        //checking the user input and if the email exist in database
        if (user.getName().isEmpty() || user.getEmail().isEmpty() ||
                user.getGender().isEmpty() || user.getBirth_date() == null || user.getBio().isEmpty() ) {
            model.addAttribute("error", "Error happened :(");
            model.addAttribute("users", userService.getAllUsers());
            return "redirect:/";
        }
        if (userService.isExisting(user.getEmail())) {
            model.addAttribute("error", "Error happened :(");
            model.addAttribute("users", userService.getAllUsers());
            return "register";
        }
        // Save the new user to the database
        userService.registerUser(user);

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String showProfil(Model model, @RequestParam(name = "userid") Long id) {
        model.addAttribute("current", userService.getUserById(id));
        model.addAttribute("other", userService.randomUser());
        model.addAttribute("directionList", directionService.getAllDirection());
        return "profile";
    }

    @PostMapping("/swipe")
    public String swipe(@ModelAttribute Swipe swipe, Model model) {
        swipeService.saveSwipe(swipe);
        return "redirect:/profile" + swipe.getCurrentId();
    }
}
