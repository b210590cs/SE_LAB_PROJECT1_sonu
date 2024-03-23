package com.example.demo.Service;

import com.example.demo.model.Paper;
import com.example.demo.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    public Paper getPaperById(Long id) {
        return paperRepository.findById(id).orElse(null);
    }

    public Paper getPaperByTitle(String title) {
        return paperRepository.findByTitle(title);
    }

    public Paper createPaper(Paper paper) {
        return paperRepository.save(paper);
    }

    public Paper updatePaper(Long id, Paper paper) {
        Paper existingPaper = paperRepository.findById(id).orElse(null);
        if (existingPaper != null) {
            existingPaper.setTitle(paper.getTitle());
            existingPaper.setAuthor1(paper.getAuthor1());
            existingPaper.setAuthor2(paper.getAuthor2());
            existingPaper.setAbstractText(paper.getAbstractText());
            existingPaper.setDecision(paper.getDecision());
            return paperRepository.save(existingPaper);
        }
        return null;
    }

    public void deletePaper(Long id) {
        paperRepository.deleteById(id);
    }
}