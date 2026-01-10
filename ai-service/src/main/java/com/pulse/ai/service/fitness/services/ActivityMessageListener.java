package com.pulse.ai.service.fitness.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pulse.ai.service.fitness.models.Activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityMessageListener {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "activity-processor-group")
	public void processActivity(Activity activity) {
		log.info("Received activity for processing : {} ", activity.getUserId());

	}

}
