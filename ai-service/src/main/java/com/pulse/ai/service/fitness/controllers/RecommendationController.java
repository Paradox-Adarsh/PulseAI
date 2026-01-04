package com.pulse.ai.service.fitness.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulse.ai.service.fitness.models.Recommendations;
import com.pulse.ai.service.fitness.services.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/recommendation")
public class RecommendationController {
	private final RecommendationService recService;
	
	
	@GetMapping("user/{userId}")
	public ResponseEntity<List<Recommendations>>getUserRecommendation(@PathVariable String userId){
		
		return ResponseEntity.ok(recService.getUserRecommendations(userId));
		

	}
	
	
	@GetMapping("activity/{activityId}")
	public ResponseEntity<Recommendations> getActivityRecommendation(@PathVariable String activityId){
		return ResponseEntity.ok(recService.getActivityRecommendation(activityId));
		
	}
	

}
