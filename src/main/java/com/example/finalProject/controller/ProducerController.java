package com.example.finalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProducerController {
    @GetMapping(value = "/producer_details/{id}")
    public String actorDetailsPage() {
        return "producerDetails";
    }

    @GetMapping(value = "/producers")
    public String actorsListPage() {
        return "producersList";
    }


}

