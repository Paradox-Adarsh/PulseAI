package com.pulse.ai.activityservice.fitness.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import com.pulse.ai.activityservice.fitness.models.ActivityType;

import lombok.Data;

@Data
public class ActivityRequest {

	private String id;
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;

	private Map<String, Object> additionalMetrics;

	

}
