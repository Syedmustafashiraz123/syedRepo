package com.syed.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.syed.dao.MovieManagementDao;
import com.syed.model.Movie;
import com.syed.exception.MovieCreationException;
import com.syed.exception.MovieFetchException;


@Service
public class MovieManagementService {

	
	private static final Logger logger = LoggerFactory.getLogger(MovieManagementService.class);
	
	@Autowired
	MovieManagementDao movieManagementDao;
	
	
	public Movie createMovie(Movie movie)
	{
		try
		{
		return movieManagementDao.createMovie(movie);
		}
		catch(DataAccessException dae)
		{
			logger.error("Error in creation of new movie", dae);
			throw new MovieCreationException("Error in creation of movie", dae);
		}
	}
	
	public Movie getMovieById(int id)
	{
		//return populateUser(id);
		
		Movie movie=new Movie();
		try
		{
		movie=movieManagementDao.getMovieById(id);
		}
		catch(DataAccessException dae)
		{
			logger.error("Error in Fetching Movie Details for MovieId: "+ id , dae);
			throw new MovieFetchException("Error in Fetching Movie Details for UserId: "+ id, dae);
		}
		return movie;
	}
	
	public List<Movie> listMovies()
	{
		List<Movie> movieList=new ArrayList<>();
		try
		{
			movieList=movieManagementDao.listMovies();
		}
		catch(DataAccessException dae)
		{
			logger.error("No Movie Found", dae);
			throw new MovieFetchException("No Movie Found", dae);
		}
		return movieList;
	}
	
	
	/*
	private Movie populateMovie(int id)
	{
		Movie user=new Movie();
		user.setFirstname("John");
		user.setLastname("Kim");
		user.setCity("Mumbai");
		user.setId(id);
		
		return user;
		
	} */
}
