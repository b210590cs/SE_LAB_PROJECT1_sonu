package com.example.demo.Controller;

import com.example.demo.Repository.ReviewerRepository;
import com.example.demo.Repository.SubmissionsRepository;
import com.example.demo.Service.SubmissionsService;
import com.example.demo.model.Reviewer;
import com.example.demo.model.Submissions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AssignReviewersController {

    @Autowired
    private SubmissionsService submissionsService;
    @Autowired
    private ReviewerRepository reviewerRepository;
    @Autowired
    private SubmissionsRepository submissionsRepository;
    @GetMapping("/assignreviewers")
public String getAllPapers(Model model) {
    // Retrieve all unreviewed papers from the database
    System.out.println("hello"); // Fixed typo "hello" instead of "hell0"
    List<Submissions> papers = submissionsService.getPapersBystatus("UR"); // Changed variable name "Papers" to "papers" for camel case convention

    // Retrieve all reviewers
    List<Reviewer> reviewers = reviewerRepository.findAll();

    // Add the list of unreviewed papers to the model
    model.addAttribute("unreviewedPapers", papers); // Changed variable name "Papers" to "papers"

    // Add the list of reviewers to the model
    model.addAttribute("reviewersList", reviewers);

    // Return the view name for the unreviewed papers page
    return "assignreviewers";
}


    // @PutMapping("/assignreviewers")
    // @ResponseBody
    // public String assignReviewer(@PathVariable Long submissionId) {
    //     // Perform other actions if needed
    //     submissionsService.assignReviewer(submissionId);
    //     //System.out.println("assign reviewers success");
    //     return "redirect:/assignreviewers"; // Redirect to the same page after assigning reviewer
    // }
    @PutMapping("/assignreviewers/{id}")
    @CrossOrigin // Add CrossOrigin annotation to allow requests from different origins
    @ResponseBody
    public ResponseEntity<String> markPaperAsReviewed(@PathVariable("id") Long id) {
        // Find the paper by its ID
        Submissions paper = submissionsRepository.findById(id).orElse(null);

        if (paper == null) {
            // If paper not found, return 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paper not found with ID: " + id);
        }
        // Update the status of the paper to "reviewed"
        paper.setStatus("reviewed");
        submissionsRepository.save(paper);

        // Return a success message
        return ResponseEntity.ok("Paper with ID " + id + " marked as reviewed.");
    }
}
