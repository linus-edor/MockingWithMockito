package com.integrationtest.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.integrationtest.mock.model.User;
import com.integrationtest.mock.repository.UserRepository;
import com.integrationtest.mock.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockingExampleApplicationTests {
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllUsersTest() {
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User(Long.valueOf(1), "linus", "addess@mail.com", "password"),
						new User(Long.valueOf(2), "linus1", "addess1@mail.com", "password1"))
				.collect(Collectors.toList()));
		assertEquals(2, userService.findAllUsers().size());
	}

}
