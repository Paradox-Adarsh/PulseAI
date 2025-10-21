package com.pulse.ai.fitness.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulse.ai.fitness.models.User;

public interface UserRepository extends JpaRepository<User, String>{
		
	}


