package com.rest.card.exception;

public class NoDataFoundException extends RuntimeException {
	
    public NoDataFoundException() {

        super("No card found");
        
    }

}
