package com.pulse.ai.applicationservice.fitness.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pulse.ai.applicationservice.fitness.models.Activity;

@Repository
public interface ActivityRepository extends MongoRepository<Activity,String> {
	

}
