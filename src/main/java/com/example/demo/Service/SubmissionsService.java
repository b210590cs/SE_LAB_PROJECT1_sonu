package com.example.demo.Service;

import com.example.demo.Repository.SubmissionsRepository;
import com.example.demo.model.Submissions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubmissionsService {

    @Autowired
    private SubmissionsRepository submissionsRepository;

    public void assignReviewer(Long submissionId) {
        Submissions submission = submissionsRepository.findById(submissionId).orElse(null);
        if (submission != null) {
            submission.setStatus("ASSIGNED");
            submissionsRepository.save(submission);
            //System.out.println("submission service success");
        } else {
            // Handle submission not found error
             ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paper not found ");
        }
       // System.out.println("submission service success");
    }
    public List<Submissions> getPapersBystatus(String status){
        return submissionsRepository.findByStatus(status);
    }
//     public List<Submissions> getPapersByStatus(String status) {
//         return SubmissionsRepository.findByStatus(status);
//     }
}
