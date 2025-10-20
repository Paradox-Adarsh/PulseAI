package com.pulse.ai.fitness.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private String id;
	private String email;
	private String pssword;
	private String firstName;
	private String lastName;
	private UserRole role =UserRole.USER;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
	
	
	
	
	
	
}
