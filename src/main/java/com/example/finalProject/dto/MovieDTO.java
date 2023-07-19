package com.example.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class MovieDTO {

    private Long id;

    private String movieTitle;

    private String definition;

    private int movieYear;

    private CountryDTO movieCountry;

    private int continuance;

    private List<ActorDTO> movieActors;

    private ProducerDTO movieDirector;

    private List<GenreDTO> movieGenres;
}
