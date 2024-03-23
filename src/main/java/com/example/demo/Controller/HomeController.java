package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.Service.PaperService;
import com.example.demo.Service.SubmissionService;
import com.example.demo.entity.User;
import com.example.demo.model.AssignedReviewer;
import com.example.demo.model.Paper;
import com.example.demo.model.PaperDecision;
import com.example.demo.model.Reviewer;
import com.example.demo.model.Submissions;
<<<<<<< HEAD
import com.example.demo.Repository.ReviewerRepository;
import com.example.demo.Repository.SubmissionsRepository;
=======
import com.example.demo.repository.AssignedReviewerRepository;
import com.example.demo.repository.PaperDecisionRepository;
import com.example.demo.repository.PaperRepository;
import com.example.demo.repository.ReviewerRepository;
import com.example.demo.repository.SubmissionsRepository;
import com.example.demo.repository.UserRepository;
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserRepository repo;	
    

    @Autowired
    private ObjectMapper objectMapper; 
    private static final String USERS_JSON_PATH = "path/to/users.json"; 

//    @GetMapping("/")
//    public String index() {
//        return "login";
//    }

//    @PostMapping("/login")
//    public String login(@RequestParam String email, @RequestParam String password, Model model) {
//        // Read users from JSON file
//        List<User> users = getUsersFromJson();
//
//        Optional<User> matchingUser = users.stream()
//                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
//                .findFirst();
//
//        if (matchingUser.isPresent()) {
//            // Successful login
//            return "redirect:/dashboard"; 
//        } else {
//            // Invalid credentials
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }

    // Method to read users from the JSON file
