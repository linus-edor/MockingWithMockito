package com.integrationtest.mock.config;

import org.springframework.context.annotation.Bean;
import com.integrationtest.mock.service.UserService;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeansConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}
}
