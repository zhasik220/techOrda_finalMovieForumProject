package com.example.finalProject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorController {
    @GetMapping(value = "/actor_details/{id}")
    public String actorDetailsPage() {
        return "actorDetails";
    }

    @GetMapping(value = "/actors")
    public String actorsListPage() {
        return "actorsList";
    }


}

