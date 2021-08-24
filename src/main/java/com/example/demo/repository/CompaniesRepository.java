package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompaniesRepository extends JpaRepository <Company, Integer> {
    Optional <Company> findByName(String name);
}
