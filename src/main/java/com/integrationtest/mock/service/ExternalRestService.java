package com.integrationtest.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.integrationtest.mock.model.User;

@Service
public class ExternalRestService {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<?> getUser(long id) {
		return restTemplate.getForEntity("http://localhost:8080/user/" + id, User.class);
	}
}