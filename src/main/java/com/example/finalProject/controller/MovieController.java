package com.example.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MovieController {
    @GetMapping(value = "/movie_details/{id}")
    public String movieDetailsPage() {
        return "movieDetails";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/add_movie")
    public String AddMoviePage() {
        return "addMovie";
    }
}

