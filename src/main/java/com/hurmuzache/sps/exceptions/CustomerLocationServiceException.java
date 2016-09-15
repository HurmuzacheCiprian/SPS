package com.hurmuzache.sps.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerLocationServiceException extends RuntimeException {
    public CustomerLocationServiceException() {
        super();
    }

    public CustomerLocationServiceException(String message) {
        super(message);
    }
}
