package com.pulse.ai.applicationservice.fitness.service;

import org.springframework.stereotype.Service;

import com.pulse.ai.applicationservice.fitness.dto.ActivityRequest;
import com.pulse.ai.applicationservice.fitness.dto.ActivityResponse;
import com.pulse.ai.applicationservice.fitness.models.Activity;
import com.pulse.ai.applicationservice.fitness.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository activityRepo;

	public ActivityResponse trackActivity(ActivityRequest request) {

		Activity activity = Activity.builder().userId(request.getUserId()).type(request.getType())
				.duration(request.getDuration()).caloriesBurned(request.getCaloriesBurned())
				.startTime(request.getStartTime()).additionalMetrics(request.getAdditionalMetrics()).build();
		Activity savedActivity = activityRepo.save(activity);
		return mapToResponse(savedActivity);

	}

	private ActivityResponse mapToResponse(Activity savedActivity) {
		ActivityResponse response = new ActivityResponse();
		response.setId(savedActivity.getId());
		response.setUserId(savedActivity.getUserId());
		response.setType(savedActivity.getType());
		response.setDuration(savedActivity.getDuration());
		response.setCaloriesBurned(savedActivity.getCaloriesBurned());
		response.setStartTime(savedActivity.getStartTime());
		response.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
		response.setCreatedAt(savedActivity.getCreatedAt());
		response.setUpdatedAt(savedActivity.getUpdatedAt());
		return response;
	}

}
