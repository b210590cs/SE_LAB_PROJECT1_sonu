package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "pc_db")
@NoArgsConstructor
@AllArgsConstructor
public class Pc {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private int password;
	
	
}


