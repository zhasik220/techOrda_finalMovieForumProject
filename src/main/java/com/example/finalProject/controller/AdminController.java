package com.example.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/user_tool")
    public String adminPage() {
        return "userList";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/user_details/{id}")
    public String adminUserToolPage() {
        return "userDetails";
    }


}
