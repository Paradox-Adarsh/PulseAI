package com.pulse.ai.fitness.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDTO {
	
	
	@NotBlank(message="Email is required")
	@Email(message="Invalid Email Format")
	private String email;
	
	@NotBlank(message="Password is required")
	@Size(message="password must have atleast six characters")
	private String password;
	private String firstName;
	private String lastName;

}
