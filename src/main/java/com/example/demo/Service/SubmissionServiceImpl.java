package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Submissions;
import com.example.demo.repository.SubmissionsRepository;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionsRepository submissionsRepository;

    @Override
    public List<Submissions> getAcceptedPapers() {
        return submissionsRepository.findByStatus("accept");
    }
    @Override
    public List<Submissions> getRejectedPapers() {
        return submissionsRepository.findByStatus("reject");
    }
    @Override
    public List<Submissions> getAllPapers() {
        return submissionsRepository.findAll();
    }
}
