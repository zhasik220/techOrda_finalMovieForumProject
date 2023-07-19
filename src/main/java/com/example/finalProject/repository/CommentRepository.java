package com.example.finalProject.repository;

import com.example.finalProject.model.Comment;
import com.example.finalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByMovieIdOrderByTimeAsc(Long movieId);

    public  List<Comment> findByUser(User user);

    public void deleteByMovieId(Long movieId);


}
