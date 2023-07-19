package com.example.finalProject.api;

import com.example.finalProject.dto.CommentDTO;
import com.example.finalProject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/comment")
public class CommentRestController {
    private final CommentService commentService;

    @GetMapping(value = "{id}")
    public CommentDTO getOneComment(@PathVariable(name = "id") Long id) {
        return commentService.getOneComment(id);
    }

    @GetMapping(value = "/get-comment-list")
    public List<CommentDTO> getCommentList(@RequestParam Long movie_id) {
        return commentService.getCommentList(movie_id);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/add-comment")
    public CommentDTO addComment(@RequestBody CommentDTO comment) {
        comment.setPostedTime(LocalDateTime.now());
        return commentService.addComment(comment);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping
    public CommentDTO updateComment(@RequestBody CommentDTO comment) {
        return commentService.updateComment(comment);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping(value = "{id}")
    public void deleteComment(@PathVariable(name = "id") Long id) {
        commentService.deleteComment(id);
    }
}
