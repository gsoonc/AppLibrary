package com.evc.applibrary.backend.models.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private String message;
	
	public BookNotFound () {
    }
    
    public BookNotFound(String message) {
        super(message);
    	this.message = message;
    }
}
