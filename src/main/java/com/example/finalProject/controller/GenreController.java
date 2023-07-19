package com.example.finalProject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenreController {
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')")
    @GetMapping(value = "/genre_tool")
    public String actorDetailsPage() {
        return "genreToolPage";
    }
}

