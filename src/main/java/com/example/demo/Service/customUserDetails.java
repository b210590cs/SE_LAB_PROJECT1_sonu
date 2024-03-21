package com.example.demo.Service;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;


public class customUserDetails implements UserDetails {

	private User user;
	
	
	//Constructs a new customUserDetails instance with the provided User entity.
	public customUserDetails(User user) {

		this.user = user;
	}

	//getAuthorities(): Returns the authorities granted to the user. (Not implemented)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	//getPassword(): Returns the password of the user.
	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	//getUsername(): Returns the username of the user, which is the email address.
	 @Override
	    public String getUsername() {
	        return user.getEmail();
	    }
	
    //isAccountNonExpired(): Indicates whether the user's account is not expired. (Always returns true)
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	//isAccountNonLocked(): Indicates whether the user's account is not locked. (Always returns true)
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	//isCredentialsNonExpired(): Indicates whether the user's credentials are not expired. (Always returns true)
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

//	public String getFullName() {
//        return user.getFirstName() + " " + user.getLastName();
//    }
 
	//isEnabled(): Indicates whether the user is enabled. (Always returns true)
	@Override
	public boolean isEnabled() {
		
		return true;
	}

}

//The customUserDetails class implements the UserDetails interface for the application's User entity.
//Additional methods or properties can be added to this class to provide more user-specific details as needed.

