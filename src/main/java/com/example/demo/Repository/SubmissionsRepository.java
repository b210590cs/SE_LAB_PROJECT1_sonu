package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Submissions;

@Repository
public interface SubmissionsRepository extends JpaRepository<Submissions, Long> {
	Optional<Submissions> findByTitle(String title);
	List<Submissions> findByStatus(String status);
    // You can add custom query methods if needed
}
