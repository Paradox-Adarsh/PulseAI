package com.pulse.ai.fitness.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulse.ai.fitness.dto.RegisterRequestDTO;
import com.pulse.ai.fitness.dto.UserResponseDTO;
import com.pulse.ai.fitness.services.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserControllers {
	
	private UserService userServ;
	
	
	@GetMapping("/{userId}")
	
	public ResponseEntity<UserResponseDTO>findUserProfile(@PathVariable String userId){
		
		
		return ResponseEntity.ok(userServ.findUser(userId));
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO>register (@Valid @RequestBody RegisterRequestDTO request ){
		return ResponseEntity.ok(userServ.register(request));
		
	}
	
	

}
