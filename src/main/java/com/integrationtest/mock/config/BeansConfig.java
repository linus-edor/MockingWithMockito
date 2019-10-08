package com.integrationtest.mock.config;

import org.springframework.context.annotation.Bean;
import com.integrationtest.mock.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeansConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
