package com.example.finalProject.service;

import com.example.finalProject.dto.CommentDTO;
import com.example.finalProject.mapper.CommentMapper;
import com.example.finalProject.model.Comment;
import com.example.finalProject.model.User;
import com.example.finalProject.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;

    public List<CommentDTO> getCommentList(Long movieId) {
        return commentMapper.toDtoList(commentRepository.findByMovieIdOrderByTimeAsc(movieId));
    }

    public CommentDTO addComment(CommentDTO comment) {
        return commentMapper.toDTO(commentRepository.save(commentMapper.toModel(comment)));
    }

    public CommentDTO getOneComment(Long id) {
        return commentMapper.toDTO(commentRepository.findById(id).orElse(new Comment()));
    }

    public CommentDTO updateComment(CommentDTO commentDTO) {
        User user=userService.getCurrentSessionUser();
        if (user.getId()==commentDTO.getUserId()){
            return commentMapper.toDTO(commentRepository.save(commentMapper.toModel(commentDTO)));
        }
        return null;
    }

    public void deleteComment(Long id) {
        User user=userService.getCurrentSessionUser();
        Comment comment=commentRepository.findById(id).orElse(new Comment());
        boolean hasAdminOrModeratorRole = user.getPermissions().stream()
                .anyMatch(permission ->
                        permission.getRole().equals("ROLE_ADMIN") || permission.getRole().equals("ROLE_MODERATOR")
                );
        if ((user.getId()==comment.getUser().getId()) || hasAdminOrModeratorRole ){
            commentRepository.deleteById(id);
        }
    }

    @Transactional
    public void deleteAllCommentMovie(Long id){
        commentRepository.deleteByMovieId(id);
    }
}
