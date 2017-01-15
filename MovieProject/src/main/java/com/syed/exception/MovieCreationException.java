package com.syed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Movie Creation Failed Due to Some Conflict")
public class MovieCreationException extends RuntimeException {
	
	public MovieCreationException(String msg, Throwable cause)
	{
		super(msg, cause);
	}

}
