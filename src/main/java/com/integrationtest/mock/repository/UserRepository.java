package com.integrationtest.mock.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.integrationtest.mock.model.User;

public interface UserRepository  extends JpaRepositoryImplementation<User,Long>{
}
