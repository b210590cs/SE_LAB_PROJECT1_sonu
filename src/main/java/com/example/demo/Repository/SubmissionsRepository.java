package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Submissions;

@Repository
public interface SubmissionsRepository extends JpaRepository<Submissions, Long> {
    // You can add custom query methods if needed
     // Add custom query methods if needed
	 List<Submissions> findByStatus(String status);
	 Submissions findByTitleAndAuthor1(String title, String author);

}
