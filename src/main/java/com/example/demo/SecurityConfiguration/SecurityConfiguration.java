
package com.example.demo.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Service.CustomUserDetailsService;
 
@Configuration
//@Configuration: Indicates that the class provides bean definitions that are used to configure the application context.
public class SecurityConfiguration   {
     
    @Bean
    //@Bean: Indicates that a method produces a bean to be managed by the Spring container.
<<<<<<< HEAD
    customUserDetailsService userDetailsService() {
        return new customUserDetailsService();
=======
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
>>>>>>> 418c0ab32669f93fd65a38fb095e059765122124
    }
    //userDetailsService(): Returns an instance of customUserDetailsService to handle user details retrieval.
    
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //passwordEncoder(): Returns an instance of BCryptPasswordEncoder to encode passwords.

     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    //authenticationProvider(): Returns a DaoAuthenticationProvider configured with the custom user details service and password encoder.

 
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
         
        http.authenticationProvider(authenticationProvider());
         //http (Type: HttpSecurity): Represents the HTTP security configuration object.
        
        http.authorizeHttpRequests(auth ->
            auth.requestMatchers("/dashboard").authenticated()
            .anyRequest().permitAll()
            )
            .formLogin(login ->
                login.usernameParameter("email")
                .defaultSuccessUrl("/dashboard")
                .permitAll()
            )
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll()
        );
         
        return http.build();
    }  
}
//Functionality:
//Configures authentication provider using authenticationProvider() bean.
//Defines authorization rules using lambda expressions.
//Specifies URL patterns and access control rules.
//Configures form-based login with custom parameters and success URL.
//Configures logout behavior with a redirect URL.


//Dependencies
//org.springframework.security.authentication.dao.DaoAuthenticationProvider: Used to configure authentication provider.
//org.springframework.security.config.annotation.web.builders.HttpSecurity: Used to configure HTTP security settings.
//org.springframework.security.core.userdetails.UserDetailsService: Interface for loading user-specific data.
//org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder: Used for password encoding.
//com.example.demo.Service.customUserDetailsService: Custom implementation of UserDetailsService.
