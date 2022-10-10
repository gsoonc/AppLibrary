package com.evc.applibrary.backend.models.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.FOUND)
public class UserAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExists () {
        this.message = "User already exists";
    }
    
    public UserAlreadyExists(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message; 
    }
    
    private String message;

	
}
