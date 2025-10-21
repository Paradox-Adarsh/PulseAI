package com.pulse.ai.fitness.services;

import org.springframework.stereotype.Service;

import com.pulse.ai.fitness.Repository.UserRepository;
import com.pulse.ai.fitness.dto.RegisterRequest;
import com.pulse.ai.fitness.dto.UserResponse;
import com.pulse.ai.fitness.models.User;

import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor
public class UserService {
	
	
	private UserRepository repository;

	public UserResponse register(RegisterRequest request) {
		User user=new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		
		User savedUser=repository.save(user);
		
		UserResponse response=new UserResponse();
		response.setEmail(savedUser.getEmail());
		response.setPassword(savedUser.getPassword());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		
		return response;
	}

}
