package com.pulse.ai.service.fitness.services;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pulse.ai.service.fitness.models.Recommendations;
import com.pulse.ai.service.fitness.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {
	
	
	private final RecommendationRepository recRepo;

	public List<Recommendations> getUserRecommendations(String userId) {
		// TODO Auto-generated method stub
		return recRepo.findByUserId(userId);
	}

	public Recommendations getActivityRecommendation(String activityId) {
		// TODO Auto-generated method stub
		return recRepo.findByActivityId(activityId).orElseThrow(()-> new RuntimeException("No Recommendation found for this activity") );
	}

	
	
	
	
	

}
