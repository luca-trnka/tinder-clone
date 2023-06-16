package com.gfa.tinderclone.controllers;

import com.gfa.tinderclone.models.Swipe;
import com.gfa.tinderclone.models.SwipeRequest;
import com.gfa.tinderclone.models.User;
import com.gfa.tinderclone.services.SwipeService;
import com.gfa.tinderclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {


    private final UserService userService;
    private final SwipeService swipeService;

    @Autowired
    public MainRestController(UserService userService, SwipeService swipeService) {
        this.userService = userService;
        this.swipeService = swipeService;
    }

    @PostMapping("/api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Check for missing data
        if (user.getName() == null || user.getEmail() == null ||
                user.getBirth_date() == null || user.getGender() == null ||
                user.getBio() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //checking if the email exist
        if (userService.isExisting(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        //checking if the gender is valid
        if (!user.getGender().equals("female") && !user.getGender().equals("male")) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        //saving new user
        userService.registerUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/api/users/{currentUserId}/swipe")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Swipe> swipeUser(
            @PathVariable("currentUserId") Long currentUserId,
            @RequestBody SwipeRequest swipeRequest) {

        //checking if everything filled
        if (swipeRequest.getOtherUserId() == null || swipeRequest.getDirection() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        //checking if its left or right, nothing else
        if (!swipeRequest.getDirection().equals("left") && !swipeRequest.getDirection().equals("right")) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        //checking if previous swipe exist for the same currentUserId and otherUserId
        if (userService.isSwipeExisting(currentUserId, swipeRequest.getOtherUserId())) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        //setting of a new swipe
        Swipe newSwipe = new Swipe();
        newSwipe.setCurrent_user_id(currentUserId);
        newSwipe.setOther_user_id(swipeRequest.getOtherUserId());
        newSwipe.setDirection(swipeRequest.getDirection());

        Swipe createdSwipe = swipeService.createSwipe(newSwipe);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdSwipe);
    }

    @PatchMapping("/api/users/{currentUserId}/swipe")
    public ResponseEntity<Swipe> updateSwipe(
            @PathVariable("currentUserId") Long currentUserId,
            @RequestBody SwipeRequest swipeRequest) {

        if (swipeRequest.getOtherUserId() == null || swipeRequest.getDirection() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (!swipeRequest.getDirection().equals("left") && !swipeRequest.getDirection().equals("right")) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Swipe existingSwipe = swipeService.getSwipeByUserIds(currentUserId, swipeRequest.getOtherUserId());
        if (existingSwipe == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        existingSwipe.setDirection(swipeRequest.getDirection());
        Swipe updatedSwipe = swipeService.updateSwipe(existingSwipe);

        return ResponseEntity.status(HttpStatus.OK).body(updatedSwipe);
    }


}
