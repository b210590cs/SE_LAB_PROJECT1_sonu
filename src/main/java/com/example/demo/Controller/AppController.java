package com.example.demo.Controller;
//pakage -com.example.demo.Controller

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.User;
import com.example.demo.Repository.ReviewerRepository;
import com.example.demo.Repository.UserRepository;

//class- AppController
//@Controller: Indicates that the class serves as a controller in Spring MVC.
@Controller
public class AppController {
    
	
	@Autowired
	private UserRepository repo;	
    //repo (Type: UserRepository, Autowired): Repository instance used for accessing user data.
	
	
	//viewHomePage(): Handles the GET request for the homepage.
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
	
	//home(): Handles the GET request for the home page.
	@GetMapping("/home")
    public String home() {
        return "home"; // Assumes you have a "home.html" file in the templates directory
    }

    @GetMapping("/reviewers")
    public String reviewer() {
        return "reviewers"; 
    }
    @GetMapping("/accepted")
    public String accepted() {
        return "accepted"; 
    }
    
    @GetMapping("/responses")
    public String responses() {
        return "responses";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; 
    }
    // @GetMapping("/assignreviewers")
    // public String assignreviewers() {
    //     return "assignreviewers"; 
    // }
    @GetMapping("/rejectedpapers")
    public String rejectedpapers() {
        return "rejectedpapers";
    }

	//viewUsersList(Model model): Handles the GET request for viewing the list of users.
	@GetMapping("/list_users")
	public String viewUsersList(Model model)
	{
	
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers" , listUsers);
		return "ListallUsers";
	}
	

}
