package com.pulse.ai.activityservice.fitness.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pulse.ai.activityservice.fitness.dto.ActivityRequest;
import com.pulse.ai.activityservice.fitness.dto.ActivityResponse;
import com.pulse.ai.activityservice.fitness.models.Activity;
import com.pulse.ai.activityservice.fitness.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository activityRepo;
	
	private final UserValidationService validate;
	
	private final KafkaTemplate<String, Activity>kafkaTemplate;
	
	
	@Value("{kafka.topic.name}")
	private String topicName;

	
	public ActivityResponse trackActivity(ActivityRequest request) {
		
		if (!validate.validateUser(request.getUserId())) {
			throw new RuntimeException("Invalid User Id"+request.getUserId());
		}

		Activity activity = Activity.builder().userId(request.getUserId()).type(request.getType())
				.duration(request.getDuration()).caloriesBurned(request.getCaloriesBurned())
				.startTime(request.getStartTime()).additionalMetrics(request.getAdditionalMetrics()).build();
		Activity savedActivity = activityRepo.save(activity);
		
		try{
			kafkaTemplate.send(topicName, savedActivity.getUserId(),savedActivity);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
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
