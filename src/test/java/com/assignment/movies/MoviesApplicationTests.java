package com.assignment.movies;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.movies.controller.MoviesController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MoviesController.class)
public class MoviesApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getMoviesTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/v1/movies")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void createMoviesTest() throws Exception {
		String exampleCourseJson = "{\"id\":\"1\",\"title\":\"movie1\",\"year\":\"2016\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/v1/movies")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(201, result.getResponse().getStatus());
	}
	
	@Test
	public void updateMoviesTest() throws Exception {
		String exampleCourseJson = "{\"id\":\"1\",\"title\":\"movie1\",\"year\":\"2017\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/v1/movies/1")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	@Test
	public void deleteMoviesTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/v1/movies/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}

}
