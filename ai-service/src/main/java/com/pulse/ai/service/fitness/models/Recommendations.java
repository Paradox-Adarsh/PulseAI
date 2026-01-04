package com.pulse.ai.service.fitness.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection="recommendations")
@Builder
@Data
public class Recommendations {
	@Id
	private String id;
	private String activityId;
	private String userId;
	private List<String> improvements;
	private List<String>suggestions;
	private List<String>safety;
	@CreatedDate
	private LocalDateTime createdAt;
	

}
