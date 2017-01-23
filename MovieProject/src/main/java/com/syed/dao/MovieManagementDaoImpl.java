package com.syed.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.syed.model.Movie;

@Repository("movieManagementDao")
public class MovieManagementDaoImpl implements MovieManagementDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Movie createMovie(Movie movie)
	{
		String insertMovieQuery="INSERT INTO MOVIES VALUES(?,?,?,?)";
		int movieId=getIdForMovie();
		jdbcTemplate.update(insertMovieQuery, new Object[]{movieId, movie.getMoviename(), movie.getLeadactor(), movie.getLanguage()});
		return populateMovieWithId(movie, movieId);
		
	}
	
	@Override
	public void deleteMovie(int id) {
		String deleteMovieQuery="DELETE FROM MOVIES WHERE ID=?";
		int movieId=id;
		jdbcTemplate.update(deleteMovieQuery, new Object[]{movieId});
	}
	
	
	
	private Movie populateMovieWithId(Movie movie, int movieId)
	{
		Movie createdMovie=new Movie();
		BeanUtils.copyProperties(movie, createdMovie);
		createdMovie.setId(movieId);
		return createdMovie;
	}
	
	private int getIdForMovie()
	{
		String highestMovieIdQuery="SELECT MAX(ID) FROM MOVIES";
		Integer id=jdbcTemplate.queryForObject(highestMovieIdQuery, Integer.class);
		return id+1;
	}
	
	
	@Override
	public Movie getMovieById(int id)
	{
		String getMovieByIdQuery="SELECT * FROM MOVIES WHERE ID=?";
		
		return jdbcTemplate.queryForObject(getMovieByIdQuery, new Object[]{id}, (rs, rowNum)->{
			
			Movie movie=new Movie();
			movie.setId(rs.getInt("id"));
			movie.setMoviename(rs.getString("moviename"));
			movie.setLeadactor(rs.getString("leadactor"));
			movie.setLanguage(rs.getString("language"));
			
			return movie;
			
		});
		
	}
	
	
	@Override
	public List<Movie> listMovies()
	{
		String getMovieByIdQuery="SELECT * FROM MOVIES";
		return jdbcTemplate.query(getMovieByIdQuery, (rs, rowNum)->{
			
			Movie movie=new Movie();
			movie.setId(rs.getInt("id"));
			movie.setMoviename(rs.getString("moviename"));
			movie.setLeadactor(rs.getString("leadactor"));
			movie.setLanguage(rs.getString("language"));
			
			return movie;
			
		});
	}


}
