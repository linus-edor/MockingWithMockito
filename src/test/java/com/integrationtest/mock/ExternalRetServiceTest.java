package com.integrationtest.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.integrationtest.mock.model.User;
import com.integrationtest.mock.service.ExternalRestService;
import com.integrationtest.mock.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class ExternalRetServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private ExternalRestService restService = new ExternalRestService();

	@Test(expected = NullPointerException.class)
	public void mockCallAndReturnMockedObject() {
		User user = new User(Long.valueOf(3), "user3", "mail@mail.com", "password");
		Mockito.when(restTemplate.getForEntity("http://localhost:8080/user/3", User.class))
				.thenReturn(new ResponseEntity(user, HttpStatus.OK));

		User user1 = (User) restService.getUser(3).getBody();
		assertEquals(user1, user);
		User user2 = (User) restService.getUser(4).getBody();//NullPointerException expected here
	}
}