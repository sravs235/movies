package com.assignment.movies.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.movies.model.Movie;

@RestController
@RequestMapping("v1")
public class MoviesController {

	private final Logger logger = LoggerFactory.getLogger(MoviesController.class);
	
	private static Map<String, Movie> movies = new HashMap<String, Movie>();
	
	static {
		Movie movie = new Movie();
		movie.setId("1");
		movie.setTitle("movie1");
		movie.setYear(2016);
		movies.put("1", movie);
	}
	
	@PostMapping("/movies")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
		logger.debug("add movie started");
		if (movie == null) {
			return new ResponseEntity<String>("Provide movie", HttpStatus.BAD_REQUEST);
		}
		movies.put(movie.getId(), movie);
		logger.debug("add movie completed");
		return new ResponseEntity<String>("Movie added successfully",
				HttpStatus.CREATED);
	}
	
	@PutMapping("/movies/{movieId}")
	public ResponseEntity<?> updateMovie(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {
		logger.debug("update movie started");
		if (movie != null && movieId != null && movieId.equals(movie.getId())) {
			movies.put(movieId, movie);
		} else {
			return new ResponseEntity<String>("Provide correct movie details", HttpStatus.BAD_REQUEST);
		}
		logger.debug("update movie completed");
		return new ResponseEntity<String>("Movie updated successfully",
				HttpStatus.OK);
	}
	
	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<?> deleteMovie(@PathVariable("movieId") String movieId) {
		logger.debug("delete movie started");
		if (movieId == null) {
			return new ResponseEntity<String>("Provide movie id", HttpStatus.BAD_REQUEST);
		}
		movies.remove(movieId);
		logger.debug("delete movie completed");
		return new ResponseEntity<String>("Movie deleted successfully",
				HttpStatus.OK);
	}
	
	@GetMapping("/movies")
	public ResponseEntity<?> getMovies() {
		logger.debug("get movies started");
		// String moviesList = String.join(",", movies);
		List<Movie> moviesList = new ArrayList<Movie>(movies.values());
		logger.debug("get movies completed");
		return new ResponseEntity<List<Movie>>(moviesList,
				HttpStatus.OK);
	}


}
