package com.springHelloWorld.exception.business;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//@ResponseStatus(HttpStatus.NO_CONTENT)
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}