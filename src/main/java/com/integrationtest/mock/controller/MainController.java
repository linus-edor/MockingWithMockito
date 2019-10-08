package com.integrationtest.mock.controller;

import static org.assertj.core.api.Assertions.allOf;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.any;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.integrationtest.mock.model.User;
import com.integrationtest.mock.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(User user) {
		userService.addUser(user);
		return ResponseEntity.ok(user);
	}

}
