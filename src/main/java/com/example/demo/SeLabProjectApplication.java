package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class SeLabProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeLabProjectApplication.class, args);
    }

    @Controller
    public static class HomeController {

        @GetMapping("/")
        public String index() {
            return "login";
        }

        @PostMapping("/login")
        public String login(@RequestParam String username, @RequestParam String password, Model model) {
            // Replace with actual authentication logic
            if ("admin".equals(username) && "password".equals(password)) {
                return "redirect:/dashboard"; // Redirect to "home.html" after successful login
            } else {
                model.addAttribute("error", "Invalid username or password");
                return "login";
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

            return "redirect:/"; // Redirect to the login page after successful registration
        }
    }

    // User class for registration data
    public static class User {
        private String lname;
        private String email;
        private String password;
        private String dob;
        private String phone;
        private String tandc;
        private boolean consent;

        // Getters and setters
    }
}
