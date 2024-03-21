package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Paper;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {
    Paper findByTitle(String title);
}
