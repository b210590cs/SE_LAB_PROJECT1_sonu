package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.example.demo.model.Reviewer;
import com.example.demo.model.Submissions;
import com.example.demo.Repository.ReviewerRepository;
import com.example.demo.Repository.SubmissionsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ObjectMapper objectMapper; 
    private static final String USERS_JSON_PATH = "path/to/users.json"; 

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Read users from JSON file
        List<User> users = getUsersFromJson();

        Optional<User> matchingUser = users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();

        if (matchingUser.isPresent()) {
            // Successful login
            return "redirect:/dashboard"; 
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    // Method to read users from the JSON file
    private List<User> getUsersFromJson() {
        try {
            File file = new ClassPathResource(USERS_JSON_PATH).getFile();
            return Arrays.asList(objectMapper.readValue(file, User[].class));
        } catch (IOException e) {
            // Handle exception (e.g., log it)
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

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
    @GetMapping("/rejectedpapers")
    public String rejectedpapers() {
        return "rejectedpapers"; // Assumes you have a "home.html" file in the templates directory
    }
    
    @GetMapping("/decisions")
    public String decisions() {
        return "decisions"; // Assumes you have a "home.html" file in the templates directory
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Assuming you have a User class for registration data
        return "register";
    }
    

    @PostMapping("/register")
    public String register(@ModelAttribute User user, BindingResult bindingResult) {
        // Perform registration logic here
        // Redirect to login page or handle registration success

        // For example:
        if (bindingResult.hasErrors()) {
            return "register"; // Return to the registration form with error messages
        }

        // Registration logic goes here

        return "redirect:/"; // Redirect to the login page after a successful registration
    }
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
        @RestController
        @RequestMapping("/api/submissions")
        public class SubmissionController {

            @Autowired
            private SubmissionsRepository submissionsRepository;

            @GetMapping
            public List<Submissions> getAllSubmissions() {
                return submissionsRepository.findAll();
            }
        }
    }
       
}