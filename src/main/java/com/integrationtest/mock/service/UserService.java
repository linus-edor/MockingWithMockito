package com.integrationtest.mock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.integrationtest.mock.repository.UserRepository;
import com.integrationtest.mock.model.User;;

public class UserService {
	
	@Autowired
	UserRepository repo;

	public List<User> findAllUsers() {
		return repo.findAll();
	}

	public Optional findUserById(Long id) {
		return repo.findById(id);
	}

	public void addUser(User user) {
		repo.save(user);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
