package com.example.mtb.exceptions.handler;

import com.example.mtb.util.ErrorStructure;
import com.example.mtb.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class TheaterExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleTheaterNotFoundByIdException(TheaterNotFoundByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, "Theater with the requested ID not found");
    }

}
