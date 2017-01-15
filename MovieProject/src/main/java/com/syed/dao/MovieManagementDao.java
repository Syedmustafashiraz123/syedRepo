package com.syed.dao;

import java.util.List;

import com.syed.model.Movie;

public interface MovieManagementDao {

	/* (non-Javadoc)
	 * @see com.ing.training.dao.UserManagementDao#createUser(com.ing.training.domain.User)
	 */
	public abstract Movie createMovie(Movie movie);

	public abstract Movie getMovieById(int id);

	public abstract List<Movie> listMovies();
	
	public abstract void deleteMovie(int id);

}