package com.example.finalProject.repository;
import com.example.finalProject.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    public List<Genre> findAllByOrderByNameAsc();

    @Query("SELECT g FROM Genre g WHERE g.name LIKE %:keyword%")
    public List<Genre> findGenreByNameSearch(@Param("keyword") String keyword);
}

