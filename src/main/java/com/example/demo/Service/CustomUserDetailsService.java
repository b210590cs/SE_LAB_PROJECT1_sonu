package com.example.demo.Service;
//package- com.example.demo.Service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

//class - customUserDetailsService
public class CustomUserDetailsService implements UserDetailsService {
    //implements- UserDetailsService: Interface for loading user-specific data.
	
	
	@Autowired
	private UserRepository repo;
	//fields- repo (Type: UserRepository, Autowired): Repository instance used for accessing user data.
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//loadUserByUsername(String email): Loads user details by email.
		//loadUserByUsername(String email): Loads user details by email.
		
		
		//Functionality:
		//Retrieves the user from the repository based on the provided email.
		//Throws a UsernameNotFoundException if the user is not found.
		//Returns an instance of customUserDetails containing the user's details.
		 User user = repo.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new customUserDetails(user);
	        //returns the UserDetails: User details interface representing the loaded user.
	}

}
//his class is a custom implementation of the UserDetailsService interface, allowing for customization of user data retrieval during authentication.
//It retrieves user details from the repository based on the provided email address and constructs a UserDetails object for authentication purposes.