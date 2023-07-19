package com.example.finalProject.controller;

import com.example.finalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/delete_user")
    public String deleteUser() {
        userService.deleteUser();
        return "redirect:/profile?continueToDelete";
    }


}
