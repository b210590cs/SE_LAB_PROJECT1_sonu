package com.example.demo.SecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 


public class PasswordEncoder {

	public static void main(String[] args) {
		//main(String[] args): The main method of the class. It demonstrates how to use the BCryptPasswordEncoder to encode a raw password.
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "john123";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);

	}

}

//Functionality
//Initializes a new instance of BCryptPasswordEncoder.
//Specifies a raw password to be encoded.
//Encodes the raw password using the BCrypt algorithm.
//Prints the encoded password to the console.
//Output
//The output of the main method will be the encoded version of the raw password.