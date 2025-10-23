package com.pulse.ai.userservice.fitness.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulse.ai.userservice.fitness.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	Boolean existsByEmail(String email);

}
