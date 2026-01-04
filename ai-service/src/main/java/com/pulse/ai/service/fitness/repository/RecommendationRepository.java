package com.pulse.ai.service.fitness.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pulse.ai.service.fitness.models.Recommendations;

public interface RecommendationRepository extends  MongoRepository<Recommendations, String>{

	List<Recommendations> findByUserId(String userId);

	Optional <Recommendations> findByActivityId(String activityId);
		
}
