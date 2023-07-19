package com.example.finalProject.repository;

import com.example.finalProject.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    public List<Country> findAllByOrderByNameAsc();

    @Query("SELECT c FROM Country c WHERE c.name LIKE %:keyword%")
    public List<Country> findCountryByNameSearch(@Param("keyword") String keyword);
}
