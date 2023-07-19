package com.example.finalProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "t_movie")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "year")
    private int year;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Country country;

    @Column(name = "duration_in_minutes")
    private int duration;

    @ManyToMany
    private List<Actor> actors;

    @ManyToOne
    private Producer producer;

    @ManyToMany
    private List<Genre> genres;

}
