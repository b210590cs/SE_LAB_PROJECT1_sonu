package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.PaperDecision;

public interface PaperDecisionRepository extends JpaRepository<PaperDecision, Long> {
    // Add custom query methods if needed
}