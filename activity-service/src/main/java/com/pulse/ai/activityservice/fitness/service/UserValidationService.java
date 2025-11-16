package com.pulse.ai.activityservice.fitness.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserValidationService {

	private final WebClient userServiceClient;

	public boolean validateUser(String userId) {

		try {
			return userServiceClient.get().uri("api/users/{userId}/validate", userId).retrieve()
					.bodyToMono(Boolean.class).block();
		} catch (WebClientResponseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
