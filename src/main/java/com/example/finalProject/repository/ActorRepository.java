package com.example.finalProject.repository;

import com.example.finalProject.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    public List<Actor> findAllByOrderByNameAsc();

    @Query("SELECT a FROM Actor a WHERE a.name LIKE %:keyword% OR a.surname LIKE %:keyword%")
    public List<Actor> findActorsByNameOrSurname(@Param("keyword") String keyword);
}
