package com.syed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Movie Not Found")
public class MovieFetchException extends RuntimeException {
	
	public MovieFetchException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
