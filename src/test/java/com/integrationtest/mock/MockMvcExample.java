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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.integrationtest.mock.model.User;
import com.integrationtest.mock.repository.UserRepository;
import com.integrationtest.mock.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MockMvcExample {

	@Before
	public void init() {
//		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	MockMvc mock;

	@MockBean
	UserService userService;

	@MockBean
	UserRepository userRepo;

	@Test
	public void contextLoads() {
		try {
			MvcResult mvcResult = mock
					.perform(MockMvcRequestBuilders.get("/api/users/").accept(MediaType.APPLICATION_JSON)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
