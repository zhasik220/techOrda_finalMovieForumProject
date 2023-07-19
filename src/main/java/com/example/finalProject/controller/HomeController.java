package com.example.finalProject.controller;

import com.example.finalProject.model.User;
import com.example.finalProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String signInPage() {
        return "signIn";
    }

    @GetMapping(value = "/sign-up-page")
    public String signUpPage() {
        return "signUp";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDennied() {
        return "403";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/update-password")
    public String editPassword() {
        return "update_password_page";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/update-password")
    public String editPassword(
            @RequestParam(name = "user_old_password") String oldPassword,
            @RequestParam(name = "user_new_password") String newPassword,
            @RequestParam(name = "user_repeat_new_password") String repeatNewPassword
    ) {
        if (newPassword.equals(repeatNewPassword)) {
            User user = userService.updatePassword(newPassword, oldPassword);
            if (user != null) {
                return "redirect:/update-password?success";
            } else {
                return "redirect:/update-password?oldpassworderror";
            }
        } else {
            return "redirect:/update-password?passwordmismatch";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/update-fullName-email")
    public String updateFullNameEmail(
            @RequestParam(name = "updateFullName") String fullName,
            @RequestParam(name = "updateEmail") String email) {
        User user = userService.updateFullNameAndEmail(fullName, email);
        if (user != null) {
            return "redirect:/profile?success";
        } else {
            return "redirect:/profile?EmailAlreadyExist";
        }

    }
}
