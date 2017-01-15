package com.syed.exception;

public class NoMovieFound extends RuntimeException {
	
	public NoMovieFound(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
