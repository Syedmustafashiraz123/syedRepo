package com.syed.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syed.model.Movie;
import com.syed.service.MovieManagementService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/movies")
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	MovieManagementService movieService;
	
	/** This method creates a new movie 
	 * @param user
	 * @return User and HttpStatus
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		
		logger.info("movie: " +movie);
		Movie movieInsert=movieService.createMovie(movie);
		logger.info("movie inserted successfully: " +movieInsert);
		return new ResponseEntity<Movie>(movieInsert, HttpStatus.CREATED);
		
		
	}
	
	
	//Delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteMovie(@PathVariable int id) {
		
		logger.info("Delete movie with id : " +movie);
		Movie movieInsert=movieService.createMovie(movie);
		logger.info("movie inserted successfully: " +movieInsert);
		return new ResponseEntity<Movie>(movieInsert, HttpStatus.CREATED);
			}
	
	  @RequestMapping("/delete/{contactId}")
			public String deleteContact(@PathVariable("contactId") Integer contactId) {
			    contactService.removeContact(contactId);
			    return "redirect:/mvc/index";
			}
	
	
	
	
	
	
	/** Get movie details by Id
	 * @param id
	 * @return User Details
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Movie getMovieById(@PathVariable int id) {
		
		return movieService.getMovieById(id);
		
	}
	
	/** Get 
	 * @param id
	 * @return User Details
	 */	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Movie> listMovies() {
	//	return new ArrayList<User>();
		return movieService.listMovies();
		
	}
	
	
	
	
	
}
