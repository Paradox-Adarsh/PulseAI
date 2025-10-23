package com.pulse.ai.userservice.fitness.services;

import org.springframework.stereotype.Service;

import com.pulse.ai.userservice.fitness.Repository.UserRepository;
import com.pulse.ai.userservice.fitness.dto.RegisterRequestDTO;
import com.pulse.ai.userservice.fitness.dto.UserResponseDTO;
import com.pulse.ai.userservice.fitness.models.User;

import lombok.AllArgsConstructor;

@Service

@AllArgsConstructor
public class UserService {
	
	
	private UserRepository repository;

	public UserResponseDTO register(RegisterRequestDTO request) {
		
		if(repository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("User already exists");
		}
		
		User user=new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		
		User savedUser=repository.save(user);
		
		UserResponseDTO response=new UserResponseDTO();
		response.setId(savedUser.getId());
		response.setEmail(savedUser.getEmail());
		response.setPassword(savedUser.getPassword());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		
		
		return response;
	}

	public UserResponseDTO findUser(String userId) {
		User user=repository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
		
		UserResponseDTO response=new UserResponseDTO();
//		response.setId(user.getId());
		response.setEmail(user.getEmail());
		response.setPassword(user.getPassword());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		
		
		
		return response;
	}

}
