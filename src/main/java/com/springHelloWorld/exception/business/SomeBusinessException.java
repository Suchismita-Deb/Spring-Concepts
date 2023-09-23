package com.springHelloWorld.exception.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
public class SomeBusinessException extends RuntimeException {
    public SomeBusinessException(String message) {
        super(message);
    }
}
