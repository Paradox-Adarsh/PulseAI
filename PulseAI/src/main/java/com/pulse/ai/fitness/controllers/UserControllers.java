package com.pulse.ai.fitness.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulse.ai.fitness.dto.RegisterRequest;
import com.pulse.ai.fitness.dto.UserResponse;
import com.pulse.ai.fitness.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserControllers {
	
	private UserService userServ;
	
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse>register (@RequestBody RegisterRequest request ){
		return ResponseEntity.ok(userServ.register(request));
		
	}
	
	

}
