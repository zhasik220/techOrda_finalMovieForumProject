package com.example.finalProject.repository;

import com.example.finalProject.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    public List<Producer> findAllByOrderByNameAsc();

    @Query("SELECT p FROM Producer p WHERE p.name LIKE %:keyword% OR p.surname LIKE %:keyword%")
    public List<Producer> findProducerByNameOrSurname(@Param("keyword") String keyword);
}
