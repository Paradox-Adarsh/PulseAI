package com.pulse.ai.service.fitness.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pulse.ai.service.fitness.models.Activity;
import com.pulse.ai.service.fitness.models.Recommendations;
import com.pulse.ai.service.fitness.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityMessageListener {
	
	
	private final ActivityAIService activityAiService;
	private final RecommendationRepository respository;

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "activity-processor-group")
	public void processActivity(Activity activity) {
		log.info("Received activity for processing : {} ", activity.getUserId());
		Recommendations recommendations=activityAiService.generateRecommendation(activity);
		respository.save(recommendations);
		

	}

}