//    private List<User> getUsersFromJson() {
//        try {
//            File file = new ClassPathResource(USERS_JSON_PATH).getFile();
//            return Arrays.asList(objectMapper.readValue(file, User[].class));
//        } catch (IOException e) {
//            // Handle exception (e.g., log it)
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Assumes you have a "home.html" file in the templates directory
    }

    @GetMapping("/reviewers")
    public String reviewer() {
        return "reviewers"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/accepted")
    public String accepted() {
        return "accepted"; // Assumes you have a "home.html" file in the templates directory
    }
    
    @GetMapping("/responses")
    public String responses() {
        return "responses"; // Assumes you have a "home.html" file in the templates directory
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/assignreviewers")
    public String assignreviewers() {
        return "assignreviewers"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/rejected")
    public String rejectedpapers() {
        return "rejectedpapers"; // Assumes you have a "home.html" file in the templates directory
    }
    
    @GetMapping("/decisions")
    public String decisions() {
        return "decisions"; // Assumes you have a "home.html" file in the templates directory
    }
    
    @GetMapping("/addreviewer")
    public String addreviewer() {
        return "addreviewer"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/deletereviewer")
    public String deletereviewer() {
        return "deletereviewer"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/choosedecision")
    public String choosedecision() {
        return "choosedecision"; // Assumes you have a "home.html" file in the templates directory
    }
    @GetMapping("/reviewers_success")
    public String reviewers_success () {
        return "reviewers_success"; // Assumes you have a "home.html" file in the templates directory
    }
    
//    @GetMapping("/statusupdate")
//    public String statusupdate () {
//        return "statusupdate"; // Assumes you have a "home.html" file in the templates directory
//    }
    


//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User()); // Assuming you have a User class for registration data
//        return "register";
//    }
    

//    @PostMapping("/register")
//    public String register(@ModelAttribute User user, BindingResult bindingResult) {
//        // Perform registration logic here
//        // Redirect to login page or handle registration success
//
//        // For example:
//        if (bindingResult.hasErrors()) {
//            return "register"; // Return to the registration form with error messages
//        }
//
//        // Registration logic goes here
//
//        return "redirect:/"; // Redirect to the login page after a successful registration
//    }
    @RestController
    @RequestMapping("/api/reviewers")
    public class ReviewerController {

        @Autowired
        private ReviewerRepository reviewerRepository;

        @GetMapping
        public List<Reviewer> getAllReviewers() {
            List<Reviewer> reviewers = reviewerRepository.findAll();
            System.out.println("Number of reviewers: " + reviewers.size());

            // Additional logging for debugging
            if (!reviewers.isEmpty()) {
                for (Reviewer reviewer : reviewers) {
                    System.out.println("Reviewer details: " + reviewer.toString());
                }
            } else {
                System.out.println("Reviewer list is empty.");
            }

            // Add the code for manual serialization and logging here
            ObjectMapper mapper = new ObjectMapper();  // Create an ObjectMapper instance
            String json = null;
			try {
				json = mapper.writeValueAsString(reviewers);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Serialize the list to JSON
            System.out.println("Serialized JSON: " + json);  // Print the serialized JSON to console

            return reviewers;
        }
        @PostMapping("/add")
        public String addReviewer(@RequestParam String name, @RequestParam String field,
                                   @RequestParam String contact, @RequestParam String email) {
            Reviewer reviewer = new Reviewer();
            reviewer.setName1(name);
            reviewer.setExpertise_field(field);
            reviewer.setContact(contact);
            reviewer.setEmail(email);
            reviewerRepository.save(reviewer);
            //return "reviewers_success"; 
            return "SUCCESSFULL";
        }
        
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteReviewer(@PathVariable Long id) {
            if (reviewerRepository.existsById(id)) {
                reviewerRepository.deleteById(id);
                return ResponseEntity.ok("Reviewer with ID " + id + " deleted successfully.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    
    
        
            
    }
        @RestController
        @RequestMapping("/api/submissions")
        public class SubmissionController {

            @Autowired
            private SubmissionsRepository submissionsRepository;

            @GetMapping
            public List<Submissions> getAllSubmissions() {
                return submissionsRepository.findAll();
            }
            @PostMapping("/updateDecision")
            public ResponseEntity<String> updateDecision(@RequestBody Map<String, String> decisionData) {
                String title = decisionData.get("title");
                String decision = decisionData.get("decision");

                // Fetch submission from the database by title
                Optional<Submissions> optionalSubmission = submissionsRepository.findByTitle(title);

                if (optionalSubmission.isPresent()) {
                    Submissions submission = optionalSubmission.get();
                    // Update the status based on the decision
                    submission.setStatus(decision);
                    submissionsRepository.save(submission);
                    return ResponseEntity.ok("Decision updated successfully for submission: " + title);
                } else {
                    return ResponseEntity.badRequest().body("Submission not found with title: " + title);
                }
            }
        }
<<<<<<< HEAD
    }
       
=======
        
        
        @GetMapping("/list_users")
    	public String viewUsersList(Model model)
    	{
    	
    		List<User> listUsers = repo.findAll();
    		model.addAttribute("listUsers" , listUsers);
    		return  "ListallUsers";
    	}
        @GetMapping("")
    	public String viewHomePage() {
    		return "index";
    	}
    	
    	//showRegistrationForm(Model model): Handles the GET request for the registration form.
    	@GetMapping("/register")
    	public String showRegistrationForm(Model model) {
    	    model.addAttribute("user", new User());
    	     
    	    return "signup_form";
    	}
    	
    	//processRegistration(User user): Handles the POST request for processing user registration.
    	@PostMapping("/process_register")
    	public String processRegistration(User user) 
    	{
    		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    		String encodedPassword = encoder.encode(user.getPassword());
    		user.setPassword(encodedPassword);
    		
    		
    		repo.save(user);
    		
    		return "register_success";
    	}
    	
    	
    	
//    	@RestController
//    	@RequestMapping("/api")
//    	public class DecisionController {
//
//    	    // Example in-memory database (replace this with a real database)
//    	    private final Map<String, String> decisionsDatabase = new HashMap<>();
//
//    	    @PostMapping("/updateDecision")
//    	    public Map<String, Object> updateDecision(@RequestBody Map<String, String> request) {
//    	        String title = request.get("title");
//    	        String decision = request.get("decision");
//
//    	        // Validate input (add more validation if needed)
//    	        if (title == null || decision == null) {
//    	            Map<String, Object> response = new HashMap<>();
//    	            response.put("error", "Invalid input");
//    	            return response;
//    	        }
//
//    	        // Update the decision in the database
//    	        decisionsDatabase.put(title, decision);
//
//    	        // Respond with success
//    	        Map<String, Object> response = new HashMap<>();
//    	        response.put("success", true);
//    	        return response;
//    	    }
//    	}
    	@RestController
    	public class AssignedReviewerController {

    	    @Autowired
    	    private AssignedReviewerRepository assignedReviewerRepository;

    	    @PostMapping("/api/assign_reviewers") // Ensure that this endpoint only handles POST requests
    	    public AssignedReviewer assignReviewers(@RequestBody AssignedReviewer assignedReviewer) {
    	        return assignedReviewerRepository.save(assignedReviewer);
    	    }
    	}
    	
//    	@RestController
//    	@RequestMapping("/api")
//    	public class PaperController {
//
//    	    private final PaperService paperService;
//
//    	    @Autowired
//    	    public PaperController(PaperService paperService) {
//    	        this.paperService = paperService;
//    	    }
//
//    	    @PostMapping("/updateDecision")
//    	    public String updateDecision(@RequestParam String title, @RequestParam String decision) {
//    	        System.out.println("Received decision update: Title - " + title + ", Decision - " + decision);
//
//    	        // Assuming updateDecision method returns a status or success message
//    	        String updateStatus = paperService.updateDecision(title, decision);
//
//    	        System.out.println("Decision updated successfully."); // Assuming success
//    	        return updateStatus; // Return status or success message
//    	    }
//    	}
    	
    	
//
//    
//  
    	@Controller
    	public class AcceptedPapersController {

    	    private final SubmissionService submissionService;

    	    @Autowired
    	    public AcceptedPapersController(SubmissionService submissionService) {
    	        this.submissionService = submissionService;
    	    }

    	    @GetMapping("/acceptedpapers")
    	    public String showAcceptedPapers(Model model) {
    	        List<Submissions> acceptedPapers = submissionService.getAcceptedPapers();
    	        model.addAttribute("acceptedPapers", acceptedPapers);
    	        return "accepted_papers"; // Assuming the HTML file is named accepted_papers.html
    	    }
    	}

    	@Controller
    	public class RejectedPapersController {

    	    private final SubmissionService submissionService;

    	    @Autowired
    	    public RejectedPapersController(SubmissionService submissionService) {
    	        this.submissionService = submissionService;
    	    }

    	    @GetMapping("/rejectedpapers")
    	    public String showRejectedPapers(Model model) {
    	        List<Submissions> rejectedPapers = submissionService.getRejectedPapers();
    	        model.addAttribute("rejectedPapers", rejectedPapers);
    	        return "rejected_papers"; // Assuming the HTML file is named rejected_papers.html
    	    }
    	}
    	@Controller
    	public class AllPapersController {

    	    private final SubmissionService submissionService;

    	    @Autowired
    	    public AllPapersController(SubmissionService submissionService) {
    	        this.submissionService = submissionService;
    	    }

    	    @GetMapping("/allpapers")
    	    public String showAllPapers(Model model) {
    	        List<Submissions> allPapers = submissionService.getAllPapers();
    	        model.addAttribute("allPapers", allPapers);
    	        return "statusupdate"; // Assuming the HTML file is named all_papers.html
    	    }
    	}
    	@Controller
    	public class PaperDecisionController {

    	    @Autowired
    	    private PaperDecisionRepository paperDecisionRepository; // Assuming you have a repository for managing paper decisions

    	    @PostMapping("/submitDecision")
    	    public String submitDecision(@RequestParam("paperName") String paperName, @RequestParam("status") String status) {
    	        PaperDecision decision = new PaperDecision();
    	        decision.setPaperName(paperName);
    	        decision.setStatus(status);
    	        paperDecisionRepository.save(decision); // Save to the database
    	        return "redirect:/"; // Redirect to home page or any other page after submission
    	    }
    	}
    	
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
}