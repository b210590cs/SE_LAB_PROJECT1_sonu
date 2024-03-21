package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entity: Indicates that the class is an entity, which will be mapped to a database table.

@Table(name = "users")
//@Table(name = "users"): Specifies the name of the database table to which this entity is mapped.

public class User{

	@Id
	//@Id: Specifies the primary key of the entity.
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the generation strategy for the primary key, using database identity column.

	private Long id;
     //id (Type: Long, Generated value: IDENTITY): Unique identifier for the user.
	//@Column: Specifies the mapping for a persistent entity attribute. Used to define the column name, constraints, and length for each field.

	
	@Column(nullable = false, unique = true, length = 45)
	private String email;
    //email (Type: String, Constraints: nullable = false, unique = true, length = 45): Email address of the user. It must be unique and cannot be null
	
	
	@Column(nullable = false, length = 64)
    private String password;
	//password (Type: String, Constraints: nullable = false, length = 64): Password of the user. It cannot be null.
	
	
	 @Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
    //firstName (Type: String, Constraints: nullable = false, length = 20): First name of the user. It cannot be null.

	 @Column(name = "last_name", nullable = false, length = 20)
	 private String lastName;
	 //lastName (Type: String, Constraints: nullable = false, length = 20): Last name of the user. It cannot be null.

	 

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    
    // getters and setters are not shown 
	
}
