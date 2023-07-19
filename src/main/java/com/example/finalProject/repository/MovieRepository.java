package com.example.finalProject.repository;

import com.example.finalProject.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByActorsId(Long actorId);

    List<Movie> findAllByProducerId(Long producerId);

    @Query("SELECT m FROM Movie m WHERE m.movieName LIKE %:keyword%")
    public List<Movie> findMovieByNameSearch(@Param("keyword") String keyword);
}
