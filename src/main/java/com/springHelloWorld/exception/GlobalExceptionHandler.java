package com.springHelloWorld.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

import static com.springHelloWorld.exception.ErrorCodes.ERR_122;

@ControllerAdvice
@Slf4j
@Getter
@Setter
public class GlobalExceptionHandler {

 /*   @ExceptionHandler(value
            = { StudentNotFoundException.class,IllegalArgumentException.class, IllegalStateException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException exception) {
        log.error("Handling Exception... Caught exception: {}",ExceptionUtils.getStackTrace(exception));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }*/

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionResponse handleEmployeeNotFound(
            StudentNotFoundException exception, final HttpServletRequest request) {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.setRequestedURI(request.getRequestURI());
        error.setErrorCode(ERR_122.getErrorCode()+" :: "+ERR_122.getErrorMessage());

        return error;
    }
}
