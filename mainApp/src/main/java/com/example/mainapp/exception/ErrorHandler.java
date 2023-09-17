package com.example.mainapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(final NotFoundException e) {
        log.error(e.getMessage());
        return Map.of(
                "Error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "errorMessage", e.getMessage(),
                "timestamp", new SimpleDateFormat("HH:mm:ss").format(new Date())
        );
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleInternalServerError(final InternalServerErrorException e) {
        log.error(e.getMessage());
        return Map.of(
                "Error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "errorMessage", e.getMessage(),
                "timestamp", new SimpleDateFormat("HH:mm:ss").format(new Date())
        );
    }
}
