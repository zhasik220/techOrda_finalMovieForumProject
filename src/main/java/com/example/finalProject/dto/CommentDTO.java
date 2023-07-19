package com.example.finalProject.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String commentText;
    private LocalDateTime postedTime;
    private Long userId;
    private String userFullName;
    private Long movieId;
    private boolean isEdited;
}
