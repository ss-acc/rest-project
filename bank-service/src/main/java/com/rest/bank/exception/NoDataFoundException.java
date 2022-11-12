package com.rest.bank.exception;

public class NoDataFoundException extends RuntimeException {
	
    public NoDataFoundException() {

        super("No bank found");
        
    }

}

