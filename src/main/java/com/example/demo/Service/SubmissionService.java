package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Submissions;

public interface SubmissionService {
    List<Submissions> getAcceptedPapers();
    List<Submissions> getRejectedPapers();
    List<Submissions> getAllPapers();
    
    
}
