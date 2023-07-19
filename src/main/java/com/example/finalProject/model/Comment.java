package com.example.finalProject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "t_comment")
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @Column(name = "edited")
    private boolean isEdited;


}