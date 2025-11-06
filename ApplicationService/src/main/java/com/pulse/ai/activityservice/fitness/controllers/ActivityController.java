package com.pulse.ai.applicationservice.fitness.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulse.ai.applicationservice.fitness.dto.ActivityRequest;
import com.pulse.ai.applicationservice.fitness.dto.ActivityResponse;
import com.pulse.ai.applicationservice.fitness.service.ActivityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
	
	private ActivityService activityService;
	
	@PostMapping
	public ResponseEntity<ActivityResponse>trackActivity(@RequestBody ActivityRequest request){
		return ResponseEntity.ok(activityService.trackActivity(request));
		
		
	}
	

}
