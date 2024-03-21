package com.example.demo.repository;

import com.example.demo.model.AssignedReviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedReviewerRepository extends JpaRepository<AssignedReviewer, Long> {

}
